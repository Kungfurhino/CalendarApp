package com.example.calendarapp;

import static java.lang.Thread.sleep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class LoadingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        Thread thread = new Thread( () -> {
            try{
                sleep(5000);
                Intent i = new Intent(LoadingActivity.this, MainActivity.class);
                startActivity(i);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        });

        thread.start();
    }
}