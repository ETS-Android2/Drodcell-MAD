package com.jovanovic.stefan.sqlitetutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Calc extends AppCompatActivity {
    private EditText etn1;
    private  EditText etn2;
    private TextView tvResult;
    Button button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        etn1 = (EditText) findViewById(R.id.etn1);
        etn2 = (EditText) findViewById(R.id.etn2);
        tvResult = (TextView) findViewById(R.id.tvResult);


    }

    public void btnsum(View view) {
        int n1 = Integer.parseInt(etn1.getText().toString());
        int n2 = Integer.parseInt(etn2.getText().toString());
        if(n1==1){


            int sum = ((n1+n2)*100);

            tvResult.setText(String.valueOf(sum));
        }

        else if (n1==2){
            int sum=(n1+n2+n1);
            tvResult.setText(String.valueOf(sum));
        }

        else if(n1==3){


            int sum = ((n1 +n2)*75);

            tvResult.setText(String.valueOf(sum));
        }

        else if (n1==4){
            int sum=(n1+n2)*50;
            tvResult.setText(String.valueOf(sum));
        }

        else if (n1==5){
            int sum=(n1+n2)*25;
            tvResult.setText(String.valueOf(sum));
        }



        else if (n1==6){
            int sum=(n1+n2)*15;
            tvResult.setText(String.valueOf(sum));
        }





        else if (n1==7){
            int sum=(n1+n2)*10;
            tvResult.setText(String.valueOf(sum));
        }




        else if (n1==8){
            int sum=(n1+n2)*10;
            tvResult.setText(String.valueOf(sum));
        }
        else if (n1==9){
            int sum=(n1+n2)*5;
            tvResult.setText(String.valueOf(sum));
        }


        else{

            int sum=(n1*n2);
            tvResult.setText(String.valueOf(sum));
        }

    }

























    public void btnsub(View view) {
        int n1 = Integer.parseInt(etn1.getText().toString());
        int n2 = Integer.parseInt(etn2.getText().toString());
        int sum = (n1 *n2)*10;
        tvResult.setText(String.valueOf(sum));















    }

    public void btnmulti(View view) {
        int n1 = Integer.parseInt(etn1.getText().toString());
        int n2 = Integer.parseInt(etn2.getText().toString());
        int sum = n1- n2;
        tvResult.setText(String.valueOf(sum));
    }

    public void btndiv(View view) {
        int n1 = Integer.parseInt(etn1.getText().toString());
        int n2 = Integer.parseInt(etn2.getText().toString());
        int sum = n1 / n2;
        tvResult.setText(String.valueOf(sum));
    }
}
