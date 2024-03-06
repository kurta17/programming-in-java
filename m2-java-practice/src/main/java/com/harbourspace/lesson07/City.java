package com.harbourspace.lesson07;
// City class
public class City implements Comparable<City> {
    private String name;
    private String country;
    private long population;

    public City(String name, String country, long population) {
        this.name = name;
        this.country = country;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public long getPopulation() {
        return population;
    }

    @Override
    public int compareTo(City other) {
        return Long.compare(other.population, this.population);
    }
}
