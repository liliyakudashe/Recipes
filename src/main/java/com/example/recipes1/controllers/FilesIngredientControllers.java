package com.example.recipes1.controllers;
import com.example.recipes1.service.FileServiceIngredient;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


@RestController
@RequestMapping("/files/ingredient")
public class FilesIngredientControllers {
    private final FileServiceIngredient fileServiceInterfaceIngredient;

    public FilesIngredientControllers(FileServiceIngredient fileServiceInterfaceIngredient) {
        this.fileServiceInterfaceIngredient = fileServiceInterfaceIngredient;
    }

    @PostMapping(value = "/import", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> uploadDataFile(@RequestParam MultipartFile file){
        fileServiceInterfaceIngredient.cleanDataFile();
        File dataFile = fileServiceInterfaceIngredient.getDataFile();
        try (FileOutputStream fos = new FileOutputStream(dataFile)){
            IOUtils.copy(file.getInputStream(), fos);
            return ResponseEntity.ok().build();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

}
