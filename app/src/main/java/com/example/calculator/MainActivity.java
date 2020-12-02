package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText result;
    double value1, value2;
    boolean multiply, divide, subtract, add, exponent, remainder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result=findViewById(R.id.etResult);
    }

    public void onDigit(View view) {
        switch (view.getId()){
            case R.id.btn_0:
                result.setText(String.format("%s0", result.getText()));
                break;

            case R.id.btn_1:
                result.setText(String.format("%s1", result.getText()));
                break;

            case R.id.btn_2:
                result.setText(String.format("%s2",result.getText()));
                break;

            case R.id.btn_3:
                result.setText(String.format("%s3",result.getText()));
                break;

            case R.id.btn_4:
                result.setText(String.format("%s4",result.getText()));
                break;

            case R.id.btn_5:
                result.setText(String.format("%s5",result.getText()));
                break;

            case R.id.btn_6:
                result.setText(String.format("%s6",result.getText()));
                break;

            case R.id.btn_7:
                result.setText(String.format("%s7",result.getText()));
                break;

            case R.id.btn_8:
                result.setText(String.format("%s8",result.getText()));
                break;

            case R.id.btn_9:
                result.setText(String.format("%s9",result.getText()));
                break;

            case R.id.btn_comma:
                if(!result.getText().toString().contains("."))
                    result.setText(String.format("%s.", result.getText()));
                break;

            case R.id.btn_c:
                result.setText("");
                value1 = 0.0;
                value2 = 0.0;
                break;
        }
    }

    public void onOperator(View view) {
        if (result.length()==0)return;
        try{
            value1 = Double.parseDouble(result.getText().toString());
            result.setText("");
            switch (view.getId()) {
                case R.id.btn_plus: //+
                    add = true;
                    break;

                case R.id.btn_korda: //*
                    multiply=true;
                    break;

                case R.id.btn_minus: //-
                    subtract = true;
                    break;

                case R.id.btn_divid: // /
                    divide=true;
                    break;

                case R.id.btn_prec: //%
                    remainder=true;
                    break;

                case R.id.btn_level: //astendamine
                    exponent=true;
                    break;

                case R.id.btn_plsmin: //plusmin
                    if (result.length()==0)return;
                    try {
                        double resValue =Double.parseDouble(result.getText().toString());
                        if (resValue > 0) result.setText(String.valueOf(resValue * -1));
                        else result.setText(String.valueOf(Math.abs(resValue)));
                    } catch ( NumberFormatException ex) {ex.printStackTrace();}
                    break;

                case R.id.btn_sqr: //ruutjuur
                    if (Double.isNaN(Math.sqrt(value1))){
                        result.setText(getResources().getString(R.string.error));
                    }else {
                        result.setText(String.valueOf(Math.sqrt(value1)));
                    }
            }
        }catch (NumberFormatException ex){ex.printStackTrace();}
    }

    public void onEnter(View view) {
        if (result.length()==0)return;
        try {
            value2=Double.parseDouble(result.getText().toString());
            if (add){
                result.setText(String.valueOf(value1+value2));
                add=false;
            }
            if (subtract){
                result.setText(String.valueOf(value1-value2));
                subtract=false;
            }
            if (multiply){
                result.setText(String.valueOf(value1*value2));
                multiply=false;
            }
            if (divide){
                result.setText(String.valueOf(value1/value2));
                divide=false;
            }
            if (remainder){
                result.setText(String.valueOf(value1%value2));
                remainder=false;
            }
            if (exponent){
                result.setText(String.valueOf(Math.pow(value1,value2)));
                exponent=false;
            }

        }catch (NumberFormatException ex){ ex.printStackTrace();}

    }
}