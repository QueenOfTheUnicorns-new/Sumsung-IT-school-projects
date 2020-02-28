package com.example.a280220;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DBhelper extends SQLiteOpenHelper {

    public static  final String TABLE_NAME = "mytable";
    public static  final String COLUMN_ID = "id";
    public static  final String COLUMN_NAME= "name";
    public static  final String COLUMN_EMAIL = "email";

    public DBhelper(@Nullable Context context, @Nullable String name,
                    @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.d(MainActivity.LOG_TAG, "~~~~~ onCreate DB");
sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_NAME + " " +
        "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+ COLUMN_NAME + " TEXT, " + COLUMN_EMAIL + " TEXT )" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
