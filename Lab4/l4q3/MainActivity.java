package com.example.l4q3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ToggleButton toggleButton;
    private ImageView imageViewMode;
    private Button changeModeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        toggleButton = findViewById(R.id.toggleButton);
        imageViewMode = findViewById(R.id.imageViewMode);
        changeModeButton = findViewById(R.id.changeModeButton);

        // Set initial state of the toggle button and image
        updateMode();

        // Set listener for toggle button change
        toggleButton.setOnCheckedChangeListener((buttonView, isChecked) -> updateMode());

        // Set listener for the "Change Mode" button
        changeModeButton.setOnClickListener(v -> toggleMode());
    }

    // Update the mode based on the current state of the toggle button
    private void updateMode() {
        if (toggleButton.isChecked()) {
            // If the toggle button is checked, set Mobile Data mode
            imageViewMode.setImageResource(R.drawable.img_1);
            showToast("Mobile Data mode selected");
        } else {
            // If the toggle button is not checked, set Wi-Fi mode
            imageViewMode.setImageResource(R.drawable.img);
            showToast("Wi-Fi mode selected");
        }
    }

    // Toggle the mode between Wi-Fi and Mobile Data
    private void toggleMode() {
        if (toggleButton.isChecked()) {
            // If currently in Mobile Data mode, switch to Wi-Fi
            toggleButton.setChecked(false);
        } else {
            // If currently in Wi-Fi mode, switch to Mobile Data
            toggleButton.setChecked(true);
        }
    }

    // Show a toast message
    private void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
