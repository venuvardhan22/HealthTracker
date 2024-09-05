package com.example.healthtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView resultTextView, statusTextView, tipsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Initialize the UI elements
        resultTextView = findViewById(R.id.resultTextView);
        statusTextView = findViewById(R.id.statusTextView);
        tipsTextView = findViewById(R.id.tipsTextView);

        // Get the extras from the intent
        Bundle extras = getIntent().getExtras();
        double bmiValue = extras.getDouble("BMI_VALUE");
        String gender = extras.getString("GENDER");

        // Set the result text view
        resultTextView.setText(String.format("%.1f", bmiValue));

        // Determine the status based on BMI value
        String status = "";
        if (bmiValue < 18.5) {
            status = "Underweight";
        } else if (bmiValue < 25) {
            status = "Normal";
        } else if (bmiValue < 30) {
            status = "Overweight";
        } else {
            status = "Obese";
        }

        // Add gender to the status
        status = status + " (" + gender + ")";

        // Set the status text view
        statusTextView.setText(status);

        // Set the tips text view based on BMI value
        String tips = "";
        if (bmiValue < 18.5) {
            tips = "You are underweight. To gain weight, increase your calorie intake by eating more protein and healthy fats. Consult with a doctor or a registered dietitian for personalized advice.";
        } else if (bmiValue < 25) {
            tips = "You have a normal weight. To maintain a healthy weight, continue eating a balanced diet and exercising regularly.";
        } else if (bmiValue < 30) {
            tips = "You are overweight. To lose weight, reduce your calorie intake by eating fewer processed foods and sugary drinks. Incorporate more vegetables, fruits, and lean proteins into your diet. Aim for at least 150 minutes of moderate-intensity exercise or 75 minutes of vigorous-intensity exercise per week.";
        } else {
            tips = "You are obese. To improve your health, it's important to lose weight. Consult with a doctor or a registered dietitian for personalized advice on how to lose weight in a safe and sustainable way. Start by reducing your calorie intake by eating more whole foods and cutting back on processed foods and sugary drinks. Aim for at least 150 minutes of moderate-intensity exercise or 75 minutes of vigorous-intensity exercise per week.";
        }

        // Set the tips text view
        tipsTextView.setText(tips);
    }
}
