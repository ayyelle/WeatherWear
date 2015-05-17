package com.example.anna.hackathon;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * Created by laurencoombe and annaleong on 15-03-28.
 */
public class callURL {

    public  Weather input (String url){

        //"http://api.openweathermap.org/data/2.5/weather?q="+city+","+country"
        //http://api.openweathermap.org/data/2.5/weather?q=London,ca
        Weather weatherObject = null;

        try {
            String weatherCall = getWeatherCall(url);
            Parser parser = new Parser();
            weatherObject = parser.parse(weatherCall);



        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return weatherObject;
    }



    public String getWeatherCall(String httpRequest) throws MalformedURLException, IOException {


        URL url = new URL(httpRequest);
        HttpURLConnection client = (HttpURLConnection) url.openConnection();
        InputStream in = new BufferedInputStream(client.getInputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String returnString = br.readLine();
        client.disconnect();
        return returnString;

    }

}
