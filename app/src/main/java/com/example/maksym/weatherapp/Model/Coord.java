package com.example.maksym.weatherapp.Model;

/**
 * Created by Maksym on 14.12.2017.
 */

public class Coord {

    private double lat;
    private double lng;

    public Coord(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }
}
