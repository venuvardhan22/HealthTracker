package com.example.healthtracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.healthtracker.ActivitiesActivity;
import com.example.healthtracker.BMIActivity;
import com.example.healthtracker.DietActivity;
import com.example.healthtracker.R;
import com.example.healthtracker.SleepActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.healthtracker.ActivitiesActivity;
import com.example.healthtracker.BMIActivity;
import com.example.healthtracker.CaloriesBurntActivity;
import com.example.healthtracker.DietActivity;
import com.example.healthtracker.R;
import com.example.healthtracker.SleepActivity;

public class MainActivity extends AppCompatActivity {

    Button bmiButton;
    Button activityButton;
    Button sleepButton;
    Button dietButton;
    Button caloriesBurntButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the buttons
        bmiButton = findViewById(R.id.bmiButton);
        activityButton = findViewById(R.id.activityButton);
        sleepButton = findViewById(R.id.sleepButton);
        dietButton = findViewById(R.id.dietButton);
        caloriesBurntButton = findViewById(R.id.caloriesButton);

        // Set click listeners for the buttons
        bmiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BMIActivity.class);
                startActivity(intent);
            }
        });

        activityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivitiesActivity.class);
                startActivity(intent);
            }
        });

        sleepButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SleepActivity.class);
                startActivity(intent);
            }
        });

        dietButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DietActivity.class);
                startActivity(intent);
            }
        });

        caloriesBurntButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CaloriesBurntActivity.class);
                startActivity(intent);
            }
        });
    }
}
