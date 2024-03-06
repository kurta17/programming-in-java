package com.harbourspace.lesson07;

// CityStatistics implementation
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CityStatistics implements Statistics {
    private List<City> cities;

    public CityStatistics(List<City> cities) {
        this.cities = cities;
    }

    @Override
    public Collection<City> getTopCountryCities(String country, int size) {
        List<City> result = new ArrayList<>();
        for (City city : cities) {
            if (city.getCountry().equalsIgnoreCase(country)) {
                result.add(city);
            }
        }
        result.sort(null); // Sorting based on compareTo method in City class
        return result.subList(0, Math.min(size, result.size()));
    }
}
