package com.planty.app.fragments.main;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.planty.app.R;
import com.planty.app.activity.MainActivity;

import java.io.File;


/**
 * Created by logas on 2019/05/12.
 */

public class FragmentOffer extends Fragment {
    public static String encoded_string, image_name;
    private Bitmap bitmap;
    private File file;
    public static Uri file_uri;
    LinearLayout camera;

    public static FragmentOffer newInstance() {

        final FragmentOffer fragment = new FragmentOffer();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle sis) {

        final View view = inflater.inflate(R.layout.activity_common_fragment, parent, false);
        final ImageView scan = view.findViewById(R.id.scan_plant);
        camera = view.findViewById(R.id.camera_ll);
        camera.setVisibility(View.VISIBLE);
        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("camera open","dddd");
                final int MyVersion = Build.VERSION.SDK_INT;

                        Log.e("shld camera open","dddd");
                        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        getFileUri(Math.floor(Math.random() * 1000)+"");
                        i.putExtra(MediaStore.EXTRA_OUTPUT, MainActivity.file_uri);
                        ((Activity) getActivity()).startActivityForResult(i, 10);

            }
        });


        getIntents();
        initializeViews(view);
        setUpValues();
        setUpListeners();
        return view;

    }
    private void getFileUri (String regno){
        image_name = regno + ".jpg";
        MainActivity.image_name =image_name;
        file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
                + File.separator + image_name
        );

        MainActivity.file_uri = Uri.fromFile(file);

    }
    private boolean checkIfAlreadyhavePermission() {
        int result = ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE);
        return result == PackageManager.PERMISSION_GRANTED;
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
