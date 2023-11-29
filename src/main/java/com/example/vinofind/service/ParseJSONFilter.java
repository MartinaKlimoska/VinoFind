package com.example.vinofind.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class ParseJSONFilter {
    public String[] parseJSON(String jsonData) {
        jsonData = readJsonFromFile("output.json");
        int elementsStartIndex = jsonData.indexOf("\"elements\": [") + "\"elements\": [".length();
        int elementsEndIndex = jsonData.lastIndexOf("]");
        String elementsData = jsonData.substring(elementsStartIndex, elementsEndIndex);
        String[] elementStrings = elementsData.split("\\},\\s*");

        List<String> wineryList = new ArrayList<>();

        for (String elementString : elementStrings) {
            String id = extractField(elementString, "\"id\":");
            String lat = extractField(elementString, "\"lat\":");
            String lon = extractField(elementString, "\"lon\":");
            String nameEn = extractField(elementString, "\"name:en\":");
            String wineryData = id + "," + lat + "," + lon + "," + nameEn;
            wineryList.add(wineryData);
        }

        String[] wineries = wineryList.toArray(new String[0]);
        for (String winery : wineries) {
            System.out.println(winery);
        }
        return wineries;
    }
    private static String extractField(String elementString, String field) {
        int startIndex = elementString.indexOf(field) + field.length();
        int endIndex = elementString.indexOf(",", startIndex);
        if (endIndex == -1) {
            endIndex = elementString.indexOf("}", startIndex);
        }
        return elementString.substring(startIndex, endIndex).trim().replace("\"", "");
    }

    private static String readJsonFromFile(String fileName) {
        StringBuilder jsonData = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                jsonData.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonData.toString();
    }
}