package com.example.recipes1.controllers;

import com.example.recipes1.service.FileServiceInterfaceRecipe;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@RestController
@RequestMapping("/files")
public class FilesRecipeControllers {

    private final FileServiceInterfaceRecipe fileServiceInterfaceRecipe;

    public FilesRecipeControllers(FileServiceInterfaceRecipe fileServiceInterfaceRecipe) {
        this.fileServiceInterfaceRecipe = fileServiceInterfaceRecipe;
    }
    @GetMapping("/export")
    public ResponseEntity<InputStreamResource> dowloadDataFile() throws FileNotFoundException {
        File file = fileServiceInterfaceRecipe.getDataFile();

        if (file.exists()){
            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
            return ResponseEntity.ok()
                    .contentLength(file.length())
                    .body(resource);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}
