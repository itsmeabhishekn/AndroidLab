package com.example.ui_validation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2,e3,e4;
    Button b1;

    Pattern Name_PATTERN = Pattern.compile("^" +
            "[a-zA-Z]+$");

    Pattern Age_PATTERN =Pattern.compile("^" +

            "(?=\\S+$)" +            // no white spaces
            "[0-9]{1,2}" +                // 2 numbers
            "$");

    Pattern Phone_PATTERN =Pattern.compile("^" +

            "(?=\\S+$)" +            // no white spaces
            "[0-9]{10,10}" +                // 10 numbers
            "$");

    Pattern PASSWORD_PATTERN =Pattern.compile("^" +
            "(?=.*[@#$%^&+=])" +     // at least 1 special character
            "(?=\\S+$)" +            // no white spaces
            ".{6,}" +                // at least 4 characters
            "$");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.editTextTextPersonName5);
        e2=findViewById(R.id.editTextTextPersonName6);
        e3=findViewById(R.id.editTextTextPersonName7);
        e4=findViewById(R.id.editTextTextPassword2);
        b1=findViewById(R.id.button2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputname = e1.getText().toString();
                String inputage = e2.getText().toString();
                String inputphn = e3.getText().toString();
                String inputpass = e4.getText().toString();


                if (inputname.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Name field is Empty", Toast.LENGTH_SHORT).show();
                }




                if (inputage.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Age field is Empty", Toast.LENGTH_SHORT).show();
                }



                if (inputphn.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Phone field is Empty", Toast.LENGTH_SHORT).show();
                }



                if (inputpass.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Pass field is Empty", Toast.LENGTH_SHORT).show();
                }

                if (!Name_PATTERN.matcher(inputname).matches()){
                    e1.setError("Name is Incorrect");
                }


                if (!Age_PATTERN.matcher(inputage).matches()){
                    e2.setError("Age is Incorrect");
                }

                if (!Phone_PATTERN.matcher(inputphn).matches()){
                    e3.setError("Invalid Phone Number");
                }

                if (!PASSWORD_PATTERN.matcher(inputpass).matches()) {
                    e4.setError("Password is too weak");
                }

                else {
                    Toast.makeText(MainActivity.this, "SUCCESS", Toast.LENGTH_SHORT).show();

                }


            }
        });
    }
}