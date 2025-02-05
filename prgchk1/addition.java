package com.example.prgchk1;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class addition extends Fragment {

    private Button add, sub, prod, div, equ;
    public EditText e1, e2;
    int num1, num2;
    String disp = "";

    boolean getNum() {
        String s1 = e1.getText().toString();
        String s2 = e2.getText().toString();

        // Check if any input is empty
        if (s1.isEmpty() && s2.isEmpty()) {
            Toast.makeText(getContext(), "Please enter value 1 and value 2", Toast.LENGTH_LONG).show();
            return false;
        }
        if (s1.isEmpty()) {
            Toast.makeText(getContext(), "Please enter value 1", Toast.LENGTH_LONG).show();
            return false;
        }
        if (s2.isEmpty()) {
            Toast.makeText(getContext(), "Please enter value 2", Toast.LENGTH_LONG).show();
            return false;
        }

        try {
            num1 = Integer.parseInt(s1);
            num2 = Integer.parseInt(s2);
        } catch (NumberFormatException e) {
            Toast.makeText(getContext(), "Please enter valid numbers", Toast.LENGTH_LONG).show();
            return false;
        }

        return true;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_addition, container, false);

        add = rootView.findViewById(R.id.add);
        sub = rootView.findViewById(R.id.sub);
        prod = rootView.findViewById(R.id.prod);
        div = rootView.findViewById(R.id.divide);
        equ = rootView.findViewById(R.id.equals);
        e1 = rootView.findViewById(R.id.num1);
        e2 = rootView.findViewById(R.id.num2);

        add.setOnClickListener(view -> {
            if (getNum()) {
                int res = num1 + num2;
                disp = num1 + " + " + num2 + " = " + res;
            }
        });

        sub.setOnClickListener(view -> {
            if (getNum()) {
                int res = num1 - num2;
                disp = num1 + " - " + num2 + " = " + res;
            }
        });

        prod.setOnClickListener(view -> {
            if (getNum()) {
                int res = num1 * num2;
                disp = num1 + " * " + num2 + " = " + res;
            }
        });

        div.setOnClickListener(view -> {
            if (getNum()) {
                if (num2 == 0) {
                    Toast.makeText(getContext(), "Cannot divide by zero", Toast.LENGTH_LONG).show();
                    return;
                }
                double res = (double) num1 / num2;
                disp = num1 + " / " + num2 + " = " + res;
            }
        });

        equ.setOnClickListener(view -> {
            if (getNum()) {
                Toast.makeText(getContext(), disp, Toast.LENGTH_LONG).show();
            }
        });

        return rootView;
    }
}
