package com.planty.app.fragments;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.planty.app.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static com.planty.app.activity.MainActivity.activity;

public class plant_list extends Fragment {

    TextView weather;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_plant_list, container, false);
        weather = view.findViewById(R.id.weather);
        findWeather(view);

        return view;
    }
    public void findWeather(View view) {

//        Log.i("cityName", cityName.getText().toString());

//        InputMethodManager mgr = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
//        mgr.hideSoftInputFromWindow(cityName.getWindowToken(), 0);

        //            String encodedCityName = URLEncoder.encode(cityName.getText()getApplicationContext.toString(), "UTF-8");

        DownloadTask task = new DownloadTask();
        task.execute("https://fcc-weather-api.glitch.me/api/current?lat=12.9625&lon=79.943282");


    }


    public class DownloadTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {

            String result = "";
            URL url;
            HttpURLConnection urlConnection = null;

            try {
                url = new URL(urls[0]);

                urlConnection = (HttpURLConnection) url.openConnection();

                InputStream in = urlConnection.getInputStream();

                InputStreamReader reader = new InputStreamReader(in);

                int data = reader.read();

                while (data != -1) {

                    char current = (char) data;

                    result += current;

                    data = reader.read();

                }

                return result;

            } catch (final Exception e) {
                activity.runOnUiThread(new Runnable() {
                    public void run() {
                Toast.makeText(getActivity(), "Could not find weather" + e, Toast.LENGTH_LONG);
                    }
                });
            }

            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            try {

                String message = "";

                JSONObject jsonObject = new JSONObject(result);

                String weatherInfo = jsonObject.getString("main");

                Log.i("Weather content", weatherInfo);
                String temp="";
                for(int i=0;i<weatherInfo.length();i++){
                    if(i >=8 && i<13){
                        temp += weatherInfo.charAt(i);

                    }

                }
                weather.setText(temp+"°C");

                JSONArray arr = new JSONArray(weatherInfo);

//                weather.setText(arr.getString(0));
                Log.e("tes",arr.get(0)+"");
                for (int i = 0; i < arr.length(); i++) {

                    JSONObject jsonPart = arr.getJSONObject(i);
                    String value = jsonPart.optString("temp");
//                    weather.setText(value+"");
                    Log.e("val",value +"");

                    String main = "";
                    String description = "";

                    main = jsonPart.getString("temp");
                    description = jsonPart.getString("description");

                    if (main != "" && description != "") {

                        message += main + ": " + description + "\r\n";

                    }

                }

                if (message != "") {

//                    weather.setText(message);

                } else {

                    Toast.makeText(getContext(), "Could not find weather", Toast.LENGTH_LONG);

                }


            } catch (JSONException e) {

                Toast.makeText(getContext(), "Could not find weather", Toast.LENGTH_LONG);

            }



        }
    }
    }


