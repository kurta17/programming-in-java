package com.harbourspace.lesson07;

// CSVDataWriter implementation
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVDataWriter implements DataWriter {
    @Override
    public void writeData(List<City> cities, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("city|country|population\n");
            for (City city : cities) {
                writer.write(city.getName() + "|" + city.getCountry() + "|" + city.getPopulation() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
