package com.example.vinofind.service;

class TransformDataFilter {
    public String transformData(String[] wineries) {
        StringBuilder formattedData = new StringBuilder();

        // Add the header line
        formattedData.append("ID, Latitude, Longitude, Name\n");

        for (String winery : wineries) {
            String[] fields = winery.split(",");
            formattedData.append(fields[1]).append(",")
                    .append(fields[2]).append(",")
                    .append(fields[0]).append(",")
                    .append(fields[3]).append("\n");
        }
        return formattedData.toString();
    }
}
