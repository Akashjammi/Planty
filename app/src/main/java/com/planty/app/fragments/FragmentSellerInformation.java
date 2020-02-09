package com.planty.app.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import com.planty.app.R;
import com.planty.app.activity.CategoryActivity;


public class FragmentSellerInformation extends Fragment {

    RelativeLayout btn_ly;
    TimePicker timePicker1;
    TextView et8;
    TextView et9;
    TextView et5;
    TextView set;

    LinearLayout ly;
    Boolean open=true;

    public static FragmentSellerInformation newInstance() {

        final FragmentSellerInformation fragment = new FragmentSellerInformation();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle sis) {

        final View view = inflater.inflate(R.layout.fragment_seller_information, parent, false);

        getIntents();
        initializeViews(view);
        setUpValues();
        setUpListeners();

        return view;
    }


    public void getIntents() {


    }

    public void initializeViews(View view) {

        btn_ly = view.findViewById(R.id.btn_ly);
        et8=view.findViewById(R.id.et8);
        et9=view.findViewById(R.id.et9);
//        et5=view.findViewById(R.id.et5);
        ly=view.findViewById(R.id.ly);
        set=view.findViewById(R.id.set);
        timePicker1 = (TimePicker)view.findViewById(R.id.simpleTimePicker);

    }

    public void setUpValues() {
    }

    public void setUpListeners() {
        et9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("s","S");
                Log.d("s",et8.getText().toString());
                if(et8.getText().toString().equals( "00:00"))
                {     Log.d("s","enterd");

                }else{

                    ly.setVisibility(View.VISIBLE);
                }

            }
        });
        et8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("s","S");
                ly.setVisibility(View.VISIBLE);
            }
        });
        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ly.setVisibility(View.GONE);
                int hour = timePicker1.getCurrentHour();
                int min = timePicker1.getCurrentMinute();


                if(open==true) {
                    et8.setText(hour + ":" + min);
                    open=false;
                }
                else{

                    et9.setText(hour +":"+min);
                    open=true;
                }
            }
        });






        btn_ly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((CategoryActivity) getActivity()).moveNextFragment(CategoryActivity.FRAGMENT_SELLER_CATEGORY);
            }
        });


    }



}


