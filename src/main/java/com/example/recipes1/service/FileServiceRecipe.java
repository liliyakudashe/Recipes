package com.example.recipes1.service;

import java.io.File;

public interface FileServiceRecipe {

    boolean saveToFile(String json);

    File getDataFile();

    String readFromFile();


    boolean cleanDataFile();
}
