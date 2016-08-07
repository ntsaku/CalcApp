package com.example.naosan.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView textView = (TextView) findViewById(R.id.textView);


        Intent intent = getIntent();
        int value2 = intent.getIntExtra("VALUE2", 0);
        if (value2 == 1) {/*　VALUE1はint型である*/
            int valuei = intent.getIntExtra("VALUE1", 0);
            textView.setText(String.valueOf(valuei));
        } else { /*VALUE1はdouble型である*/
            double valued = intent.getDoubleExtra("VALUE1", 0);
            textView.setText(String.valueOf(valued));
        }

    }
}
