package com.example.maksym.weatherapp.Helper;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper  extends SQLiteOpenHelper{

    public static final int DATABASE_VERSION = 3;
    public static final String DATABASE_NAME = "DBWeather";
    public static final String TABLE_CITY = "city";
    public static final String TABLE_LIST = "list";
    public static final String TABLE_LOCATION = "location";

    public static final String KEY_NAME = "name";
    public static final String KEY_COUNTRY = "country";
    public static final String KEY_ID = "id";
    public static final String KEY_IDL = "idl";

    public static final String KEY_NUMBER = "number";
    public static final String KEY_DATE = "date";
    public static final String KEY_TEMP = "temperature";
    public static final String KEY_TEMP_MIN = "temp_min";
    public static final String KEY_TEMP_MAX = "temp_max";
    public static final String KEY_PRESSURE = "pressure";
    public static final String KEY_HUMIDITY = "humidity";
    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_ICON = "icon";
    public static final String KEY_CLOUDS = "clouds";
    public static final String KEY_WIND = "wind";

    public static final String KEY_LAT = "lat";
    public static final String KEY_LNG = "lng";



    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_CITY + "("
                + KEY_ID+ " integer primary key,"
                + KEY_COUNTRY+ " text NOT NULL,"
                + KEY_NAME + " text NOT NULL"
                + ")");

        db.execSQL("create table " + TABLE_LIST+ "("
                + KEY_NUMBER+ " integer primary key,"
                + KEY_DATE+ " text NOT NULL,"
                + KEY_TEMP+ " text NOT NULL,"
                + KEY_TEMP_MIN+ " text NOT NULL,"
                + KEY_TEMP_MAX + " text NOT NULL,"
                + KEY_PRESSURE+ " text NOT NULL,"
                + KEY_HUMIDITY+ " text NOT NULL,"
                + KEY_DESCRIPTION+ " text NOT NULL,"
                + KEY_ICON+ " text NOT NULL,"
                + KEY_CLOUDS+ " text NOT NULL,"
                + KEY_WIND+ " text NOT NULL"
                + ")");

        db.execSQL("create table " + TABLE_LOCATION + "("
                + KEY_IDL+ " integer primary key,"
                + KEY_LAT+ " text NOT NULL,"
                + KEY_LNG + " text NOT NULL"
                + ")");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_CITY);
        db.execSQL("drop table if exists " + TABLE_LIST);
        db.execSQL("drop table if exists " + TABLE_LOCATION);

        onCreate(db);

    }
}