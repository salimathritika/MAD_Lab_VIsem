package com.example.l3q2;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<String> arrNames=new ArrayList<>();
    int arrNo[]=new int[]{1,2,3,4,5};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.listView);

        arrNames.add("Cricket");
        arrNames.add("Football");
        arrNames.add("Throwball");
        arrNames.add("Rugby");
        arrNames.add("Hockey");
        arrNames.add("Swimming");
        arrNames.add("Tennis");
        arrNames.add("Table Tennis");
        arrNames.add("Badminton");
        arrNames.add("Squash");

        ArrayAdapter<String> adapter=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,arrNames);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l){
                Toast.makeText(MainActivity.this, "Clicked on " + arrNames.get(position), Toast.LENGTH_SHORT).show();
            }
        });

    }
}