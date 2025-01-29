package com.example.l4q1;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Array of images to cycle through when ToggleButton is ON
    private int[] imageArray = {R.drawable.img, R.drawable.img_1, R.drawable.img_2};
    private int imageIndex = 0; // Keeps track of which image to show next

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        ToggleButton toggleButton = findViewById(R.id.toggleButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check ToggleButton state
                if (toggleButton.isChecked()) {
                    // ToggleButton is ON: show a new image each time
                    showCustomToast(imageArray[imageIndex]);
                    imageIndex = (imageIndex + 1) % imageArray.length; // Cycle through images
                } else {
                    // ToggleButton is OFF: always show the first image
                    if(imageIndex!=0)
                      showCustomToast(imageArray[imageIndex - 1]);
                    else
                        showCustomToast(imageArray[imageArray.length - 1]);
                }
            }
        });
    }

    private void showCustomToast(int imageResId) {
        // Create a Toast with a custom layout
        Toast toast = new Toast(getApplicationContext());

        // Create an ImageView for the image
        ImageView imageView = new ImageView(getApplicationContext());
        imageView.setImageResource(imageResId);

        // Add the ImageView to the Toast layout
        LinearLayout layout = new LinearLayout(getApplicationContext());
        layout.setGravity(Gravity.CENTER);
        layout.addView(imageView);

        // Set Toast properties
        toast.setView(layout);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();
    }
}
