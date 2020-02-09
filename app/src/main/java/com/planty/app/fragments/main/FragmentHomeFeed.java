package com.planty.app.fragments.main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;


import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.planty.app.R;
import com.planty.app.customclass.ActiveInactive;
import com.planty.logasventor.Addproducts;




public class FragmentHomeFeed extends Fragment {

    RecyclerView rec_y;
    boolean sub_category_enable = true;
    TextView active;
    TextView Inactive;
    ImageView menu;
    public static FragmentHomeFeed newInstance() {

        final FragmentHomeFeed fragment = new FragmentHomeFeed();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle sis) {

        final View view = inflater.inflate(R.layout.fragmenthomefeed, parent, false);
        getIntents();
        initializeViews(view);
        setUpValues();
        setUpListeners();

        return view;
    }


    public void getIntents() {
    }

    public void initializeViews(View view) {
//        rec_y=view.findViewById(R.id.rec_v);
//        active=view.findViewById(R.id.activebutton);
//        Inactive=view.findViewById(R.id.inactivebutton);
        menu=view.findViewById(R.id.burger_menu);
    }

    public void setUpValues() {
//        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
//        rec_y.setLayoutManager(mLayoutManager);
//        rec_y.setItemAnimator(new DefaultItemAnimator());
//
//        rec_y.setAdapter(new RecyclerViewCategory(getActivity()));


    }

    public void setUpListeners() {


        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ((MainActivity)).drawerContral();
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

            View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.homefeedfragment_itemlayout, null);
            RecyclerViewHolder rcv = new RecyclerViewHolder(layoutView);
            return rcv;
        }

        @Override
        public void onBindViewHolder(final RecyclerViewHolder holder, final int position) {

            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
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
            return 11;
        }


    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder {
        RecyclerView sub_category_rv;
        RelativeLayout parent_ly;
        TextView addpro;


        public RecyclerViewHolder(View itemView) {
            super(itemView);

            sub_category_rv = itemView.findViewById(R.id.sub_category_rv);
            parent_ly = itemView.findViewById(R.id.parent_ly);
        }

    }

//
    public class RecyclerViewSubCategory extends RecyclerView.Adapter<RecyclerViewSubCategory.ViewHolder> {

        //    ArrayList<HomeModel>models;
        Context context;

        public RecyclerViewSubCategory(Context context) {

            //      this.models=models;
            this.context = context;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.homefeedfragment_subitemlayout, viewGroup, false);
            ViewHolder viewHolder = new ViewHolder(v);
            return viewHolder;
        }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
       viewHolder.active_tv .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), ActiveInactive.class);
                intent.putExtra("active",true);
                    startActivity(intent);
            }
        });
        viewHolder.inactive .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), ActiveInactive.class);
                intent.putExtra("inactive",true);
                startActivity(intent);
            }
        });

        viewHolder.product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),Addproducts.class);

                startActivity(intent);

            }
        });


    }



        @Override
        public int getItemCount() {
            return 1;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            TextView temper, product, active_tv, inactive;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);

//                temper = itemView.findViewById(R.id.home_temper_tv);
                product = itemView.findViewById(R.id.addproductbutton);
                active_tv= itemView.findViewById(R.id.activebutton);
                inactive = itemView.findViewById(R.id.inactivebutton);
            }
        }



    }

    }






