package com.example.learning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2;
    Button b1,b2;

    Pattern Name_PATTERN = Pattern.compile("^" +
            "[a-zA-Z]+$");


    Pattern PASSWORD_PATTERN =Pattern.compile("^" +
            "(?=.*[@#$%^&+=])" +     // at least 1 special character
            "(?=\\S+$)" +            // no white spaces
            ".{6,}" +                // at least 4 characters
            "$");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.editTextTextPersonName6);
        e2=findViewById(R.id.editTextTextPassword2);
        b1=findViewById(R.id.button);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputname = e1.getText().toString();
                String inputpass = e2.getText().toString();

                if (inputname.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Username  cannot be Empty", Toast.LENGTH_SHORT).show();
                }
                if (inputpass.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Password cannot be Empty", Toast.LENGTH_SHORT).show();
                }


                if (!Name_PATTERN.matcher(inputname).matches()){
                    e1.setError("Username is Incorrect");
                }

                if (!PASSWORD_PATTERN.matcher(inputpass).matches()) {
                    e2.setError("Password is too weak");
                }
                  else {

                    Intent i = new Intent(getApplicationContext(), MainActivity2.class);
                    startActivity(i);
                  }


            }
        });


    }
}