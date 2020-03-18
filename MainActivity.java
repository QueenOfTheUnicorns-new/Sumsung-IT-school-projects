package com.example.a180320ast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private Button save_btn;
    private Button load_btn;
    private EditText key;
    private EditText value;

    private SharedPreferences preferences;

    private String keySt;
    private Integer valueInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        key = (EditText) findViewById(R.id.et_key);
        value = (EditText) findViewById(R.id.et_value);

        save_btn = (Button) findViewById(R.id.bt1);
        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData(key.getText().toString(), Integer.valueOf(value.getText().toString()));
                Toast.makeText(MainActivity.this, "Saved", Toast.LENGTH_LONG).show();
            }
        });
        load_btn = (Button) findViewById(R.id.bt2);
        load_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Integer valueInt = loadData(key.getText().toString());
               if(valueInt != -1){
                   value.setText(String.valueOf(valueInt));
                   Toast.makeText(MainActivity.this, "Loading is success", Toast.LENGTH_LONG).show();
               }
               else {
                   value.setText("Error");
                   Toast.makeText(MainActivity.this, "Not success", Toast.LENGTH_LONG).show();
               }
            }
        });




    }
    public void saveData(String key, Integer value){
        preferences = getPreferences(MODE_PRIVATE);

        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public  Integer loadData(String key){
        preferences = getPreferences(MODE_PRIVATE);
        return preferences.getInt(key, -1);
    }

}
