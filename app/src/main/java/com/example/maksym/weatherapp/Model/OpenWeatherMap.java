package com.example.maksym.weatherapp.Model;

import java.util.ArrayList;

/**
 * Created by Maksym on 15.12.2017.
 */

public class OpenWeatherMap {
    private int cod;
    private double message;
    private int cnt;
    private ArrayList<List> list;
    private City city;

    public OpenWeatherMap() {
    }

    public OpenWeatherMap(int cod, double message, int cnt, ArrayList<List> list, City city) {
        this.cod = cod;
        this.message = message;
        this.cnt = cnt;
        this.list = list;
        this.city = city;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public double getMessage() {
        return message;
    }

    public void setMessage(double message) {
        this.message = message;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public ArrayList<List> getList() {
        return list;
    }

    public void setList(ArrayList<List> list) {
        this.list = list;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
