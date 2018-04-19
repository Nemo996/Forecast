package com.example.maksym.weatherapp.Tasks;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.util.Log;

import com.example.maksym.weatherapp.Helper.DBHelper;
import com.example.maksym.weatherapp.Helper.Helper;
import com.example.maksym.weatherapp.Model.OpenWeatherMap;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

/**
 * Created by Maksym on 19.04.2018.
 */

public class GetWeather extends AsyncTask<String,Void,String> {

    Context context;
    DBHelper dbHelper;
    OpenWeatherMap openWeatherMap = new OpenWeatherMap();


    public GetWeather(Context context){
        this.context = context;
    }

    ProgressDialog pd = new ProgressDialog(context);

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd.setTitle("Please wait");
        pd.show();
    }


    @Override
    protected String doInBackground(String... strings) {
        String stream = null;
        String urlString = strings[0];

        Helper http = new Helper();
        stream = http.getHTTPData(urlString);
        return stream;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if(s.contains("Error: Not found city")){
            pd.dismiss();
            return;
        }

        Gson gson = new Gson();
        Type mType = new TypeToken<OpenWeatherMap>(){}.getType();
        openWeatherMap = gson.fromJson(s, mType);
        pd.dismiss();

        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        database.delete(DBHelper.TABLE_CITY, null, null);
        database.delete(DBHelper.TABLE_LIST, null, null);


        Cursor c;

        c = database.query("city", null, null, null, null, null, null);
        if (c.getCount()==0) {
            do {
                contentValues.clear();
                contentValues.put(DBHelper.KEY_NAME, openWeatherMap.getCity().getName());
                contentValues.put(DBHelper.KEY_COUNTRY, openWeatherMap.getCity().getCountry());
                database.insert(DBHelper.TABLE_CITY, null, contentValues);

            } while (c.moveToNext());
        }else
            Log.d("mLog","0 city");
        c.close();



        c = database.query("list", null, null, null, null, null, null);

        if (c.getCount() == 0) {

            for(int i = 0; i < openWeatherMap.getList().size();i++){
                contentValues.clear();
                contentValues.put("date", openWeatherMap.getList().get(i).getDt_txt());
                contentValues.put("temperature", String.valueOf(openWeatherMap.getList().get(i).getMain().getTemp()) );
                contentValues.put("temp_min", String.valueOf(openWeatherMap.getList().get(i).getMain().getTemp_min()));
                contentValues.put("temp_max", String.valueOf(openWeatherMap.getList().get(i).getMain().getTemp_max()));
                contentValues.put("pressure", String.valueOf(openWeatherMap.getList().get(i).getMain().getPressure()));
                contentValues.put("humidity", String.valueOf(openWeatherMap.getList().get(i).getMain().getHumidity()));
                contentValues.put("description", String.valueOf(openWeatherMap.getList().get(i).getWeather().get(0).getDescription()));
                contentValues.put("icon", String.valueOf(openWeatherMap.getList().get(i).getWeather().get(0).getIcon()));
                contentValues.put("clouds", String.valueOf(openWeatherMap.getList().get(i).getClouds().getAll()));
                contentValues.put("wind", String.valueOf(openWeatherMap.getList().get(i).getWind().getSpeed()));

                Log.d("mLog",String.valueOf(i));
                database.insert("list", null, contentValues);
            }}else
            Log.d("mLog","0 rows");
        c.close();
        dbHelper.close();

    }
}
