package com.example.l5q1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String vtype;
    String vehno;
    String rcno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spin=findViewById(R.id.vtype);
        EditText vno=findViewById(R.id.vehnoval);
        EditText rno=findViewById(R.id.rcnoval);
        Button submit=findViewById(R.id.submit);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
                vtype= adapterView.getItemAtPosition(pos).toString();
                Toast.makeText(MainActivity.this,"Selected item is "+vtype, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayList<String> arr=new ArrayList<>();
        arr.add("Car");
        arr.add("Bike");
        arr.add("Scooter");
        arr.add("Van");
        arr.add("Truck");
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,arr);
        adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spin.setAdapter(adapter);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vehno=vno.getText().toString();
                rcno=rno.getText().toString();
                if(vehno.equals(null) || rcno.equals(null) || vtype.equals(null))
                    Toast.makeText(MainActivity.this,"Please enter values in all the fields",Toast.LENGTH_SHORT).show();
                else {
                    Intent intent=new Intent(getApplicationContext(),ConfirmationActivity.class);
                    intent.putExtra("vtype",vtype);
                    intent.putExtra("vehno",vehno);
                    intent.putExtra("rcno",rcno);
                    startActivity(intent);
                }

            }
        });

    }
}