package com.example.l3q1_tablelayout;

import android.os.Bundle;
import android.view.View;
import android.widget.TableRow;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Fix: Ensure IDs match the XML layout
        TableRow rowOpen = findViewById(R.id.row_open);
        TableRow rowSave = findViewById(R.id.row_save);
        TableRow rowSaveAs = findViewById(R.id.row_save_as);
        TableRow rowImport = findViewById(R.id.row_import);
        TableRow rowExport = findViewById(R.id.row_export);
        TableRow rowQuit = findViewById(R.id.row_quit);

        // Set click listeners for each row
        rowOpen.setOnClickListener(view -> showToast("Open Clicked"));
        rowSave.setOnClickListener(view -> showToast("Save Clicked"));
        rowSaveAs.setOnClickListener(view -> showToast("Save As Clicked"));
        rowImport.setOnClickListener(view -> showToast("Import Clicked"));
        rowExport.setOnClickListener(view -> showToast("Export Clicked"));
        rowQuit.setOnClickListener(view -> showToast("Quit Clicked"));
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}