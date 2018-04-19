package com.example.maksym.weatherapp.Helper;

import java.util.ArrayList;

/**
 * Created by Maksym on 15.12.2017.
 */

public class WeatherAdapter {

    private double min_temp;
    private double max_temp;
    private String discription;
    private double pressure;
    private String icon;

    public WeatherAdapter(ArrayList<Double> tmpMin, ArrayList<Double> tmpMax,ArrayList<Double> press,ArrayList<String> des,ArrayList<String> icon,ArrayList<Integer> indexes) {
        this.min_temp = minTemp(tmpMin,indexes);
        this.max_temp = maxTemp(tmpMax,indexes);
        this.discription = des.get(Math.abs(des.size()/2));
        this.pressure = averagePressure(press,indexes);
        this.icon = icon.get(Math.abs(icon.size()/2));
    }

    public double getMin_temp() {
        return min_temp;
    }

    public void setMin_temp(double min_temp) {
        this.min_temp = min_temp;
    }

    public double getMax_temp() {
        return max_temp;
    }

    public void setMax_temp(double max_temp) {
        this.max_temp = max_temp;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    private double minTemp(ArrayList<Double> tempm, ArrayList<Integer> index){
        double temp[];
        temp = new double[index.size()];
        double m = 0;
        for(int i = 0; i < temp.length;i++){
            temp[i] = tempm.get(index.get(i));
        }

        if(temp.length==1) {
            m = temp[0];
        }else{
            m = temp[1];
        for(int i = 0; i < temp.length;i++){
            if(m > temp[i]) {
                m = temp[i];
            }
        }}

        return m;
    }

    private double maxTemp(ArrayList<Double> tempm, ArrayList<Integer> index){
        double temp[] = new double[index.size()];
        double m = 0;
        for(int i = 0; i < temp.length;i++){
            temp[i] = tempm.get(index.get(i));
        }
        if(temp.length==1) {
            m = temp[0];
        }
        else{
            m = temp[1];
        for(int i = 0; i < temp.length;i++){
            if(m < temp[i]) {
                m = temp[i];
            }
        }}
        return m;
    }

    private double averagePressure(ArrayList<Double> tempm, ArrayList<Integer> index){
        double ap = 0.0;


        for(int i = 0; i < index.size() ;i++){

           ap +=tempm.get(index.get(i));

        }

        return ap/index.size();
    }





}
