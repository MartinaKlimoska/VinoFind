package com.example.vinofind.service;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

class FetchDataFilter {
    public String fetchData() throws IOException {
        String overpassUrl = "http://overpass-api.de/api/interpreter";
        String overpassQuery = "[out:json];" +
                "area[\"ISO3166-1\"=\"MK\"][admin_level=2];" +
                "(node[\"shop\"=\"wine\"](area);" +
                "way[\"shop\"=\"wine\"](area);" +
                "rel[\"shop\"=\"wine\"](area);" +
                ");" +
                "out center;";

        URL url = new URL(overpassUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.getOutputStream().write(overpassQuery.getBytes("UTF-8"));

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();
        connection.disconnect();
        String jsonResponse = response.toString();
        try (FileWriter fileWriter = new FileWriter("output.json")) {
            fileWriter.write(jsonResponse);
        }
        return response.toString();
    }
}