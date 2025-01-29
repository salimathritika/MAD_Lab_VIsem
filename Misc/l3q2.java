package com.example.sportslist;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView sportsListView = findViewById(R.id.sportsListView);

        // Array of sports
        final String[] sports = {"Football", "Basketball", "Cricket", "Tennis", "Hockey", "Baseball", "Badminton"};

        // ArrayAdapter to populate the ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sports);
        sportsListView.setAdapter(adapter);

        // Item click listener to display the selected sport
        sportsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedSport = sports[position];
                Toast.makeText(MainActivity.this, "Selected Sport: " + selectedSport, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
