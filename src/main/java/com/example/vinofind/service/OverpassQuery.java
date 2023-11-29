package com.example.vinofind.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class OverpassQuery {

    private WriteToDB writeToDB;

    @Autowired
    public OverpassQuery(WriteToDB writeToDB) {
        this.writeToDB = writeToDB;
    }

    public void execute() throws IOException {
        String jsonResponse = new FetchDataFilter().fetchData();
        String[] elements = new ParseJSONFilter().parseJSON(jsonResponse);
        String csvData = new TransformDataFilter().transformData(elements);
        new WriteToFileFilter().writeToFile("Final.csv", csvData);
        writeToDB.writeToDb(elements);
    }
}