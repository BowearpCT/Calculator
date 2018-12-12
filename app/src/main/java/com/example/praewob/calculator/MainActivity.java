package com.example.praewob.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean dot=false,stop=false;
    float n1=0,n2;
    TextView result;
    char op,nextop;
    boolean multiple=false,first=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = (TextView) findViewById(R.id.txtResult);
        Button bntAC = (Button) findViewById(R.id.bntAC);
        Button bntDEL = (Button) findViewById(R.id.bntDEL);
        Button bntDivide = (Button) findViewById(R.id.bntDivide);
        Button bnt7 = (Button) findViewById(R.id.bnt7);
        Button bnt8 = (Button) findViewById(R.id.bnt8);
        Button bnt9 = (Button) findViewById(R.id.bnt9);
        Button bntMul = (Button) findViewById(R.id.bntMul);
        Button bnt4 = (Button) findViewById(R.id.bnt4);
        Button bnt5 = (Button) findViewById(R.id.bnt5);
        Button bnt6 = (Button) findViewById(R.id.bnt6);
        Button bntMinus = (Button) findViewById(R.id.bntMinus);
        Button bnt1 = (Button) findViewById(R.id.bnt1);
        Button bnt2 = (Button) findViewById(R.id.bnt2);
        Button bnt3 = (Button) findViewById(R.id.bnt3);
        Button bntPlus = (Button) findViewById(R.id.bntPlus);
        Button bnt0 = (Button) findViewById(R.id.bnt0);
        Button bntDot = (Button) findViewById(R.id.bntDot);
        Button bntEqual = (Button) findViewById(R.id.bntEqual);

        bnt0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (result.getText().toString().length()!=0){
                    result.setText(result.getText()+"0");
                }
            }
        });
        bnt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "1");
            }
        });
        bnt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "2");
            }
        });
        bnt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "3");
            }
        });
        bnt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "4");
            }
        });
        bnt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "5");
            }
        });
        bnt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "6");
            }
        });
        bnt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "7");
            }
        });
        bnt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "8");
            }
        });
        bnt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText()+"9");
            }
        });
        bntAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText("");
                dot = false;
                stop=false;
                first = true;
            }
        });
        bntDEL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int len = result.getText().toString().length();
                char d = result.getText().charAt(len-1);
                if (d == '.'){
                    dot = false;
                }
                if (len!=0){
                    result.setText(result.getText().toString().substring(0,len-1));
                }


            }
        });
        bntDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dot == false){
                    result.setText(result.getText()+".");
                    dot = true;
                }
            }
        });
        bntPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (result == null){
                    result.setText(null);
                }
                else{
                    if (first==true){
                        n1 = Float.parseFloat(result.getText().toString());
                        op ='+';
                        first=false;
                        result.setText(null);
                    }
                    else{
                        n2 = Float.parseFloat(result.getText().toString());
                        nextop = '+';
                        calculate();
                    }

                }
            }
        });
        bntMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (result == null){
                    result.setText(null);
                }
                else{
                    if (first==true){
                        n1 = Float.parseFloat(result.getText().toString());
                        op ='-';
                        first=false;
                        result.setText(null);
                    }
                    else{
                        n2 = Float.parseFloat(result.getText().toString());
                        nextop = '-';
                        calculate();
                    }

                }
            }
        });
        bntMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (result == null){
                    result.setText(null);
                }
                else{
                    if (first==true){
                        n1 = Float.parseFloat(result.getText().toString());
                        op ='*';
                        first=false;
                        result.setText(null);
                    }
                    else{
                        n2 = Float.parseFloat(result.getText().toString());
                        nextop = '*';
                        calculate();
                    }

                }
            }
        });
        bntDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (result.getText().toString().length() == 0){
                    result.setText("");
                }
                else{
                    if (first==true){
                        n1 = Float.parseFloat(result.getText().toString());
                        op ='/';
                        first=false;
                        result.setText(null);
                    }
                    else{
                        n2 = Float.parseFloat(result.getText().toString());
                        nextop = '/';
                        calculate();
                    }

                }
            }
        });
        bntEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop=true;
                first=true;
                if (result.getText().toString().length() == 0){
                    result.setText("");
                }
                else {
                    n2 = Float.parseFloat(result.getText().toString());
                    calculate();
                }



            }
        });
    }
    public void calculate () {
        String total=null;
        if (op == '+') {
            n1 += n2;
        } else if (op == '-') {
            n1 -= n2;
        } else if (op == '*') {
            n1 *= n2;
        } else {
            n1 /= n2;
        }
        if (stop==true){
            total= Float.toString(n1);
        }
        op = nextop;
        stop=false;
        result.setText(total);
    }



}
