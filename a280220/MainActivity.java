package com.example.a280220;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public  static  final String LOG_TAG = "MyLogs";
    public  static  final String DB_NAME = "myDB";
    private EditText et_email, et_name;
Button b_add, b_read, b_clear;
private DBhelper dBhelper;
private ContentValues cv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        dBhelper = new DBhelper(this, DB_NAME, null, 1);


        b_add = (Button) findViewById(R.id.btn_add);
        b_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(MainActivity.LOG_TAG, "~~~~~ ADDED");

                et_email = (EditText) findViewById(R.id.et_email);
                et_name = (EditText) findViewById(R.id.et_name);

                String name = et_name.getText().toString();
                String email = et_email.getText().toString();

                SQLiteDatabase db = dBhelper.getWritableDatabase();
                cv = new ContentValues();
                cv.put(DBhelper.COLUMN_NAME, name);
                cv.put(DBhelper.COLUMN_EMAIL, name);
                long rowID = db.insert(DBhelper.TABLE_NAME, null, cv);

                Log.d(MainActivity.LOG_TAG, "~~~~~ ID: " + rowID);

                dBhelper.close();

            }
        });
        b_read = (Button) findViewById(R.id.btn_read);
        b_read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(MainActivity.LOG_TAG, "~~~~~~~ READ (rows of table) ");

                SQLiteDatabase db = dBhelper.getWritableDatabase();
                Cursor c = db.query( dBhelper.TABLE_NAME, null, null,
                        null, null, null, null, null);

                if(c.moveToFirst()){
                    int idColIndex = c.getColumnIndex(DBhelper.COLUMN_ID);
                    int nameColIndex = c.getColumnIndex(DBhelper.COLUMN_NAME);
                    int emailColIndex = c.getColumnIndex(DBhelper.COLUMN_EMAIL);

                    do {
                        Log.d(LOG_TAG, "ID = " + c.getInt(idColIndex) + "name = " + c.getString(nameColIndex) + ", email = " + c.getString(emailColIndex));
                    }
                    while (c.moveToNext());


                }

                else {
                    Log.d(MainActivity.LOG_TAG, "~~~~~~~ READ (rows of table) ");
                }
                c.close();
                dBhelper.close();
            }



        });
        b_clear = (Button) findViewById(R.id.btn_clear);
b_clear.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        SQLiteDatabase db = dBhelper.getWritableDatabase();
        int clearCount  = db.delete(dBhelper.TABLE_NAME, null, null);
        Log.d(MainActivity.LOG_TAG, "~~~~~~~ (deleted rows count = " + clearCount);
    }
});

    }
}