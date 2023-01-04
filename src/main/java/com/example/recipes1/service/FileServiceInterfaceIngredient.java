package com.example.recipes1.service;

import java.io.File;

public interface FileServiceInterfaceIngredient {

    boolean saveToFile(String json);

    File getDataFile();

    String readFromFile();
}
