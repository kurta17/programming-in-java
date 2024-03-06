package com.harbourspace.lesson07;

// CSVDataReader implementation
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVDataReader implements DataReader {
    @Override
    public List<City> readData(String filePath) {
        List<City> cities = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Skip the header line
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                String name = parts[0];
                String country = parts[4];
                long population = Long.parseLong(parts[9]);
                cities.add(new City(name, country, population));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cities;
    }
}

