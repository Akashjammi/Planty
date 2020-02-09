package com.planty.app.customclass;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.planty.app.R;
import com.planty.app.fragments.main.Inactive;

public class ActiveInactive extends CustomAppCompatActivity {
Boolean searchbarenabled= false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_inactive);
        final ImageView back = findViewById(R.id.back_img);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        final EditText searchbar = findViewById(R.id.searchtoolbar);
        final TextView tooltext = findViewById(R.id.texttoolbar);
        final ImageView search= findViewById(R.id.searchtb);
//        search.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(!searchbarenabled) {
//                    searchbar.setVisibility(View.VISIBLE);
//                    tooltext.setVisibility(View.INVISIBLE);
//                    searchbarenabled=true;
//                }
//                    else{
//                    searchbar.setVisibility(View.INVISIBLE);
//                    tooltext.setVisibility(View.VISIBLE);
//                    searchbarenabled=false;
//
//
//                }
//
//
//
//            }
//        });

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Inactive fragmentActiveProcess = new Inactive();
        fragmentTransaction.add(R.id.activeframe, fragmentActiveProcess, Inactive.class.getSimpleName());
        fragmentTransaction.commit();




    }


}




