package com.example.recipes1.service;

import java.io.File;

public interface FileServiceIngredient {

    boolean saveToFile(String json);

    File getDataFile();

    String readFromFile();

    boolean cleanDataFile();
}
