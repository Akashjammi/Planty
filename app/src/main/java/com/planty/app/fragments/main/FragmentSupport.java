package com.planty.app.fragments.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.planty.app.R;




/**
 * Created by logas on 2019/05/12.
 */

public class FragmentSupport extends Fragment {



    public static FragmentSupport newInstance() {

        final FragmentSupport fragment = new FragmentSupport();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle sis) {

        final View view = inflater.inflate(R.layout.common_fragment_recyclerview, parent, false);

        getIntents();
        initializeViews(view);
        setUpListeners();
        setUpValues();
        return view;

    }


    public void getIntents() {


    }


    public void initializeViews(View view) {

    }

    public void setUpValues() {
    }

    public void setUpListeners() {


    }




}
