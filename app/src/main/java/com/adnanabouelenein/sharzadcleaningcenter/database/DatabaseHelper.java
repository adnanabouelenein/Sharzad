package com.adnanabouelenein.sharzadcleaningcenter.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static String DATABASE_NAME = "sharzad_cleaning_center.db";
    public static final int DATABASE_VERSION = 1;
    private static DatabaseHelper databaseInstance = null;
    private Context mContext;


    public static DatabaseHelper newInstance(Context context){
        if (databaseInstance == null){
            databaseInstance = new DatabaseHelper(context.getApplicationContext());

        }
        return databaseInstance;
    }



    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME , null, DATABASE_VERSION);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_CUSTOMER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private static final String CREATE_CUSTOMER_TABLE = "CREATE TABLE " +
            Constants.CUSTOMER_TABLE +
            " (" +
            Constants.COLUMN_ID +
            " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            Constants.COLUMN_EMAIL + " TEXT," +
            " " + Constants.COLUMN_NAME + " TEXT, "
            + Constants.COLUMN_PHONE + " TEXT, " +
            Constants.COLUMN_DATE_CREATED + " BIGINT, "
            + Constants.COLUMN_LAST_UPDATED + " BIGINT "
            + ")";


}