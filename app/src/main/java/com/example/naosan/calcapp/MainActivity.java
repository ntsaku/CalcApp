package com.example.naosan.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonTasu = (Button) findViewById(R.id.buttonTasu);
        buttonTasu.setOnClickListener(this);
        
        Button buttonHiku = (Button) findViewById(R.id.buttonHiku);
        buttonHiku.setOnClickListener(this);
        
        Button buttonKake = (Button) findViewById(R.id.buttonKake);
        buttonKake.setOnClickListener(this);
        
        Button buttonWaru = (Button) findViewById(R.id.buttonWaru);
        buttonWaru.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int ans = 0;
        double ansd = 0.0;
        Intent intent = new Intent(this, SecondActivity.class);

        EditText mEditText1 = (EditText) findViewById(R.id.editText1);
        EditText mEditText2 = (EditText) findViewById(R.id.editText2);

        String str1 = mEditText1.getText().toString();
        int i1 = Integer.parseInt(str1);
        String str2 = mEditText2.getText().toString();
        int i2 = Integer.parseInt(str2);

//        処理が＋、－、×の場合は、結果を整数表示したいので　putExtra()のVALUE1にint型でわたす。
//        処理が÷の場合は、結果を小数点対応するため、VALUE1にdouble型でわたす。
//        SecondActivity画面で、 getIntExtra() getDoubleExtra()のどちらで受け取るべきかを判断するために、VALUE2に 1(int型)、0(double型)をわたす。

        if (v.getId() == R.id.buttonTasu) {
            ans = i1 + i2;
            intent.putExtra("VALUE1",ans);
            intent.putExtra("VALUE2", 1);
        } else if (v.getId() == R.id.buttonHiku) {
            ans = i1 - i2;
            intent.putExtra("VALUE1",ans);
            intent.putExtra("VALUE2", 1);
        } else if (v.getId() == R.id.buttonKake) {
            ans = i1 * i2;
            intent.putExtra("VALUE1",ans);
            intent.putExtra("VALUE2", 1);
        } else if (v.getId() == R.id.buttonWaru) {
            ansd = (double)i1 / (double)i2;
            intent.putExtra("VALUE1",ansd);
            intent.putExtra("VALUE2", 0);
        }
        startActivity(intent);
    }
}
