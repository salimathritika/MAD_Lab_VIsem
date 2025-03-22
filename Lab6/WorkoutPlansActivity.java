package com.example.l6q1;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class WorkoutPlansActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_plans);

        ListView listView = findViewById(R.id.listView);
        String[] workouts = {"Weight Loss", "Cardio", "Strength Training", "Yoga"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, workouts);
        listView.setAdapter(adapter);
    }
}