package com.example.optionmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.example_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.message:
                Intent a=new Intent(getApplicationContext(),messageActivity.class);
                startActivity(a);
                return true;

            case R.id.picture:
                Intent b=new Intent(getApplicationContext(),pictureActivity.class);
                startActivity(b);
                return true;


            case R.id.mode:
                Intent c=new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(c);
                return true;





            case R.id.item1:
                Intent i=new Intent(getApplicationContext(), item1.class);
                startActivity(i);
                return true;



            case R.id.item2:
                Intent k=new Intent(getApplicationContext(),item2.class);
                startActivity(k);
                return true;



            case R.id.item3:
                Intent j=new Intent(getApplicationContext(),item3.class);
                startActivity(j);
                return true;

            default:

                return super.onOptionsItemSelected(item);

        }

    }

}