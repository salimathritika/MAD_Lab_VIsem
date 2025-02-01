package com.example.l4q4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Declare CheckBoxes and Button
    private CheckBox foodItem1, foodItem2, foodItem3, foodItem4, foodItem5;
    private Button submitOrderButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize CheckBoxes and Button
        foodItem1 = findViewById(R.id.foodItem1);
        foodItem2 = findViewById(R.id.foodItem2);
        foodItem3 = findViewById(R.id.foodItem3);
        foodItem4 = findViewById(R.id.foodItem4);
        foodItem5 = findViewById(R.id.foodItem5);
        submitOrderButton = findViewById(R.id.submitOrderButton);

        // Set listener for Submit button
        submitOrderButton.setOnClickListener(v -> {
            // Create a string to store the ordered items and their costs
            StringBuilder orderedItems = new StringBuilder();
            int totalCost = 0;

            // Check which items are checked and add them to the ordered items list
            if (foodItem1.isChecked()) {
                orderedItems.append("Burger - $5\n");
                totalCost += 5;
            }
            if (foodItem2.isChecked()) {
                orderedItems.append("Pizza - $8\n");
                totalCost += 8;
            }
            if (foodItem3.isChecked()) {
                orderedItems.append("Pasta - $7\n");
                totalCost += 7;
            }
            if (foodItem4.isChecked()) {
                orderedItems.append("Soda - $2\n");
                totalCost += 2;
            }
            if (foodItem5.isChecked()) {
                orderedItems.append("Fries - $3\n");
                totalCost += 3;
            }

            // If no items are selected, show a message
            if (orderedItems.length() == 0) {
                Toast.makeText(MainActivity.this, "Please select at least one item", Toast.LENGTH_SHORT).show();
            } else {
                // Disable the checkboxes so the user cannot change the order
                foodItem1.setEnabled(false);
                foodItem2.setEnabled(false);
                foodItem3.setEnabled(false);
                foodItem4.setEnabled(false);
                foodItem5.setEnabled(false);

                // Pass the order details to OrderSummaryActivity
                Intent intent = new Intent(MainActivity.this, OrderSummaryActivity.class);
                intent.putExtra("orderedItems", orderedItems.toString());
                intent.putExtra("totalCost", totalCost);
                startActivity(intent);
            }
        });
    }
}
