package com.example.healthtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ActivitiesActivity extends AppCompatActivity {

    EditText weightEditText;
    CheckBox runCheckBox, bikeCheckBox, swimCheckBox, cycleCheckBox;
    RadioButton oneHourRadioButton, thirtyMinRadioButton, fifteenMinRadioButton;
    RadioGroup durationRadioGroup;
    Button calculateButton;
    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activities);

        // Initialize the UI elements
        weightEditText = (EditText) findViewById(R.id.weightEditText);
        runCheckBox = (CheckBox) findViewById(R.id.runCheckBox);
        bikeCheckBox = (CheckBox) findViewById(R.id.bikeCheckBox);
        swimCheckBox = (CheckBox) findViewById(R.id.swimCheckBox);
        cycleCheckBox = (CheckBox) findViewById(R.id.cycleCheckBox);
        oneHourRadioButton = (RadioButton) findViewById(R.id.oneHourRadioButton);
        thirtyMinRadioButton = (RadioButton) findViewById(R.id.thirtyMinRadioButton);
        fifteenMinRadioButton = (RadioButton) findViewById(R.id.fifteenMinRadioButton);
        durationRadioGroup = (RadioGroup) findViewById(R.id.durationRadioGroup);
        calculateButton = (Button) findViewById(R.id.calculateButton);
        resultTextView = (TextView) findViewById(R.id.resultTextView);

        // Set click listener for the calculate button
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the input values
                String weightString = weightEditText.getText().toString();

                // Validate the input values
                if (weightString.isEmpty()) {
                    Toast.makeText(ActivitiesActivity.this, "Please enter your weight", Toast.LENGTH_SHORT).show();
                    return;
                }

                double weight = Double.parseDouble(weightString);

                int duration = 0;
                switch (durationRadioGroup.getCheckedRadioButtonId()) {
                    case R.id.oneHourRadioButton:
                        duration = 60;
                        break;
                    case R.id.thirtyMinRadioButton:
                        duration = 30;
                        break;
                    case R.id.fifteenMinRadioButton:
                        duration = 15;
                        break;
                }

                // Calculate the calories burned based on the selected activities and duration
                double caloriesBurned = 0;

                if (runCheckBox.isChecked()) {
                    caloriesBurned += calculateCaloriesBurned(10, duration, weight);
                }
                if (bikeCheckBox.isChecked()) {
                    caloriesBurned += calculateCaloriesBurned(8, duration, weight);
                }
                if (swimCheckBox.isChecked()) {
                    caloriesBurned += calculateCaloriesBurned(12, duration, weight);
                }
                if (cycleCheckBox.isChecked()) {
                    caloriesBurned += calculateCaloriesBurned(8, duration, weight);
                }

                // Set the result text view
                resultTextView.setText(String.format("%.2f", caloriesBurned) + " calories burned");

                // Launch the share activity
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, "I burned " + String.format("%.2f", caloriesBurned) + " calories today!");
                Intent chooserIntent = Intent.createChooser(intent, "Share via");
                startActivity(chooserIntent);
            }
        });
    }

    private double calculateCaloriesBurned(double met, int duration, double weight) {
        return (met * 3.5 * weight * duration) / 200;
    }
}
