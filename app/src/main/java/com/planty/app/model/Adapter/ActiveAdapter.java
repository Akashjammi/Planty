package com.planty.app.model.Adapter;

import android.content.Context;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.planty.app.R;
import com.planty.app.model.Active;

import java.util.ArrayList;

public class ActiveAdapter extends RecyclerView.Adapter<ActiveAdapter.viewholder> {


    Context mContext;
    ArrayList<Active> mActives;


    public  ActiveAdapter(Context mContext, ArrayList<Active> mActives)
    {
        this.mActives=mActives;
        this.mContext=mContext;

    }
    @NonNull
    @Override
    public ActiveAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.active_inactive_itemlayout,viewGroup,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ActiveAdapter.viewholder viewholder, int i) {
//


        viewholder.checkbox_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(viewholder.checked==false){
                    viewholder.checkbox_new.setImageResource(R.drawable.checked);
                    viewholder.checked=true;

                    Log.e("checked","s");

                }else{
                    viewholder.checkbox_new.setImageResource(R.drawable.unchecked);
                    viewholder.checked=false;
                    Log.e("checked","no");


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

    public class viewholder extends RecyclerView.ViewHolder

    {
        TextView a;
        TextView b;
        TextView c;
        TextView d;
        ImageView checkbox_new;
        Boolean checked=false;
        LinearLayout checkbox_ly;


        public viewholder(@NonNull View itemView) {
            super(itemView);
            checkbox_new=itemView.findViewById(R.id.checkbox_img);
            checkbox_ly=itemView.findViewById(R.id.check);
//            a=itemView.findViewById(R.id.item_name);
//            b=itemView.findViewById(R.id.item_type);
//            c=itemView.findViewById(R.id.stock_type);
//            d=itemView.findViewById(R.id.cost);
        }
    }
}
