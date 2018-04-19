package com.example.maksym.weatherapp.Date;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.maksym.weatherapp.Helper.DBHelper;

import java.util.List;

/**
 * Created by Maksym on 19.04.2018.
 */

public class DateTime {



    private List<String> dateArray;
    private List<String> dateTimeArray;
    Context context;

    DateTime(Context context){
        this.context = context;

        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        Cursor cursor;
        cursor = database.query(DBHelper.TABLE_LIST, null, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            int date = cursor.getColumnIndex(DBHelper.KEY_DATE);
            do {

                dateTimeArray.add(cursor.getString(date));
            } while (cursor.moveToNext());
        } else
            Log.d("DateTime class","0 List");

        cursor.close();

        for(int i=0;i < dateTimeArray.size(); i++ ){

        }


    }


    public List<String> getDateArray() {
        return dateArray;
    }

    public void setDateArray(List<String> dateArray) {
        this.dateArray = dateArray;
    }

}
