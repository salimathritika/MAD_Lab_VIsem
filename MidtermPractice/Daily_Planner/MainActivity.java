package com.example.daily_planner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    EditText task;
    Button add,clr,sub;
    Spinner pri;
    DatePicker dp;
    TimePicker time;
    String priority,d,t;
    StringBuilder ta=new StringBuilder();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        task=findViewById(R.id.task);
        add=findViewById(R.id.add);
        sub=findViewById(R.id.submit);
        clr=findViewById(R.id.clr);
        dp=findViewById(R.id.date);
        time=findViewById(R.id.time);
        pri=findViewById(R.id.prio);

        String arr[] = {"Low", "Medium", "High"};
        ArrayAdapter<String> ada = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, arr);
        pri.setAdapter(ada);


        pri.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                priority = parent.getItemAtPosition(position).toString();
                toastmsg("The selected priority: " + priority);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                priority = "Low";
            }
        });




        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val=task.getText().toString();
                if(val.isEmpty())
                    toastmsg("Please enter a task");
                if(priority == null || priority.isEmpty())
                    toastmsg("Please select priority");
                else {
                    String timing=String.valueOf(time.getHour())+":"+String.valueOf(time.getMinute());
                    String day=String.valueOf(dp.getDayOfMonth())+"/"+String.valueOf(dp.getMonth()+1)+"/"+String.valueOf(dp.getYear());
                    ta.append("Task:"+val+"\n");
                    ta.append("Day:"+day+"\n");
                    ta.append("Time:"+timing+"\n");
                    ta.append("Priority:"+priority+"\n\n");
                }
            }
        });

        clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pri.setSelection(0);
                Calendar currdate=Calendar.getInstance();
                dp.updateDate(
                        currdate.get(Calendar.YEAR),
                        currdate.get(Calendar.MONTH),
                        currdate.get(Calendar.DAY_OF_MONTH)
                );
                Calendar currentTime = Calendar.getInstance();
                int hour = currentTime.get(Calendar.HOUR_OF_DAY); // 24-hour format
                int minute = currentTime.get(Calendar.MINUTE);

                time.setHour(hour);
                time.setMinute(minute);
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,DisplayTasks.class);
                intent.putExtra("tasks",ta.toString());
                startActivity(intent);
            }
        });

    }

    void toastmsg(String msg)
    {
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT).show();
    }
}