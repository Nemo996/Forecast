package com.example.maksym.weatherapp.Holders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;
import com.example.maksym.weatherapp.R;

/**
 * Created by Maksym on 18.04.2018.
 */

public class HourViewHolder extends ChildViewHolder {

    private TextView time;
    private TextView temp;
    private TextView sky;
    private TextView pressure;
    private TextView humadity;
    private TextView wind;
    private ImageView image;

    public HourViewHolder(View itemView) {
            super(itemView);
            time = itemView.findViewById(R.id.time);
            temp = itemView.findViewById(R.id.temp_for_hour);
            sky = itemView.findViewById(R.id.sky_for_hour);
            pressure = itemView.findViewById(R.id.pressure);
            humadity = itemView.findViewById(R.id.humidity_for_hour);
            wind = itemView.findViewById(R.id.wind_for_hour);
            image = itemView.findViewById(R.id.image_weather);
    }

}
