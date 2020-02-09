package com.planty.logasventor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;

import com.planty.app.R;

public class Addproducts extends AppCompatActivity {
ImageView  back;
CardView yescard;
CardView nocard;
Boolean yes=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addproducts);
        back=findViewById(R.id.back_img2);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        yescard=findViewById(R.id.cardyes);
        nocard=findViewById(R.id.nocard);
//        nocard.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(!yes){
//                  Log.e("1","-----");
//                    yescard.setCardBackgroundColor(getResources().getColor(R.color.bg_grey_3));
//
//                    nocard.setCardBackgroundColor(getResources().getColor(R.color.cardyes));
//                yes=true;
//            }else{
//                    Log.e("2","-----");
//                    yescard.setCardBackgroundColor(getResources().getColor(R.color.cardyes));
//                    nocard.setCardBackgroundColor(getResources().getColor(R.color.bg_grey_3));
//                    yes=false;
//                }
//
//
//            }
//        });
    }
}
