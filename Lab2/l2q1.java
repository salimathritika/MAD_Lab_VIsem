package com.example.l2q1;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "LifecycleApp"; // Tag for logging
    private TextView lifecycleStateTextView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        lifecycleStateTextView = findViewById(R.id.lifecycleStateTextView);
        button = findViewById(R.id.button);

        // Log the onCreate() method call
        Log.d(TAG, "onCreate() called");

        // Update the TextView to indicate the current state
        lifecycleStateTextView.setText("onCreate() called");

        // Set a click listener on the button to simulate user interaction
        button.setOnClickListener(v -> {
            // Log the button click event
            Log.d(TAG, "Button clicked");

            // Update the TextView on button click
            lifecycleStateTextView.setText("Button clicked, lifecycle state changes.");
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        // Log the onStart() method call
        Log.d(TAG, "onStart() called");

        // Update the TextView to reflect the current state
        lifecycleStateTextView.setText("onStart() called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Log the onResume() method call
        Log.d(TAG, "onResume() called");

        // Update the TextView to reflect the current state
        lifecycleStateTextView.setText("onResume() called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Log the onPause() method call
        Log.d(TAG, "onPause() called");

        // You can update the TextView here if needed (optional)
    }

    @Override
    protected void onStop() {
        super.onStop();
        // Log the onStop() method call
        Log.d(TAG, "onStop() called");

        // You can update the TextView here if needed (optional)
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Log the onDestroy() method call
        Log.d(TAG, "onDestroy() called");

        // You can clean up resources here if needed
    }
}
