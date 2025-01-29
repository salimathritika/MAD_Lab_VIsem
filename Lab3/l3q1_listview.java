package com.example.l3q1_listview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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

        arrNames.add("American Samoa");
        arrNames.add("El Salvador");
        arrNames.add("Saint Helena");
        arrNames.add("Saint Kitts and Nevis");
        arrNames.add("Saint Lucia");
        arrNames.add("Saint Pierre and Miquelon");
        arrNames.add("Samoa");
        arrNames.add("San Marino");
        arrNames.add("Saudi Arabia");

        ArrayAdapter<String> adapter=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,arrNames);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l){
                Toast.makeText(MainActivity.this, "Clicked on " + arrNames.get(position), Toast.LENGTH_SHORT).show();
            }
        });

}
}
