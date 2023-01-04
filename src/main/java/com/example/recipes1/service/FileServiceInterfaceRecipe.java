package com.example.recipes1.service;

import java.io.File;

public interface FileServiceInterfaceRecipe {

    boolean saveToFile(String json);

    File getDataFile();

    String readFromFile();


}
