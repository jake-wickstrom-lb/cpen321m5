package com.example.cpen_m5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String TAG = "MainActivity";

        Button hometownButton = findViewById(R.id.hometown_button);
        hometownButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Log.d(TAG, "Attempting to open Hometown Activity");

                Intent intent = new Intent(MainActivity.this, HometownActivity.class);
                startActivity(intent);
            }
        });

        Button timeButton = findViewById(R.id.time_button);
        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Attempting to open Time Activity");

                Intent intent = new Intent(MainActivity.this, ServerTimeActivity.class);
                startActivity(intent);
            }
        });
    }
}