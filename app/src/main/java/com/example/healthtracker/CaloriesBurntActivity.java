package com.example.healthtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CaloriesBurntActivity extends AppCompatActivity {

    EditText exerciseEditText, sleepingEditText, walkingEditText, mobileEditText, othersEditText;
    Button calculateButton;
    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calories_burnt);

        exerciseEditText = findViewById(R.id.exerciseEditText);
        sleepingEditText = findViewById(R.id.sleepingEditText);
        walkingEditText = findViewById(R.id.walkingEditText);
        mobileEditText = findViewById(R.id.mobileEditText);
        othersEditText = findViewById(R.id.othersEditText);

        calculateButton = findViewById(R.id.calculateButton);
        resultTextView = findViewById(R.id.resultTextView);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int exerciseTime = Integer.parseInt(exerciseEditText.getText().toString());
                int sleepingTime = Integer.parseInt(sleepingEditText.getText().toString());
                int walkingTime = Integer.parseInt(walkingEditText.getText().toString());
                int mobileTime = Integer.parseInt(mobileEditText.getText().toString());
                int othersTime = Integer.parseInt(othersEditText.getText().toString());

                Map<String, Integer> activityTimeMap = new HashMap<>();
                activityTimeMap.put("Exercise", exerciseTime);
                activityTimeMap.put("Sleeping", sleepingTime);
                activityTimeMap.put("Walking", walkingTime);
                activityTimeMap.put("Mobile", mobileTime);
                activityTimeMap.put("Others", othersTime);

                StringBuilder resultBuilder = new StringBuilder();
                resultBuilder.append("Activities in descending order of time spent:\n");
                List<Map.Entry<String, Integer>> entryList = new ArrayList<>(activityTimeMap.entrySet());
                Collections.sort(entryList, Collections.reverseOrder(Map.Entry.comparingByValue()));
                for (Map.Entry<String, Integer> entry : entryList) {
                    resultBuilder.append(entry.getKey()).append(": ").append(entry.getValue()).append(" units\n");
                }
                resultBuilder.append("\nActivities to reduce:\n");
                Collections.sort(entryList, Map.Entry.comparingByValue());
                for (Map.Entry<String, Integer> entry : entryList) {
                    if (entry.getKey().equals("Mobile") || entry.getKey().equals("Sleeping")) {
                        resultBuilder.append(entry.getKey()).append(": ").append(entry.getValue()).append(" units\n");
                    }
                }
                resultBuilder.append("\nActivities to increase:\n");
                Collections.sort(entryList, Collections.reverseOrder(Map.Entry.comparingByValue()));
                for (Map.Entry<String, Integer> entry : entryList) {
                    if (entry.getKey().equals("Exercise") || entry.getKey().equals("Walking")) {
                        resultBuilder.append(entry.getKey()).append(": ").append(entry.getValue()).append(" units\n");
                    }
                }
                resultBuilder.append("\nAddiction:\n");
                for (Map.Entry<String, Integer> entry : entryList) {
                    if (entry.getKey().equals("Mobile")) {
                        if (entry.getValue() > 120) {
                            resultBuilder.append("You are addicted to Mobile.\n");
                        } else {
                            resultBuilder.append("You are not addicted to Mobile.\n");
                        }
                    }
                }

                resultTextView.setText(resultBuilder.toString());
            }
        });
    }
}
