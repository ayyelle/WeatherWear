package com.example.anna.hackathon;

/**
 * Created by Anna on 2015-05-06.
 */
import java.util.LinkedList;
import java.util.List;

/**
 * Created by laurencoombe and annaleong on 15-03-28.
 */
public class Closet {


    List<Clothing> clothing;

    public Closet() {
        clothing = new LinkedList<Clothing>();
        setUp();
    }

    private void setUp() {

        clothing.add(new Clothing("Parka", -50, 0, "neutral"));

        clothing.add(new Clothing("Gloves", -50, 0, "neutral"));
        clothing.add(new Clothing("Toque", -50, 0, "neutral"));
        clothing.add(new Clothing("Pants", -50, 20, "neutral"));
        clothing.add(new Clothing("Sweater", -50, 7, "neutral"));
        clothing.add(new Clothing("Jacket", 0, 7, "neutral"));
        clothing.add(new Clothing("Boots", 0, 7, "neutral"));
        clothing.add(new Clothing("Sweatshirt", 7, 14, "neutral"));
        clothing.add(new Clothing("Flats", 7, 20, "female"));
        clothing.add(new Clothing("Sneakers", 7, 20, "neutral"));
        clothing.add(new Clothing("Skirt", 7, 25, "female"));
        clothing.add(new Clothing("Tights", 7, 14, "female"));
        clothing.add(new Clothing("Dress", 7, 25, "female"));
        clothing.add(new Clothing("Capris", 14, 20, "female"));
        clothing.add(new Clothing("Light Sweatshirt", 14, 20, "neutral"));
        clothing.add(new Clothing("Cardigan", 14, 20, "female"));
        clothing.add(new Clothing("T-shirt", 14, 50, "neutral"));
        clothing.add(new Clothing ("Scarf", -50, 7, "neutral", "wind"));
        clothing.add(new Clothing ("Windbreak", 7, 20, "neutral", "wind"));
        clothing.add (new Clothing ("Rainboots", 7, 14, "female", "rain"));

        clothing.add(new Clothing ("Waterproof Shoes", 7, 20, "neutral", "rain"));
        clothing.add(new Clothing ("Shorts", 21, 100, "neutral"));
        clothing.add(new Clothing ("Tank top", 25, 100, "neutral"));
        clothing.add(new Clothing ("Flip flops", 25, 100, "neutral"));
        clothing.add(new Clothing ("Sundress", 25, 100, "female"));


        clothing.add(new Clothing ("Sandals", 21, 100, "neutral"));
        clothing.add(new Clothing("Warm Boots", -50, 0, "neutral"));

        clothing.add(new Clothing ("Umbrella", -50, 50, "neutral", "rain"));
        clothing.add(new Clothing ("Sunglasses", 25, 100, "female"));
        clothing.add(new Clothing ("Hat", 21, 100, "neutral"));

    }

    public List<Clothing> getAllClothes() {
        return clothing;
    }

    public List<Clothing> getNeutralClothes() {
        List<Clothing> filteredClothes = new LinkedList<Clothing>();
        for (Clothing c : clothing) {
            if (c.getGender().equals("neutral")) {
                filteredClothes.add(c);
            }

        }
        return filteredClothes;
    }



}