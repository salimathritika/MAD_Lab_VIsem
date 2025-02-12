package com.example.l5q1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ConfirmationActivity extends AppCompatActivity {

    StringBuilder res=new StringBuilder();
    TextView det;
    Button con,edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);
        String temp;
        det=findViewById(R.id.details);
        String vtype=getIntent().getStringExtra("vtype");
        res.append("Vehicle Type:"+vtype+"\n");
        String vehno=getIntent().getStringExtra("vehno");
        res.append("Vehicle Number:"+vehno+"\n");
        String rcno=getIntent().getStringExtra("rcno");
        res.append("RC Number:"+rcno+"\n");
        det.setText(res);
        con=findViewById(R.id.confirm);
        edit=findViewById(R.id.edit);

        con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String serno=rcno+vehno;
                Toast.makeText(getApplicationContext(),"Serial number is:"+serno,Toast.LENGTH_LONG).show();
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back=new Intent(ConfirmationActivity.this,MainActivity.class);
                startActivity(back);
            }
        });

    }
}