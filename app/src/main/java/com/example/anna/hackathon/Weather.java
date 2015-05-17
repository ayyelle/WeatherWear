package com.example.anna.hackathon;

/**
 * Created by laurencoombe and annaleong on 15-03-28.
 */
public class Weather {

    String cityName;
    String countryName;

    double temp;
    String description;
    String icon;

    public Weather(String cityName, String countryName, double temp, String description, String icon) {
        this.cityName = cityName;
        this.countryName = countryName;
        this.temp = temp - 272.15;
        this.description = description;
        this.icon = icon;

    }


    //Getters and Setters
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }

}