// MainActivity.java
package com.example.vehicleparking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Spinner vehicleTypeSpinner;
    private EditText vehicleNumber, rcNumber;
    private Button submitButton;
    private String selectedVehicleType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vehicleTypeSpinner = findViewById(R.id.vehicleTypeSpinner);
        vehicleNumber = findViewById(R.id.vehicleNumber);
        rcNumber = findViewById(R.id.rcNumber);
        submitButton = findViewById(R.id.submitButton);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.vehicle_types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        vehicleTypeSpinner.setAdapter(adapter);

        vehicleTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedVehicleType = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        submitButton.setOnClickListener(v -> {
            String vehicleNum = vehicleNumber.getText().toString();
            String rcNum = rcNumber.getText().toString();

            Intent intent = new Intent(MainActivity.this, ConfirmationActivity.class);
            intent.putExtra("vehicleType", selectedVehicleType);
            intent.putExtra("vehicleNumber", vehicleNum);
            intent.putExtra("rcNumber", rcNum);
            startActivity(intent);
        });
    }
}
