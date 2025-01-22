package com.example.l2q4;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.net.Uri;
import android.content.Intent;
import android.widget.Toast;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button go;
    public EditText val;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        val = (EditText) findViewById(R.id.val);
        go = findViewById(R.id.go);

        go.setOnClickListener(view ->
                {
                    String s=val.getText().toString();
                    Intent intent = new Intent(android.content.Intent.ACTION_VIEW);

                    try {
                        intent.setData(Uri.parse(s));
                        startActivity(intent);
                    } catch (Exception exception) {

                        CharSequence text = "Incorrect URL";
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(getApplicationContext(), text, duration);
                        toast.show();

                    }
                }
        );
    }
}
