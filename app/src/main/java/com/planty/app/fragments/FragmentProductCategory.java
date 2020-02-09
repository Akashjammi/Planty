package com.planty.app.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.planty.app.R;
import com.planty.app.activity.CategoryActivity;


public class FragmentProductCategory extends Fragment {

    RecyclerView recycler_view;
    RelativeLayout btn_ly;
    LinearLayout submit_ly;
    String response;
    boolean sub_category_enable = true;

    public static FragmentProductCategory newInstance() {

        final FragmentProductCategory fragment = new FragmentProductCategory();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle sis) {

        final View view = inflater.inflate(R.layout.fragment_product_category, parent, false);

        getIntents();
        initializeViews(view);
        setUpValues();
        setUpListeners();

        return view;
    }


    public void getIntents() {


    }

    public void initializeViews(View view) {

        recycler_view = view.findViewById(R.id.recycler_view);
        btn_ly = view.findViewById(R.id.btn_ly);
        submit_ly = view.findViewById(R.id.submit_ly);
    }

    public void setUpValues() {
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recycler_view.setLayoutManager(mLayoutManager);
        recycler_view.setItemAnimator(new DefaultItemAnimator());

        recycler_view.setAdapter(new RecyclerViewCategory(getActivity()));


    }

    public void setUpListeners() {

        submit_ly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((CategoryActivity)getActivity()).moveNextFragment(CategoryActivity.FRAGMENT_SELLER_PRODUCT_DETAIL);
            }
        });


    }


    public class RecyclerViewCategory extends RecyclerView.Adapter<RecyclerViewHolder> {


        Activity act;

        public RecyclerViewCategory(Activity activity) {
            this.act = activity;

        }


        @Override
        public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product_category, null);
            RecyclerViewHolder rcv = new RecyclerViewHolder(layoutView);
            return rcv;
        }

        @Override
        public void onBindViewHolder(final RecyclerViewHolder holder, final int position) {

            RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);
            holder.sub_category_rv.setLayoutManager(mLayoutManager);
            holder.sub_category_rv.setItemAnimator(new DefaultItemAnimator());

            holder.parent_ly.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (sub_category_enable) {
                        holder.sub_category_rv.setVisibility(View.VISIBLE);
                        holder.sub_category_rv.setAdapter(new RecyclerViewSubCategory(getActivity()));
                        sub_category_enable = false;

                    } else {
                        holder.sub_category_rv.setVisibility(View.GONE);
                        sub_category_enable = true;

                    }
                }
            });


        }

        @Override
        public int getItemCount() {
            return 6
                    ;
        }


    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder {
        RecyclerView sub_category_rv;
        RelativeLayout parent_ly;

        public RecyclerViewHolder(View itemView) {
            super(itemView);

            sub_category_rv = itemView.findViewById(R.id.sub_category_rv);
            parent_ly = itemView.findViewById(R.id.parent_ly);
        }

    }


    public class RecyclerViewSubCategory extends RecyclerView.Adapter<RecyclerViewHolder> {


        Activity act;

        public RecyclerViewSubCategory(Activity activity) {
            this.act = activity;

        }


        @Override
        public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product_sub_category, null);
            RecyclerViewHolder rcv = new RecyclerViewHolder(layoutView);
            return rcv;
        }

        @Override
        public void onBindViewHolder(final RecyclerViewHolder holder, final int position) {


        }

        @Override
        public int getItemCount() {
            return 11;
        }


    }



}

