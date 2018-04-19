package com.example.maksym.weatherapp.Adapter;

/**
 * Created by Maksym on 14.04.2018.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.Model.ParentObject;
import com.example.maksym.weatherapp.Holders.DayViewHolder;
import com.example.maksym.weatherapp.Holders.HourViewHolder;
import com.example.maksym.weatherapp.R;

import java.util.List;


public class RecyclerAdapter extends ExpandableRecyclerAdapter<DayViewHolder,HourViewHolder> {

    LayoutInflater inflater;

    public RecyclerAdapter(Context context, List<ParentObject> parentItemList) {
        super(context, parentItemList);
        inflater = LayoutInflater.from(context);
    }


    @Override
    public DayViewHolder onCreateParentViewHolder(ViewGroup viewGroup) {

     View view = inflater.inflate(R.layout.card_layout,viewGroup,false);
        return new DayViewHolder(view);
    }

    @Override
    public HourViewHolder onCreateChildViewHolder(ViewGroup viewGroup) {
        View view = inflater.inflate(R.layout.child_card_layout,viewGroup,false);
        return new HourViewHolder(view);
    }

    @Override
    public void onBindParentViewHolder(DayViewHolder dayViewHolder, int i, Object o) {

    }

    @Override
    public void onBindChildViewHolder(HourViewHolder hourViewHolder, int i, Object o) {

    }



    @Override
    public int getItemCount() {
        return 5;
    }
}