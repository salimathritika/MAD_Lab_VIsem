package com.example.l6q1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up icon navigation
        ImageView homeIcon = findViewById(R.id.home_icon);
        ImageView aboutIcon = findViewById(R.id.about_icon);
        ImageView contactIcon = findViewById(R.id.contact_icon);

        homeIcon.setOnClickListener(v -> Toast.makeText(this, "Home Page", Toast.LENGTH_SHORT).show());
        aboutIcon.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, AboutActivity.class)));
        contactIcon.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, ContactActivity.class)));
    }

    // Create the options menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    // Handle menu item clicks
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.workout_plans) {
            startActivity(new Intent(this, WorkoutPlansActivity.class));
            return true;
        } else if (id == R.id.trainers) {
            startActivity(new Intent(this, TrainersActivity.class));
            return true;
        } else if (id == R.id.membership) {
            startActivity(new Intent(this, MembershipActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}