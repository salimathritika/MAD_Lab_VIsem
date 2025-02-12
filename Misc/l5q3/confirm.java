package com.example.movieticketbooking;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ConfirmationActivity extends AppCompatActivity {

    private TextView detailsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        detailsTextView = findViewById(R.id.detailsTextView);

        String movie = getIntent().getStringExtra("movie");
        String theatre = getIntent().getStringExtra("theatre");
        String date = getIntent().getStringExtra("date");
        String time = getIntent().getStringExtra("time");
        String ticketType = getIntent().getStringExtra("ticketType");

        detailsTextView.setText("Movie: " + movie + "\nTheatre: " + theatre + "\nDate: " + date +
                "\nTime: " + time + "\nTicket Type: " + ticketType + "\nAvailable Seats: 50");
    }
}
