package com.example.prgchk2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button add,sub,prod,div,equ;
    public EditText e1, e2;
    int num1, num2;
    String disp="";

    boolean getNum()
    {
        e1 = (EditText) findViewById(R.id.num1);
        e2 = (EditText) findViewById(R.id.num2);

        String s1 = e1.getText().toString();

        String s2 = e2.getText().toString();
        if(s1.equals("Please enter value 1") && s2.equals(null))
        {
            String result = "Please enter value 2";
            Toast.makeText(MainActivity.this,result,Toast.LENGTH_LONG).show();
            return false;
        }
        if(s1.equals(null) && s2.equals("Please enter value 2"))
        {
            String result = "Please enter value 1";
            Toast.makeText(MainActivity.this,result,Toast.LENGTH_LONG).show();
            return false;
        }
        if(s1.equals("Please enter value 1") || s2.equals("Please enter value 2"))
        {
            return false;
        }

        if((!s1.equals(null) && s2.equals(null))|| (!s1.equals("") && s2.equals("")) ){

            String result = "Please enter value 2";

            Toast.makeText(MainActivity.this,result,Toast.LENGTH_LONG).show();
            return false;
        }
        if((s1.equals(null) && !s2.equals(null))|| (s1.equals("") && !s2.equals("")) ){
            //checkAndClear();
            String result = "Please enter value 1";
            Toast.makeText(MainActivity.this,result,Toast.LENGTH_LONG).show();
            return false;
        }
        if((s1.equals(null) && s2.equals(null))|| (s1.equals("") && s2.equals("")) ){
            //checkAndClear();
            String result = "Please enter value 1 and value 2";
            Toast.makeText(MainActivity.this,result,Toast.LENGTH_LONG).show();

            return false;
        }

        else
        {
            num1=Integer.parseInt(s1);
            num2=Integer.parseInt(s2);
            return true;
        }


    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView);
        add = findViewById(R.id.add);
        sub= findViewById(R.id.sub);
        prod= findViewById(R.id.prod);
        div= findViewById(R.id.divide);
        equ= findViewById(R.id.equals);
        add.setOnClickListener(view ->
                {
                    if(getNum()) {
                        int res=num1+num2;
                        disp=num1+"+"+num2+"="+res;
                    }

                }
        );
        sub.setOnClickListener(view ->
                {
                    if(getNum()) {
                        int res=num1-num2;
                        disp=num1+"-"+num2+"="+res;
                    }

                }
        );
        prod.setOnClickListener(view ->
                {
                    if(getNum()) {
                        int res=num1*num2;
                        disp=num1+"*"+num2+"="+res;
                    }

                }
        );
        div.setOnClickListener(view ->
                {
                    if(getNum()) {
                        double res=(double)num1/num2;
                        disp=num1+"/"+num2+"="+res;
                    }

                }
        );
        equ.setOnClickListener(view ->
                {
                    if(getNum()) {
                        Toast.makeText(MainActivity.this,disp,Toast.LENGTH_LONG).show();
                    }

                }
        );

    };



}