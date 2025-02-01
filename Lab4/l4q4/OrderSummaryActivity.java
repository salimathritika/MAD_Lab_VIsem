package com.example.l4q4;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class OrderSummaryActivity extends AppCompatActivity {

    private TextView orderedItemsTextView, totalCostTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_summary);

        // Initialize TextViews
        orderedItemsTextView = findViewById(R.id.orderedItemsTextView);
        totalCostTextView = findViewById(R.id.totalCostTextView);

        // Get the order details passed from MainActivity
        String orderedItems = getIntent().getStringExtra("orderedItems");
        int totalCost = getIntent().getIntExtra("totalCost", 0);

        // Display the ordered items and total cost
        orderedItemsTextView.setText(orderedItems);
        totalCostTextView.setText("Total Cost: $" + totalCost);
    }
}
