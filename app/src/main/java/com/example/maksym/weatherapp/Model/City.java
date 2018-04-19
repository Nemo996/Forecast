package com.example.maksym.weatherapp.Model;

/**
 * Created by Maksym on 15.12.2017.
 */

public class City {
    private int id;
    private String name;
    private String country;
    private Coord coord;
    private String population;

    public City(int id, String name, String country, Coord coord, String population) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.coord = coord;
        this.population = population;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }
}
