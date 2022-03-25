package com.example.sharedprefui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText name;
    EditText age;
    EditText phone;
    EditText password;
    Button submit;
    Pattern PASSWORD_PATTERN =Pattern.compile("^" +
            "(?=.*[@#$%^&+=])" +     // at least 1 special character
            "(?=\\S+$)" +            // no white spaces
            ".{4,}" +                // at least 4 characters
            "$");
    Pattern Phone_PATTERN =Pattern.compile("^" +

            "(?=\\S+$)" +            // no white spaces
            "[0-9]{10,10}" +                // 10 numbers
            "$");
    Pattern Age_PATTERN = Pattern.compile("^" +

            "(?=\\S+$)" +            // no white spaces
            "[0-9]{1,2}" +                // 2 numbers
            "$");
    @Override
    protected void onPause() {
        super.onPause();

        // Creating a shared pref object
        // with a file name "MySharedPref"
        // in private mode
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();

        // write all the data entered by the user in SharedPreference and apply
        myEdit.putString("name", name.getText().toString());
        myEdit.putInt("age", Integer.parseInt(age.getText().toString()));
        myEdit.putString("password",password.getText().toString());
        myEdit.putInt("phone", Integer.parseInt(phone.getText().toString()));
        myEdit.apply();
    }
    @Override
    protected void onResume() {
        super.onResume();

        // Fetching the stored data
        // from the SharedPreference
        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);

        String s1 = sh.getString("name", "");
        int a = sh.getInt("age", 0);
        String s2 = sh.getString("password", "");
        int c = sh.getInt("phone", 0);

        // Setting the fetched data
        // in the EditTexts
        name.setText(s1);
        age.setText(String.valueOf(a));
        password.setText(s2);
        phone.setText(String.valueOf(c));

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.name);
        age=findViewById(R.id.age);
        phone=findViewById(R.id.Phone);
        password=findViewById(R.id.Password);
        submit=findViewById(R.id.button);



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inpName=name.getText().toString();
                String inpAge=age.getText().toString();
                String inpPh=phone.getText().toString();
                String inpPass=password.getText().toString();





                if(inpName.isEmpty()){
                    Toast.makeText(MainActivity.this,  "Name Field is Empty", Toast.LENGTH_SHORT).show();
                }
                if(inpAge.isEmpty()){
                    Toast.makeText(MainActivity.this,  "Age field is Empty", Toast.LENGTH_SHORT).show();
                }
                if(inpPh.isEmpty()){
                    Toast.makeText(MainActivity.this,  "Phone field is Empty", Toast.LENGTH_SHORT).show();
                }
                if(inpPass.isEmpty()){
                    Toast.makeText(MainActivity.this,  "Pass field is Empty", Toast.LENGTH_SHORT).show();
                }

                if (!Age_PATTERN.matcher(inpAge).matches()){
                    age.setError("Incorrect Age");
                }
                if (!Phone_PATTERN.matcher(inpPh).matches()){
                    phone.setError("Invalid Phone Number");
                }

                if (!PASSWORD_PATTERN.matcher(inpPass).matches()){
                    password.setError("Weak Password");
                }

                else{
                    Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                }


            }

        });

    }
}