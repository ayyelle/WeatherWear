package com.example.anna.hackathon;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.InputStream;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.List;

import static android.app.PendingIntent.getActivity;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private EditText country;
    private EditText city;
    private EditText genderSelect;
    private String gender;
    private String cityName;
    private String countryName;


    public void buttonOnClick(View v) {
        Button button = (Button) v;
        //button.setText("I've Been Clicked!!");
        TextView myTextView = (TextView) findViewById(R.id.clothingList);

        city = (EditText) findViewById(R.id.city);
        country = (EditText) findViewById(R.id.country);
        genderSelect = (EditText) findViewById(R.id.genderSelect);


        cityName = city.getText().toString();
        countryName = country.getText().toString();
        gender = genderSelect.getText().toString();

        if (cityName.equals("") || countryName.equals("")) {
            AlertDialog abox = createSimpleDialog("Please do not leave any fields blank!");
            abox.show();

        }

        callURL url = new callURL();
        // Weather weatherObj = url.input(cityName, countryName, gender);
        new getHTTPCall().execute("http://api.openweathermap.org/data/2.5/weather?q="+cityName+","+countryName);





    }

    private class getHTTPCall extends AsyncTask<String, Void, String> {
        String httpCall;

        @Override
        protected String doInBackground(String ... params) {
            this.httpCall = params[0];
            callURL url = new callURL();
            String weatherInfo = null;
            try {
                weatherInfo = url.getWeatherCall(httpCall);
            }
            catch (Exception e) {
                e.printStackTrace();

                return "error";


            }
            return weatherInfo;


        }

        protected void onPostExecute(String weatherInfo) {
            if (weatherInfo.equals("error")) {
                AlertDialog abox = createSimpleDialog("Oh no! Can't access internet! Try Again Later :(");
                abox.show();
            } else {
                if (weatherInfo.contains("Error")) {
                    AlertDialog abox = createSimpleDialog("Oh no! Check your spelling and try again!");
                    abox.show();
                } else {
                    Parser parser = new Parser();
                    Weather weather = parser.parse(weatherInfo);
                    String genderLower = gender.toLowerCase();
                    List<Clothing> clothing = null;
                    if (genderLower.equals("female")) {
                        Female femaleGen = new Female();
                        clothing = femaleGen.getClothing(weather);
                    } else {
                        NeutralGender neutralGen = new NeutralGender();
                        clothing = neutralGen.getClothing(weather);
                    }
                    String returnString = "";
                    for (Clothing c : clothing) {
                        returnString = returnString + c.getName() + "\n";
                    }

                    TextView myTextView = (TextView) findViewById(R.id.clothingList);
                    myTextView.setText(returnString);

                    double temp = weather.getTemp();
                    DecimalFormat df = new DecimalFormat("#.##");
                    String tempFormat = df.format(temp);
                    String weatherDeclaration = "Current weather conditions for " + weather.getCityName() + ", " + weather.getCountryName() + ":" + "  " + weather.getDescription() + ", " + tempFormat + "°C";
                    TextView weatherConditions = (TextView) findViewById(R.id.currentWeatherDeclaration);
                    weatherConditions.setText(weatherDeclaration);


                    String icon = weather.getIcon();
                    String iconURL = "https://openweathermap.org/img/w/" + icon + ".png";
                    new getIcon().execute(iconURL);

                }
            }



//            TextView myTextView = (TextView) findViewById(R.id.textView);
//            myTextView.setText(weather.getDescription());
        }

    }


    private class getIcon extends AsyncTask<String, Void, Drawable> {
        String url;

        @Override
        protected Drawable doInBackground(String ... params) {
            this.url = params[0];
            try {
                InputStream is = (InputStream) new URL(url).getContent();
                Drawable d = Drawable.createFromStream(is, "src name");
                return d;
            } catch (Exception e) {
                return null;
            }


        }

        protected void onPostExecute(Drawable pic) {

            ImageView displayPicture = (ImageView) findViewById(R.id.displayPic);

            displayPicture.setImageDrawable(pic);

            TextView clothing = (TextView) findViewById(R.id.clothingList);
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(200, 200);
            params.leftMargin = clothing.getLeft() + 250;
            params.topMargin = clothing.getTop() - 100;
            displayPicture.setLayoutParams(params);


        }

    }

    private AlertDialog createSimpleDialog(String msg) {
        AlertDialog.Builder dialogBldr = new AlertDialog.Builder(this);
        dialogBldr.setMessage(msg);
        dialogBldr.setNeutralButton("Okay", null);
        return dialogBldr.create();

    }

//
//    public Drawable LoadImageFromWeb(String url) {
//        try {
//            InputStream is = (InputStream) new URL(url).getContent();
//            Drawable d = Drawable.createFromStream(is, "src name");
//            return d;
//        } catch (Exception e) {
//           return null;
//        }
//    }



}