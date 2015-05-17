package com.example.anna.hackathon;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 * Created by laurencoombe and annaleong on 15-03-28.
 */
public class Parser {

    public Weather parse(String weatherCall) {

        String mainDescription = null;
        String country = null;
        String city = null;
        double temp = 0;
        String icon = null;

        try{
            //JSONTokener tokener = new JSONTokener(routingCall);
            JSONObject obj = new JSONObject(weatherCall);

            JSONObject sys = obj.getJSONObject("sys");
            country = sys.getString("country");
            city = obj.getString("name");

            JSONArray arr = obj.getJSONArray("weather");
            System.out.println(arr);

            for (int i = 0; i < arr.length(); i++)
            {
                mainDescription = arr.getJSONObject(i).getString("main");
                System.out.println(mainDescription);
//
//                String description = arr.getJSONObject(i).getString("description");
//                System.out.println(description);

                icon = arr.getJSONObject(i).getString("icon");
            }

            JSONObject mainValues = obj.getJSONObject("main");
            System.out.println(mainValues);
            temp = mainValues.getDouble("temp");
            System.out.println(temp);


        }catch (Exception e){
            e.printStackTrace();
        }

        Weather newWeatherObject = new Weather(city,country,temp,mainDescription, icon);

        return newWeatherObject;

    }
}