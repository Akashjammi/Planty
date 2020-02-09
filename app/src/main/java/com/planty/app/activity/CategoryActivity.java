package com.planty.app.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.planty.app.R;
import com.planty.app.customclass.CustomAppCompatActivity;
import com.planty.app.fragments.FragmentSellerInformation;
import com.planty.app.fragments.FragmentProductCategory;
import com.planty.app.fragments.FragmentSellerProductDetail;
import com.planty.app.fragments.IOnBackPressed;
import com.planty.app.utils.ValueUtils;

public class CategoryActivity extends CustomAppCompatActivity {

    final public static int FRAGMENT_SELLER_INFORMATION = 1;
    final public static int FRAGMENT_SELLER_CATEGORY = 2;
    final public static int FRAGMENT_SELLER_PRODUCT_DETAIL = 3;

    LinearLayout product_detail_indicator_ly, category_indicator_ly, information_indicator_ly;
    TextView product_details_tv, category_tv, information_tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);


        getIntents();
        initializeViews();
        setUpValues();
        setUpListeners();

        setUpValues();


    }

    public void getIntents() {


    }

    public void initializeViews() {

        product_detail_indicator_ly = findViewById(R.id.product_detail_indicator_ly);
        category_indicator_ly = findViewById(R.id.category_indicator_ly);
        information_indicator_ly = findViewById(R.id.information_indicator_ly);

        product_details_tv = findViewById(R.id.product_details_tv);
        category_tv = findViewById(R.id.category_tv);
        information_tv = findViewById(R.id.information_tv);

    }

    public void setUpValues() {


        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentSellerInformation fragmentSellerInformation = new FragmentSellerInformation();
        fragmentTransaction.add(R.id.fragment_activity, fragmentSellerInformation, FragmentSellerInformation.class.getSimpleName());
        fragmentTransaction.commit();

        information_indicator_ly.setBackgroundColor(ValueUtils.color_selected);
        information_tv.setTextColor(ValueUtils.color_selected);


    }

    public void setUpListeners() {

    }


    public void moveNextFragment(int current_frg) {


        Log.e("moveNextFragment", current_frg + "++++++");

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


        information_indicator_ly.setBackgroundColor(ValueUtils.color_deselected_bg);
        product_detail_indicator_ly.setBackgroundColor(ValueUtils.color_deselected_bg);
        category_indicator_ly.setBackgroundColor(ValueUtils.color_deselected_bg);

        information_tv.setTextColor(ValueUtils.color_deselected);
        category_tv.setTextColor(ValueUtils.color_deselected);
        product_details_tv.setTextColor(ValueUtils.color_deselected);


        switch (current_frg) {


            case FRAGMENT_SELLER_CATEGORY:

                category_indicator_ly.setBackgroundColor(ValueUtils.color_selected);
                category_tv.setTextColor(ValueUtils.color_selected);

                FragmentProductCategory fragmentProductCategory = new FragmentProductCategory();
                fragmentTransaction.replace(R.id.fragment_activity, fragmentProductCategory, FragmentProductCategory.class.getSimpleName());
                break;
            case FRAGMENT_SELLER_INFORMATION:

                information_indicator_ly.setBackgroundColor(ValueUtils.color_selected);
                information_tv.setTextColor(ValueUtils.color_selected);


                FragmentSellerInformation fragmentSellerInformation = new FragmentSellerInformation();
                fragmentTransaction.replace(R.id.fragment_activity, fragmentSellerInformation, FragmentSellerInformation.class.getSimpleName());

                break;
            case FRAGMENT_SELLER_PRODUCT_DETAIL:

                product_detail_indicator_ly.setBackgroundColor(ValueUtils.color_selected);
                product_details_tv.setTextColor(ValueUtils.color_selected);


                FragmentSellerProductDetail fragmentSellerProductDetail = new FragmentSellerProductDetail();
                fragmentTransaction.replace(R.id.fragment_activity, fragmentSellerProductDetail, FragmentSellerProductDetail.class.getSimpleName());

                break;


        }
        fragmentTransaction.commit();
    }
    @Override public void onBackPressed() {


        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_activity);
        if (!(fragment instanceof IOnBackPressed) || !((IOnBackPressed) fragment).onBackPressed()) {
            super.onBackPressed();
        }        }

}