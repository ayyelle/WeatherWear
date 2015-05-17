package com.example.anna.hackathon;

/**
 * Created by laurencoombe and annaleong on 15-03-28.
 */
public class Clothing {

    String name;
    double minTemp;
    double maxTemp;
    String keywords;
    String gender;

    public Clothing(String name, double minTemp, double maxTemp, String gender) {
        this.name = name;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        keywords = "";
        this.gender = gender;
    }

    public Clothing(String name, double minTemp, double maxTemp, String gender, String keywords) {
        this.name = name;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.gender = gender;
        this.keywords = keywords;

    }


    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(double minTemp) {
        this.minTemp = minTemp;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getGender() {
        return gender;
    }


}