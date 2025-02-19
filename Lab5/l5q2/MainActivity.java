package com.example.l5q2;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import android.content.Intent;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    DatePicker dp;
    String date,start,dest,type;
    Spinner src,dst;
    ToggleButton tog;
    Button sub,reset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        src=findViewById(R.id.src);
        dst=findViewById(R.id.dst);
        tog=findViewById(R.id.tog);
        dp=findViewById(R.id.date);
        sub=findViewById(R.id.submit);
        reset=findViewById(R.id.reset);

        updateMode();

        tog.setOnCheckedChangeListener((buttonView, isChecked) -> updateMode());

        src.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
                start= adapterView.getItemAtPosition(pos).toString();
                Toast.makeText(MainActivity.this,"Source location is "+start, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        dst.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
                dest= adapterView.getItemAtPosition(pos).toString();
                Toast.makeText(MainActivity.this,"Destination location is "+dest, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayList<String> arr=new ArrayList<>();
        arr.add("Bangalore");
        arr.add("Delhi");
        arr.add("Mangalore");
        arr.add("Hyderabad");
        arr.add("Mumbai");
        arr.add("Jaipur");
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,arr);
        adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        src.setAdapter(adapter);
        dst.setAdapter(adapter);


        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String day,month,year;
                day=String.valueOf(dp.getDayOfMonth());
                month=String.valueOf(dp.getMonth()+1);
                year=String.valueOf(dp.getYear());
                date=day+"/"+month+"/"+year;
                Toast.makeText(getApplicationContext(),date,Toast.LENGTH_SHORT).show();
                StringBuilder details=new StringBuilder();
                details.append("Source Location:"+start+"\n\n");
                details.append("Destination Location:"+dest+"\n\n");
                details.append("Date of journey:"+date+"\n\n");
                details.append("Type of Ticket:"+type+"\n\n");
                Intent intent=new Intent(MainActivity.this,DisplayActivity.class);
                String d=details.toString();
                intent.putExtra("details",d);
                startActivity(intent);


            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetFields();
            }
        });
    }

    private void updateMode() {
        if (tog.isChecked()) {
            type="Round Trip Ticket";
        } else {
            type="One Way Ticket";
        }
    }
    private void resetFields() {
        src.setSelection(0);
        dst.setSelection(0);

        Calendar currentDate = Calendar.getInstance();
        dp.updateDate(
                currentDate.get(Calendar.YEAR),
                currentDate.get(Calendar.MONTH),
                currentDate.get(Calendar.DAY_OF_MONTH)
        );

        tog.setChecked(false);
    }
}

