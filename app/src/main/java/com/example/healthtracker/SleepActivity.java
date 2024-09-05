package com.example.healthtracker;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SleepActivity extends AppCompatActivity {

    private EditText hoursEditText, minutesEditText;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep);

        hoursEditText = findViewById(R.id.hoursSleptEditText);
        minutesEditText = findViewById(R.id.minutesEditText);

        Button calculateButton = findViewById(R.id.submitButton);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateSleepTime();
            }
        });
    }

    private void calculateSleepTime() {
        String hoursStr = hoursEditText.getText().toString().trim();
        String minutesStr = minutesEditText.getText().toString().trim();

        if (TextUtils.isEmpty(hoursStr)) {
            Toast.makeText(this, "Please enter the hours you slept", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(minutesStr)) {
            Toast.makeText(this, "Please enter the minutes you slept", Toast.LENGTH_SHORT).show();
            return;
        }

        int hours = Integer.parseInt(hoursStr);
        int minutes = Integer.parseInt(minutesStr);
        int totalMinutes = hours * 60 + minutes;

        Intent intent = new Intent(this, SleepResultActivity.class);
        intent.putExtra("totalMinutes", totalMinutes);
        startActivity(intent);
    }
}
