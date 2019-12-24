package com.riyad_patwary.assessmenttest_01;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database_Helper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "PRODUCT_DATABASE.db";
    public static final String TABLE_NAME = "PRODUCT_DATABASE";

    //columns
    public static final String COLUMN_1 = "ID";
    public static final String COLUMN_2 = "Product_Name";
    public static final String COLUMN_3 = "Product_Category";
    public static final String COLUMN_4 = "Product_Description";
    public static final String COLUMN_5 = "Product_Price";

    public Database_Helper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, Product_Name TEXT, Product_Category TEXT, Product_Description TEXT, Product_Price INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
