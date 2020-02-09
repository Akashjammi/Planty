package com.planty.app.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.planty.app.R;
import com.planty.app.activity.MainActivity;

import java.util.ArrayList;
import java.util.List;


public class FragmentSellerProductDetail extends Fragment  {

    LinearLayout submit_ly;
    Boolean Checked_state = false;
    CheckBox manufaturer;
    CheckBox reseller;
    CheckBox importer;
    Button butonslectop;
    Spinner spinner_f_quant;


    public static FragmentSellerProductDetail newInstance() {

        final FragmentSellerProductDetail fragment = new FragmentSellerProductDetail();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle sis) {

        final View view = inflater.inflate(R.layout.fragment_seller_product_detail, parent, false);

        getIntents();
        initializeViews(view);
        setUpValues();
        setUpListeners();

        return view;
    }


    public void getIntents() {


    }

    public void initializeViews(View view) {
        butonslectop = view.findViewById(R.id.button_selectop);

        submit_ly = view.findViewById(R.id.proceed2_ly);
        manufaturer = view.findViewById(R.id.manu_check);
        importer = view.findViewById(R.id.importer_check);
        spinner_f_quant=view.findViewById(R.id.spinner_f_quant);
        reseller = view.findViewById(R.id.reseller_check);
        List<String> categories = new ArrayList<String>();
        categories.add("0-5");
        categories.add("6-20");
        categories.add("21-50");
        categories.add("51-500");
        categories.add("Greater than 500");
        ArrayAdapter<String> dataAdapter=new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_dropdown_item,categories);
        spinner_f_quant.setAdapter(dataAdapter);




    }

    public void setUpValues() {
    }

    public void setUpListeners() {
        butonslectop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinner_f_quant.setEnabled(true);
                spinner_f_quant.performClick();
            }
        });

        spinner_f_quant.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String spinner_value = spinner_f_quant.getSelectedItem().toString();
                butonslectop.setText(spinner_value);
                Log.e("onItemSelected: ", "ksjdk");


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });








        manufaturer.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    disablechecks(1);

                }
            }
        });
        reseller.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    disablechecks(2);

                }
            }
        });
        importer.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    disablechecks(3);

                }
            }
        });


        submit_ly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
//        Intent intent=new Intent(getActivity(), ActiveInactive.class);
                startActivity(intent);
            }
        });

    }


    public void disablechecks(int id) {
        switch (id) {
            case 1:
                reseller.setChecked(false);
                importer.setChecked(false);
                break;

            case 2:
                manufaturer.setChecked(false);
                importer.setChecked(false);
                break;

            case 3:
                manufaturer.setChecked(false);
                reseller.setChecked(false);
                break;


        }


    }



}