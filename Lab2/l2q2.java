package com.example.l2q2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button add,sub,prod,div,equ,clr;
    public EditText e1, e2;
    public TextView t1;
    int num1, num2;
    String disp="";

    boolean getNum()
    {
        e1 = (EditText) findViewById(R.id.num1);
        // defining the edit text 2 to e2
        e2 = (EditText) findViewById(R.id.num2);
        // defining the text view to t1
        t1 = (TextView) findViewById(R.id.result);
        // taking input from text box 1
        String s1 = e1.getText().toString();
        // taking input from text box 2
        String s2 = e2.getText().toString();
        if(s1.equals("Please enter value 1") && s2.equals(null))
        {
            String result = "Please enter value 2";
            t1.setText(result);
            return false;
        }
        if(s1.equals(null) && s2.equals("Please enter value 2"))
        {
            String result = "Please enter value 1";
            t1.setText(result);
            return false;
        }
        if(s1.equals("Please enter value 1") || s2.equals("Please enter value 2"))
        {
            return false;
        }

        if((!s1.equals(null) && s2.equals(null))|| (!s1.equals("") && s2.equals("")) ){

            String result = "Please enter value 2";

            t1.setText(result);
            return false;
        }
        if((s1.equals(null) && !s2.equals(null))|| (s1.equals("") && !s2.equals("")) ){
            //checkAndClear();
            String result = "Please enter value 1";
            t1.setText(result);
            return false;
        }
        if((s1.equals(null) && s2.equals(null))|| (s1.equals("") && s2.equals("")) ){
            //checkAndClear();
            String result = "Please enter value 1 and value 2";
            t1.setText(result);

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
        clr= findViewById(R.id.clr);
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
                        t1.setText(disp);
                    }

                }
        );
        clr.setOnClickListener(view ->
                {
                    t1.setText("");


                }
        );
    };



}
