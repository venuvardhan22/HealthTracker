package com.example.healthtracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BMIActivity extends AppCompatActivity {

    EditText ageEditText, heightEditText, weightEditText;
    RadioGroup genderRadioGroup;
    Button calculateButton;
    RadioButton maleRadioButton, femaleRadioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmiactivity);

        // Initialize the UI elements
        ageEditText = findViewById(R.id.ageEditText);
        heightEditText = findViewById(R.id.heightEditText);
        weightEditText = findViewById(R.id.weightEditText);
        genderRadioGroup = findViewById(R.id.genderRadioGroup);
        calculateButton = findViewById(R.id.calculateButton);
        maleRadioButton = findViewById(R.id.maleRadioButton);
        femaleRadioButton = findViewById(R.id.femaleRadioButton);

        // Set click listener for the calculate button
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the input values
                String ageString = ageEditText.getText().toString();
                String heightString = heightEditText.getText().toString();
                String weightString = weightEditText.getText().toString();
                int selectedId = genderRadioGroup.getCheckedRadioButtonId();

                // Validate the input values
                if (ageString.isEmpty()) {
                    Toast.makeText(BMIActivity.this, "Please enter age", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (heightString.isEmpty()) {
                    Toast.makeText(BMIActivity.this, "Please enter height", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (weightString.isEmpty()) {
                    Toast.makeText(BMIActivity.this, "Please enter weight", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (selectedId == -1) {
                    Toast.makeText(BMIActivity.this, "Please select gender", Toast.LENGTH_SHORT).show();
                    return;
                }

                int age = Integer.parseInt(ageString);
                double height = Double.parseDouble(heightString);
                double weight = Double.parseDouble(weightString);
                RadioButton selectedRadioButton = findViewById(selectedId);
                String gender = selectedRadioButton.getText().toString();

                // Calculate the BMI value
                double bmi = calculateBMI(height, weight);

                // Launch the result activity and pass the BMI value and gender as extras
                Intent intent = new Intent(BMIActivity.this, ResultActivity.class);
                intent.putExtra("BMI_VALUE", bmi);
                intent.putExtra("GENDER", gender);
                startActivity(intent);
            }
        });
    }

    private double calculateBMI(double height, double weight) {
        return weight / Math.pow(height / 100, 2);
    }
}
