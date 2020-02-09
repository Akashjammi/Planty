package com.planty.app.activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.Toast;

import com.planty.app.R;
import com.planty.app.customclass.CustomAppCompatActivity;
import com.planty.app.fragments.FragmentLogin;
import com.planty.app.fragments.FragmentOtpCall;

public class LoginActivity extends CustomAppCompatActivity {

    final public static int FRAGMENT_LOGIN = 1;
    final public static int FRAGMENT_OTP_CALL = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        getIntents();
        initializeViews();
        setUpValues();
        setUpListeners();

        setUpValues();


    }

    public void getIntents() {


    }

    public void initializeViews() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentLogin fragmentLogin = new FragmentLogin();
        fragmentTransaction.add(R.id.fragment_activity, fragmentLogin, FragmentLogin.class.getSimpleName());
        fragmentTransaction.commit();


    }

    public void setUpValues() {
        requestCameraPermission();
    }

    public void setUpListeners() {

    }


    public void moveNextFragment(int current_frg) {


        Log.e("moveNextFragment", current_frg + "++++++");

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


        switch (current_frg) {


            case FRAGMENT_LOGIN:
                FragmentLogin fragmantLogin = new FragmentLogin();
                fragmentTransaction.replace(R.id.fragment_activity, fragmantLogin, FragmentLogin.class.getSimpleName());

                break;
            case FRAGMENT_OTP_CALL:

                FragmentOtpCall fragmentOtpCall = new FragmentOtpCall();
                fragmentTransaction.replace(R.id.fragment_activity, fragmentOtpCall, FragmentOtpCall.class.getSimpleName());

                break;


        }
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


    public void requestCameraPermission() {
        int write_permission = ContextCompat.checkSelfPermission(LoginActivity.this, Manifest.permission.CAMERA);
        int location_permission = ContextCompat.checkSelfPermission(LoginActivity.this, Manifest.permission.ACCESS_FINE_LOCATION);
        int location2_permission = ContextCompat.checkSelfPermission(LoginActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION);
        int read_sms_permission = ContextCompat.checkSelfPermission(LoginActivity.this, Manifest.permission.READ_SMS);
        int read_rece_permission = ContextCompat.checkSelfPermission(LoginActivity.this, Manifest.permission.RECEIVE_SMS);
        int write_external = ContextCompat.checkSelfPermission(LoginActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int read_external = ContextCompat.checkSelfPermission(LoginActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE);


        if (android.os.Build.VERSION.SDK_INT < 22 || (write_permission == PackageManager.PERMISSION_GRANTED && location_permission == PackageManager.PERMISSION_GRANTED && location2_permission == PackageManager.PERMISSION_GRANTED)) {

        } else
            ActivityCompat.requestPermissions(LoginActivity.this, new String[]{Manifest.permission.CAMERA, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 115);

        if (android.os.Build.VERSION.SDK_INT < 22 || (read_sms_permission == PackageManager.PERMISSION_GRANTED && read_rece_permission == PackageManager.PERMISSION_GRANTED && location2_permission == PackageManager.PERMISSION_GRANTED)) {

        } else
            ActivityCompat.requestPermissions(LoginActivity.this, new String[]{Manifest.permission.CAMERA, Manifest.permission.READ_SMS, Manifest.permission.RECEIVE_SMS}, 116);

        if (android.os.Build.VERSION.SDK_INT < 22 || (read_external == PackageManager.PERMISSION_GRANTED && write_external == PackageManager.PERMISSION_GRANTED)) {

        } else
            ActivityCompat.requestPermissions(LoginActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, 117);


    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        int write_permission = ContextCompat.checkSelfPermission(LoginActivity.this, Manifest.permission.CAMERA);
        int location_permission = ContextCompat.checkSelfPermission(LoginActivity.this, Manifest.permission.ACCESS_FINE_LOCATION);
        int location_permission_2 = ContextCompat.checkSelfPermission(LoginActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION);
        int read_permission = ContextCompat.checkSelfPermission(LoginActivity.this, Manifest.permission.READ_SMS);
        int receive_permission = ContextCompat.checkSelfPermission(LoginActivity.this, Manifest.permission.RECEIVE_SMS);
        int read_external_permission = ContextCompat.checkSelfPermission(LoginActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE);
        int write_external_permission = ContextCompat.checkSelfPermission(LoginActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE);


        if (requestCode == 115) {
            if (write_permission == PackageManager.PERMISSION_GRANTED && location_permission == PackageManager.PERMISSION_GRANTED && location_permission_2 == PackageManager.PERMISSION_GRANTED) {

                Log.e("onRequestPermissions", "accepted");

            } else {
                Toast.makeText(LoginActivity.this, "Permission denied by user.", Toast.LENGTH_LONG);
            }
        }
        if (requestCode == 116) {
            if (read_permission == PackageManager.PERMISSION_GRANTED && receive_permission == PackageManager.PERMISSION_GRANTED) {

                Log.e("onRequestPermissions", "accepted");

            } else {
                Toast.makeText(LoginActivity.this, "Permission denied by user.", Toast.LENGTH_LONG);
            }
        }
        if (requestCode == 117) {
            if (read_external_permission == PackageManager.PERMISSION_GRANTED && write_external_permission == PackageManager.PERMISSION_GRANTED) {

                Log.e("camera_access", "accepted");

            } else {
                Toast.makeText(LoginActivity.this, "Permission denied by user.", Toast.LENGTH_LONG);
            }
        }
    }


}