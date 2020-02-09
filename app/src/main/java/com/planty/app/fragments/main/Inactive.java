package com.planty.app.fragments.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;


import com.planty.app.R;
import com.planty.app.model.Active;
import com.planty.logasventor.Addproducts;

import java.util.ArrayList;
import java.util.List;


public class Inactive extends Fragment {

    RecyclerView mRecyclerView;
    Spinner spinner;
    Boolean check_box_active = false;
    ActiveAdapter activeAdapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_active, container, false);
        mRecyclerView = view.findViewById(R.id.rec_items);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        ArrayList<Active> active = new ArrayList<Active>();
        active.add(new Active("hi", "nokia", "two", "value"));

        List<String> categories = new ArrayList<String>();
        categories.add("Edit");
        categories.add("Select");
        categories.add("Select All");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this.getContext(), android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner =  view.findViewById(R.id.spinner);
        spinner.setAdapter(dataAdapter);
        final TextView spinnerchoice = view.findViewById(R.id.spinner_choice);
        spinnerchoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinner.performClick();
            }
        });



        activeAdapter = new ActiveAdapter(getActivity(), active);
        mRecyclerView.setAdapter(activeAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String spinner_value = spinner.getSelectedItem().toString();
                spinnerchoice.setText(spinner_value);
                Log.e("onItemSelected: ", "ksjdk");

                if (spinner_value.toLowerCase().equals("select")) {
                    Log.e("onItemSelected: ", "skdjksjdk");
                    check_box_active = true;
                    activeAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        return view;
    }


    public class ActiveAdapter extends RecyclerView.Adapter<ActiveAdapter.viewholder> {


        Context mContext;
        ArrayList<Active> mActives;


        public ActiveAdapter(Context mContext, ArrayList<Active> mActives) {
            this.mActives = mActives;
            this.mContext = mContext;

        }

        @NonNull
        @Override
        public viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.active_inactive_itemlayout, viewGroup, false);
            return new viewholder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull final viewholder viewholder, int i) {

            viewholder.im1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), Addproducts.class);
                    startActivity(intent);
                }
            });
//
            if (check_box_active) {
                viewholder.checkbox_new.setVisibility(View.VISIBLE);

            } else {
                viewholder.checkbox_new.setVisibility(View.GONE);
            }

            viewholder.checkbox_new.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(viewholder.checked==false){
                        viewholder.checkbox_new.setImageResource(R.drawable.checked);
                        viewholder.checked=true;
                    }else {
                        viewholder.checkbox_new.setImageResource(R.drawable.unchecked);
                        viewholder.checked=false;

                    }

                }
            });

            viewholder.checkbox_ly.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewholder.checkbox_ly.performClick();
                }
            });

        }

        @Override
        public int getItemCount() {
            return mActives.size();
        }

        public class viewholder extends RecyclerView.ViewHolder {
            TextView a;
            TextView b;
            TextView c;
            TextView d;
            ImageView checkbox_new;
            ImageView im1;
            LinearLayout checkbox_ly;
            Boolean checked=false;

            public viewholder(@NonNull View itemView) {
                super(itemView);
                im1=itemView.findViewById(R.id.im1);
                checkbox_new = itemView.findViewById(R.id.checkbox_img);
                checkbox_ly = itemView.findViewById(R.id.check);

//            a=itemView.findViewById(R.id.item_name);
//            b=itemView.findViewById(R.id.item_type);
//            c=itemView.findViewById(R.id.stock_type);
//            d=itemView.findViewById(R.id.cost);
            }
        }
    }

}
