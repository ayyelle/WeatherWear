package com.example.anna.hackathon;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by laurencoombe and annaleong on 15-03-28.
 */
public class Female {


    private Closet closet;
    private List<Clothing> clothingList;
    private String description;


    public Female() {
        closet = new Closet();
        clothingList = closet.getAllClothes();


    }

    public List<Clothing> getClothing(Weather w) {
        double temp = w.getTemp();
        description = w.getDescription();
        List<Clothing> returnClothingList = new LinkedList<Clothing>();
        if (temp <= 0) {
            List<Clothing> subzeroClothing = getClothingRange(-50, 0);
            returnClothingList.addAll(subzeroClothing);
        } else if ((temp > 0) && (temp <= 7)) {
            List<Clothing> coldClothing = getClothingRange(0, 7);
            returnClothingList.addAll(coldClothing);
        } else if ((temp > 7) && (temp <= 14)) {
            List<Clothing> midClothing = getClothingRange(8, 14);
            returnClothingList.addAll(midClothing);
        } else if ((temp > 14) && (temp <= 20)) {
            List<Clothing> warmClothing = getClothingRange(15, 20);
            returnClothingList.addAll(warmClothing);
        } else if ((temp > 20) && (temp <= 24)) {
            List<Clothing> veryWarmClothing = getClothingRange(21, 24);
            returnClothingList.addAll(veryWarmClothing);
        } else if (temp > 24) {
            List<Clothing> hotClothing = getClothingRange(25, 50);
            returnClothingList.addAll(hotClothing);
        }

        if (description.equals("Rain")) {
            List<Clothing> rainClothing = getClothingKeyWord("rain");
            returnClothingList.addAll(rainClothing);
        } else if (description.equals("wind")) {
            List<Clothing> windClothing = getClothingKeyWord("wind");
            returnClothingList.addAll(windClothing);
        }


        return returnClothingList;
    }


    private List<Clothing> getClothingKeyWord(String string) {
        List<Clothing> listClothing = new LinkedList<Clothing>();
        for (Clothing c : clothingList) {
            if (c.getKeywords().equals(string)) {
                listClothing.add(c);
            }
        }
        return listClothing;
    }

    private List<Clothing> getClothingRange(int min, int max) {
        List<Clothing> listClothing = new LinkedList<Clothing>();
        for (Clothing c : clothingList) {
            if ((c.getMinTemp() <= min) && (c.getMaxTemp() >= max) && !((c.getKeywords().equals("rain")) || (c.getKeywords().equals("wind")))) {
                listClothing.add(c);
            }
        }
        return listClothing;
    }
}