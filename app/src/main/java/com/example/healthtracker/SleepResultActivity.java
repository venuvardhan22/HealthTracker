package com.example.healthtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SleepResultActivity extends AppCompatActivity {

    private TextView resultTextView, suggestionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep_result);

        resultTextView = findViewById(R.id.resultText);
        suggestionTextView = findViewById(R.id.suggestionText);

        Intent intent = getIntent();
        int totalMinutes = intent.getIntExtra("totalMinutes", 0);
        int averageMinutes = 480; // 8 hours in minutes

        if (totalMinutes < averageMinutes) {
            int deficitMinutes = averageMinutes - totalMinutes;
            int deficitHours = deficitMinutes / 60;
            deficitMinutes = deficitMinutes % 60;
            String suggestion = "You should increase your sleep time by " + deficitHours + " hours and " + deficitMinutes + " minutes.";
            resultTextView.setText("Your sleep time is below average.");
            suggestionTextView.setText(suggestion);
        } else if (totalMinutes > averageMinutes) {
            int excessMinutes = totalMinutes - averageMinutes;
            int excessHours = excessMinutes / 60;
            excessMinutes = excessMinutes % 60;
            String suggestion = "You should reduce your sleep time by " + excessHours + " hours and " + excessMinutes + " minutes.";
            resultTextView.setText("Your sleep time is above average.");
            suggestionTextView.setText(suggestion);
        } else {
            resultTextView.setText("Your sleep time is average.");
            suggestionTextView.setText("Keep up the good work!");
        }
    }
}
