package com.example.l7q1;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AppDetailsActivity extends AppCompatActivity {
    TextView detailsText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_details);

        detailsText = findViewById(R.id.detailsText);
        String packageName = getIntent().getStringExtra("package");

        try {
            PackageManager pm = getPackageManager();
            detailsText.setText("App: " + pm.getApplicationLabel(pm.getApplicationInfo(packageName, 0)) +
                    "\nPackage: " + packageName +
                    "\nVersion: " + pm.getPackageInfo(packageName, 0).versionName);
        } catch (Exception e) {
            detailsText.setText("Error loading details.");
        }
    }
}
