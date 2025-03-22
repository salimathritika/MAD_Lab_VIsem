package com.example.l6q1;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

public class MembershipActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_membership);

        TextView textView = findViewById(R.id.membershipDetails);
        textView.setText("Basic: $30/month\nPremium: $50/month\nElite: $80/month");
    }
}