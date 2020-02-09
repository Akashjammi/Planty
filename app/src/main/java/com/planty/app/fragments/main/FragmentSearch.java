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

public class FragmentSearch extends Fragment {


    public static FragmentSearch newInstance() {

        final FragmentSearch fragment = new FragmentSearch();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle sis) {

        final View view = inflater.inflate(R.layout.common_fragment_recyclerview, parent, false);

        return view;


    }

    @Override
    public void onViewCreated(View view, Bundle sis) {
        super.onViewCreated(view, sis);

        getIntents();
        setUpListeners();
    }

    public void getIntents() {


    }


    public void setUpListeners() {


    }


}
