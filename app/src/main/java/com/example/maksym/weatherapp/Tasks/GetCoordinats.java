package com.example.maksym.weatherapp.Tasks;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.util.Log;

import com.example.maksym.weatherapp.Common.Common;
import com.example.maksym.weatherapp.Helper.DBHelper;
import com.example.maksym.weatherapp.Helper.Helper;
import com.example.maksym.weatherapp.Model.OpenWeatherMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Maksym on 19.04.2018.
 */

public class GetCoordinats extends AsyncTask<String,Void,String> {

   private double lat;
   private double lng;

    Context context;
    DBHelper dbHelper;
    OpenWeatherMap openWeatherMap = new OpenWeatherMap();


    public GetCoordinats (Context context){
        this.context = context;
    }
    ProgressDialog dialog = new ProgressDialog(context);

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialog.setMessage("Please wait....");
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }

    @Override
    protected String doInBackground(String... strings) {
        String response;
        try{
            String address = strings[0];
            Helper http = new Helper();
            String url = String.format("https://maps.googleapis.com/maps/api/geocode/json?address=%s",address);
            response = http.getHTTPDataLocation(url);
            return response;
        }
        catch (Exception ex)
        {

        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        try{
            JSONObject jsonObject = new JSONObject(s);

            String lat = ((JSONArray)jsonObject.get("results")).getJSONObject(0).getJSONObject("geometry")
                    .getJSONObject("location").get("lat").toString();
            String lng = ((JSONArray)jsonObject.get("results")).getJSONObject(0).getJSONObject("geometry")
                    .getJSONObject("location").get("lng").toString();

            setLat(Double.parseDouble(lat));
            setLng(Double.parseDouble(lng));

            SQLiteDatabase database = dbHelper.getWritableDatabase();
            ContentValues contentValues = new ContentValues();

            database.delete(DBHelper.TABLE_LOCATION, null, null);

            Cursor c;

            c = database.query("location", null, null, null, null, null, null);
            if (c.getCount()==0) {
                do {
                    contentValues.clear();
                    contentValues.put(DBHelper.KEY_LAT, String.valueOf(lat));
                    contentValues.put(DBHelper.KEY_LNG, String.valueOf(lng));
                    database.insert(DBHelper.TABLE_LOCATION, null, contentValues);
                    Log.d("myLog", " Location "+lat+lng);
                } while (c.moveToNext());

            }else
                Log.d("myLog", "rows 0 map Location "+lat+lng);

            c.close();
            new GetWeather(context).execute(Common.apiRequest(String.valueOf(lat),String.valueOf(lng)));

            if(dialog.isShowing())
                dialog.dismiss();



        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }
}

