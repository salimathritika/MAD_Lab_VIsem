package com.example.movieticketbooking;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private Spinner movieSpinner, theatreSpinner;
    private TextView dateTextView, timeTextView;
    private Switch ticketTypeSwitch;
    private Button bookNowButton, resetButton;
    private Calendar selectedCalendar;
    private boolean isPremiumSelected = false;
    private int selectedHour, selectedMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieSpinner = findViewById(R.id.movieSpinner);
        theatreSpinner = findViewById(R.id.theatreSpinner);
        dateTextView = findViewById(R.id.dateTextView);
        timeTextView = findViewById(R.id.timeTextView);
        ticketTypeSwitch = findViewById(R.id.ticketTypeSwitch);
        bookNowButton = findViewById(R.id.bookNowButton);
        resetButton = findViewById(R.id.resetButton);

        selectedCalendar = Calendar.getInstance();
        updateDateTextView();

        setupSpinners();

        dateTextView.setOnClickListener(v -> showDatePicker());
        timeTextView.setOnClickListener(v -> showTimePicker());

        ticketTypeSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            isPremiumSelected = isChecked;
            validatePremiumTime();
        });

        bookNowButton.setOnClickListener(v -> bookTicket());

        resetButton.setOnClickListener(v -> resetFields());

        validatePremiumTime();
    }

    private void setupSpinners() {
        ArrayAdapter<CharSequence> movieAdapter = ArrayAdapter.createFromResource(this,
                R.array.movies, android.R.layout.simple_spinner_item);
        movieAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        movieSpinner.setAdapter(movieAdapter);

        ArrayAdapter<CharSequence> theatreAdapter = ArrayAdapter.createFromResource(this,
                R.array.theatres, android.R.layout.simple_spinner_item);
        theatreAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        theatreSpinner.setAdapter(theatreAdapter);
    }

    private void showDatePicker() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, (view, year, month, dayOfMonth) -> {
            selectedCalendar.set(year, month, dayOfMonth);
            updateDateTextView();
        }, selectedCalendar.get(Calendar.YEAR), selectedCalendar.get(Calendar.MONTH), selectedCalendar.get(Calendar.DAY_OF_MONTH));

        datePickerDialog.show();
    }

    private void showTimePicker() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, (view, hourOfDay, minute) -> {
            selectedHour = hourOfDay;
            selectedMinute = minute;
            timeTextView.setText(String.format("%02d:%02d", hourOfDay, minute));
            validatePremiumTime();
        }, selectedCalendar.get(Calendar.HOUR_OF_DAY), selectedCalendar.get(Calendar.MINUTE), false);

        timePickerDialog.show();
    }

    private void updateDateTextView() {
        dateTextView.setText(android.text.format.DateFormat.format("yyyy-MM-dd", selectedCalendar));
    }

    private void validatePremiumTime() {
        if (isPremiumSelected && selectedHour < 12) {
            bookNowButton.setEnabled(false);
            Toast.makeText(this, "Premium tickets can only be booked after 12:00 PM", Toast.LENGTH_SHORT).show();
        } else {
            bookNowButton.setEnabled(true);
        }
    }

    private void bookTicket() {
        String movie = movieSpinner.getSelectedItem().toString();
        String theatre = theatreSpinner.getSelectedItem().toString();
        String date = dateTextView.getText().toString();
        String time = timeTextView.getText().toString();
        String ticketType = isPremiumSelected ? "Premium" : "Standard";

        Intent intent = new Intent(MainActivity.this, ConfirmationActivity.class);
        intent.putExtra("movie", movie);
        intent.putExtra("theatre", theatre);
        intent.putExtra("date", date);
        intent.putExtra("time", time);
        intent.putExtra("ticketType", ticketType);
        startActivity(intent);
    }

    private void resetFields() {
        movieSpinner.setSelection(0);
        theatreSpinner.setSelection(0);
        selectedCalendar = Calendar.getInstance();
        updateDateTextView();
        timeTextView.setText("Select Time");
        ticketTypeSwitch.setChecked(false);
    }
}
