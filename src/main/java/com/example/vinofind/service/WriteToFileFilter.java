package com.example.vinofind.service;

import java.io.FileWriter;
import java.io.IOException;

class WriteToFileFilter {
    public void writeToFile(String fileName, String data) {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}