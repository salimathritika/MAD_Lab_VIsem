package com.example.l4q2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private String[] androidVersions = {
            "Android 1.0",
            "Android 2.0",
            "Android 4.0",
            "Android 5.0",
            "Android 10"
    };

    private int[] androidIcons = {
            R.drawable.img,
            R.drawable.img_1,
            R.drawable.img_2,
            R.drawable.img_3,
            R.drawable.img_4
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.button_android_1_0);
        Button button2 = findViewById(R.id.button_android_2_0);
        Button button3 = findViewById(R.id.button_android_4_0);
        Button button4 = findViewById(R.id.button_android_5_0);
        Button button5 = findViewById(R.id.button_android_10);

        button1.setOnClickListener(view -> showToast(0));
        button2.setOnClickListener(view -> showToast(1));
        button3.setOnClickListener(view -> showToast(2));
        button4.setOnClickListener(view -> showToast(3));
        button5.setOnClickListener(view -> showToast(4));
    }

    private void showToast(int index) {
        String versionName = androidVersions[index];
        int iconId = androidIcons[index];

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast_layout, null);

        TextView toastTextView = layout.findViewById(R.id.toastText);
        ImageView toastImageView = layout.findViewById(R.id.toastIcon);

        toastTextView.setText(versionName);
        toastImageView.setImageResource(iconId);

        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout); // Set the custom layout
        toast.show();
    }
}
