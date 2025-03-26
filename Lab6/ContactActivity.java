package com.example.l6q1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        TextView phoneNumber = findViewById(R.id.phone_number);
        phoneNumber.setOnClickListener(v ->{
            Intent dial=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:1234567890"));
            startActivity(dial);
        });
    }
}