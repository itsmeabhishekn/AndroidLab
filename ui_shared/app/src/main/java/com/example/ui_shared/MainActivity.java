package com.example.ui_shared;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    EditText e1;
    EditText e2;
    EditText e3;
    EditText e4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1=findViewById(R.id.name);
        e2=findViewById(R.id.age);
        e3=findViewById(R.id.Phone);
        e4=findViewById(R.id.Password);

    }

    @Override
    protected void onPause() {
        super.onPause();

        // Creating a shared pref object
        // with a file name "MySharedPref"
        // in private mode
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor spf = sharedPreferences.edit();

        // write all the data entered by the user in SharedPreference and apply
        spf.putString("name", e1.getText().toString());
        spf.putInt("age", Integer.parseInt(e2.getText().toString()));
        spf.putInt("phone", Integer.parseInt(e3.getText().toString()));
        spf.putString("password",e4.getText().toString());
        spf.commit();
        spf.apply();
    }
    @Override
    protected void onResume() {
        super.onResume();

        // Fetching the stored data
        // from the SharedPreference
        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);

        String s1 = sh.getString("name", "");
        int ag = sh.getInt("age", 0);
        String s2 = sh.getString("password", "");
        int ph = sh.getInt("phone", 0);

        // Setting the fetched data
        // in the EditTexts
        e1.setText(s1);
        e2.setText(String.valueOf(ag));
        e3.setText(String.valueOf(ph));
        e4.setText(s2);

    }



}