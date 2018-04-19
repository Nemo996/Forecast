package com.example.maksym.weatherapp.Holders;

import android.view.View;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ParentViewHolder;
import com.example.maksym.weatherapp.R;

/**
 * Created by Maksym on 18.04.2018.
 */

public class DayViewHolder extends ParentViewHolder {

    private TextView dayOfWeek;
    private TextView sky;
    private TextView pressure;
    private TextView date;
    private TextView temperature;

    public DayViewHolder(View itemView) {
        super(itemView);

        dayOfWeek = itemView.findViewById(R.id.day_of_week);
        sky = itemView.findViewById(R.id.sky);
        pressure = itemView.findViewById(R.id.pressure);
        date = itemView.findViewById(R.id.date);
        temperature = itemView.findViewById(R.id.big_temp);

    }
}
