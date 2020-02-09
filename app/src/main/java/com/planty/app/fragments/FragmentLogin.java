package com.planty.app.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.planty.app.R;
import com.planty.app.activity.LoginActivity;


public class FragmentLogin extends Fragment {

    LinearLayout login, message_ly;
    TextView signup;


    public static FragmentLogin newInstance() {

        final FragmentLogin fragment = new FragmentLogin();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle sis) {

        final View view = inflater.inflate(R.layout.fragment_login, parent, false);
        login = view.findViewById(R.id.login);
        signup = view.findViewById(R.id.signup);


        setUpValues();
        setUpListeners();

        return view;
    }






    public void setUpValues() {
    }

    public void setUpListeners() {


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((LoginActivity) getActivity()).moveNextFragment(LoginActivity.FRAGMENT_OTP_CALL);
            }
        });

    }


}


