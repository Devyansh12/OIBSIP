package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView3;
    TextView textView4;
    EditText editText3;
    EditText editText4;
    Button b2;
    Button b3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView3 = findViewById(R.id.textView);
        textView4 = findViewById(R.id.textView2);
        editText3 = findViewById(R.id.editText);
        editText4 = findViewById(R.id.editText2);
        b2 = findViewById(R.id.button);
        b3 = findViewById(R.id.button2);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n = editText3.getText().toString();
                int a = Integer.parseInt(n);
                double cm = (a * 100);
                textView3.setText("Value in centimeters: "+cm);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n = editText4.getText().toString();
                int k = Integer.parseInt(n);
                double m = (k / 100);
                textView4.setText("Value in meters: "+m);
            }
        });



    }
}