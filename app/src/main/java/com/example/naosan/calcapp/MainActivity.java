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
        double d1 = 0, d2 = 0, ansd = 0;
        String ansMsg = null;
        Intent intent = new Intent(this, SecondActivity.class);
        String errMsg = null;
        boolean isErr = false;

        EditText mEditText1 = (EditText) findViewById(R.id.editText1);
        EditText mEditText2 = (EditText) findViewById(R.id.editText2);


//        EditText に設定された値が数値型かisNumberメソッドでチェックする。
//        チェック結果は isErr 変数に設定して：
//        * 数値型の場合(isErr == false)、指定された四則演算を実施し、その結果を putExtra()の VALUE1にString型でわたす。
//        * 数値型でない場合(isErr == true)、そのエラーメッセージを putExtra()のVALUE1にString型でわたす。

        String str1 = mEditText1.getText().toString();
        if (isNumber(str1)){
            d1 = Double.valueOf(str1);
        } else {
            isErr = true;
            errMsg = "[エラー]数値ではありません：(値1)" + str1;
        }
        String str2 = mEditText2.getText().toString();
        if (isNumber(str2)){
            d2 = Double.valueOf(str2);
        } else {
            if (isErr) {
                errMsg = "[エラー]数値ではありません：(値1)" + str1 + " (値2)" + str2;
            } else {
                isErr = true;
                errMsg ="[エラー]数値ではありません：(値2)" + str2;
            }
        }

        if (isErr) {
            intent.putExtra("VALUE1",errMsg);
        } else {
            if (v.getId() == R.id.buttonTasu) {
                ansd =  d1 + d2;
                ansMsg = String.valueOf(ansd);
            } else if (v.getId() == R.id.buttonHiku) {
                ansd = d1 - d2;
                ansMsg = String.valueOf(ansd);
            } else if (v.getId() == R.id.buttonKake) {
                ansd = d1 * d2;
                ansMsg = String.valueOf(ansd);
            } else if (v.getId() == R.id.buttonWaru) {
                if (d2 == 0) {
                    ansMsg = "[エラー]割り算の分母(値2)が0です。";
                } else {
                    ansd = d1 / d2;
                    ansMsg = String.valueOf(ansd);
                }
            }
            intent.putExtra("VALUE1",ansMsg);
        }
        startActivity(intent);
    }

//    引数が数値(double)か否かをチェックする。
    public boolean isNumber(String val) {
        try {
            Double.parseDouble(val);
            return true;
        } catch (NumberFormatException nfex) {
            return false;
        }
    }
}


