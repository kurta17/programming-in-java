//package com.harbourspace.lesson07;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//public interface DataReader {
//    private Collection<City> readAll(Path path) throws IOException {
//        return null;
//    }
//
//    @Override
//    public Collection<City> readAll(Path path) throws IOException {
//        List<City> cities = new ArrayList<>();
//        try (BufferedReader br = Files.newBufferedReader(path)) {
//            String line;
//            // Skipping the header line
//            br.readLine();
//            while ((line = br.readLine()) != null) {
//                String[] parts = line.split("\\|");
//                String cityName = parts[0];
//                String countryName = parts[4];
//                long population = Long.parseLong(parts[9]);
//                cities.add(new City(cityName, countryName, population));
//            }
//        }
//        return cities;
//    }






