package com.example.tablelayoutmenu;

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

        TableRow rowOpen = findViewById(R.id.row_open);
        TableRow rowSave = findViewById(R.id.row_save);
        TableRow rowQuit = findViewById(R.id.row_quit);

        rowOpen.setOnClickListener(view -> showToast("Open Clicked"));
        rowSave.setOnClickListener(view -> showToast("Save Clicked"));
        rowQuit.setOnClickListener(view -> showToast("Quit Clicked"));
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}

