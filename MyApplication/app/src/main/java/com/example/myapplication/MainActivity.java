package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    EditText usrname;
    EditText pswd;
    Button loginbut;
    String name="Reshma";
    String ps="1234";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usrname=findViewById(R.id.USERNAME);
        pswd=findViewById(R.id.PASSWORD);
        loginbut=findViewById(R.id.LOGIN);

        loginbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inpName = usrname.getText().toString();
                String inpPass = pswd.getText().toString();

                if (inpName.isEmpty() || inpPass.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Fields are empty", Toast.LENGTH_SHORT).show();

                }


                else {
                    if (inpName.equals(name) && (inpPass.equals(ps))){
                        Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                    }
                else{

                        Toast.makeText(MainActivity.this, "INVALID DETAILS", Toast.LENGTH_SHORT).show();

                }

                }

            }

        });


    }
}