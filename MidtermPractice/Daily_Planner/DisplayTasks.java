package com.example.daily_planner;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayTasks extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_tasks);

        tv = findViewById(R.id.tasks);

        String s = getIntent().getStringExtra("tasks");

        if (s != null && !s.isEmpty()) {
            tv.setText(s);
        } else {
            tv.setText("No tasks available.");
        }
    }
}
