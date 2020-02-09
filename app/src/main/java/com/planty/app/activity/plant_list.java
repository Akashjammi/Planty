package com.planty.app.activity;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.planty.MyListAdapter;
import com.planty.app.MyListData;
import com.planty.app.R;
import com.planty.app.customclass.JSONParser;
import com.planty.app.fragments.FragmentOtpCall;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class plant_list extends AppCompatActivity {
    ArrayList<MyListData> plantdetails;
    JSONArray schooldetails;
    MyListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_list);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        plantdetails = new ArrayList<>();
        adapter = new MyListAdapter(plantdetails);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        getBusList();
    }


    private void getBusList() {
        class SendPostReqAsyncTask extends AsyncTask<String, Void, String> {
            @Override
            protected String doInBackground(String... params) {

                JSONParser jParser = new JSONParser();

                JSONObject json = jParser.getJSONFromUrl("http://plant123456.000webhostapp.com/plantsofuser.php?user="+ FragmentOtpCall.username);
                try {
                    schooldetails = json.getJSONArray("server_response");
                    for (int i = 0; i < schooldetails.length(); i++) {
                        JSONObject c = schooldetails.getJSONObject(i);

                            plantdetails.add(new MyListData(c.getString("pname"),c.getString("details"),R.drawable.man));
                            Log.e("plant added",c.getString("pname"));

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);

                adapter.notifyDataSetChanged();
            }
        }

        SendPostReqAsyncTask sendPostReqAsyncTask = new SendPostReqAsyncTask();
        sendPostReqAsyncTask.execute();
    }








}
