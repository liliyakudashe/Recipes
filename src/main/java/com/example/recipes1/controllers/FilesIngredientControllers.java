package com.example.recipes1.controllers;

import com.example.recipes1.service.FileServiceInterfaceIngredient;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@RestController
@RequestMapping("/files/ingredient")
public class FilesIngredientControllers {
    private final FileServiceInterfaceIngredient fileServiceInterfaceIngredient;

    public FilesIngredientControllers(FileServiceInterfaceIngredient fileServiceInterfaceIngredient) {
        this.fileServiceInterfaceIngredient = fileServiceInterfaceIngredient;
    }

    @GetMapping("/export/ingredient")
    public ResponseEntity<InputStreamResource> dowloadDataFile() throws FileNotFoundException {
       File file = fileServiceInterfaceIngredient.getDataFile();

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
