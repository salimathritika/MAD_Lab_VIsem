package com.example.l5q3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    DatePicker dp;
    TimePicker tp;
    String date,movie,theatre,ticket_type;
    Spinner mov,thea,tick;
    ToggleButton tog;
    Button sub,reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mov=findViewById(R.id.movie);
        thea=findViewById(R.id.theatre);
        tick=findViewById(R.id.ticktype);
        dp=findViewById(R.id.date);
        sub=findViewById(R.id.submit);
        reset=findViewById(R.id.reset);
        tp=findViewById(R.id.time);

        mov.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
                movie= adapterView.getItemAtPosition(pos).toString();
                Toast.makeText(MainActivity.this,"Movie: "+movie, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        thea.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
                theatre = adapterView.getItemAtPosition(pos).toString();
                Toast.makeText(MainActivity.this, "Theatre: " + theatre, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        tick.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
                ticket_type = adapterView.getItemAtPosition(pos).toString();
                Toast.makeText(MainActivity.this, "Type of ticket: " + ticket_type, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayList<String> m=new ArrayList<>();
        m.add("Om Shanti Om");
        m.add("Bhaagam Bhaag");
        m.add("Ra-One");
        m.add("Tees Maar Khan");
        m.add("October");
        m.add("Iron Man");
        ArrayAdapter<String> mov_adapter=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,m);
        mov_adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        mov.setAdapter(mov_adapter);

        ArrayList<String> th=new ArrayList<>();
        th.add("Bangalore");
        th.add("Mumbai");
        th.add("Delhi");
        ArrayAdapter<String> th_adapter=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,th);
        th_adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        thea.setAdapter(th_adapter);

        ArrayList<String> ti=new ArrayList<>();
        ti.add("Standard");
        ti.add("Premium");
        ArrayAdapter<String> ti_adapter=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,ti);
        ti_adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        tick.setAdapter(ti_adapter);

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String day,month,year;
                day=String.valueOf(dp.getDayOfMonth());
                month=String.valueOf(dp.getMonth()+1);
                year=String.valueOf(dp.getYear());
                date=day+"/"+month+"/"+year;

                int hour = tp.getHour();
                int minute = tp.getMinute();

                String time = hour+":"+minute;

                StringBuilder details=new StringBuilder();
                details.append("Movie:"+movie+"\n\n");
                details.append("Theatre:"+theatre+"\n\n");
                details.append("Date of movie:"+date+"\n\n");
                details.append("Time of movie:"+time+"\n\n");
                details.append("Type of Ticket:"+ticket_type+"\n\n");
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

    private void resetFields() {
        mov.setSelection(0);
        thea.setSelection(0);
        tick.setSelection(0);

        Calendar currentDate = Calendar.getInstance();
        dp.updateDate(
                currentDate.get(Calendar.YEAR),
                currentDate.get(Calendar.MONTH),
                currentDate.get(Calendar.DAY_OF_MONTH)
        );
        Calendar currentTime = Calendar.getInstance();
        int hour = currentTime.get(Calendar.HOUR_OF_DAY); // 24-hour format
        int minute = currentTime.get(Calendar.MINUTE);

        tp.setHour(hour);
        tp.setMinute(minute);


    }
}