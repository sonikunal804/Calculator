package com.example.sonik.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {


    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btn00;
    Button btnDot,btnMul,btnDiv,btnPlus,btnMinus,btnAC,btnDel,btnMod,btnEqual;

    TextView mResult,mExpression;
    Toolbar calcToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {




        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Button Id's
        btn0 = findViewById(R.id.btn0);
        btn00 = findViewById(R.id.btn00);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnDel = findViewById(R.id.btnDel);
        btnDot = findViewById(R.id.btnDot);

        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnDiv = findViewById(R.id.btnDiv);
        btnMul = findViewById(R.id.btnMul);
        btnMod = findViewById(R.id.btnMod);
        btnEqual = findViewById(R.id.btnEqual);

        btnAC = findViewById(R.id.btnAC);

        // Screen Id's
        mResult = findViewById(R.id.mResult);
        mExpression = findViewById(R.id.mExpression);

        //Toolbar Id
        calcToolbar = findViewById(R.id.calcToolbar);

        calcToolbar.setTitle("Calculator");
        calcToolbar.inflateMenu(R.menu.menu_main);

        clearScreen();

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeExpression("0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeExpression("1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeExpression("2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeExpression("3");

            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeExpression("4");

            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeExpression("5");

            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeExpression("6");

            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeExpression("7");

            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeExpression("8");

            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeExpression("9");

            }
        });
        btn00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeExpression("00");
            }
        });
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeExpression(".");

            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeExpression("+");

            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeExpression("-");

            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeExpression("*");

            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeExpression("/");

            }
        });
        btnMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeExpression("%");

            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showResult();
            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String exp = mExpression.getText().toString();
                if(exp.length() != 0) {
                    deleteOneFromExpression();
                    if(exp.length() <= 2){
                        mResult.setText("0");
                    }
                }
            }
        });
        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearScreen();
            }
        });
    }


    void writeExpression(String value){
        String tempExpression = mExpression.getText().toString();
        tempExpression=tempExpression+value;
        mExpression.setText(tempExpression);
        showResult();
    }
    void deleteOneFromExpression(){
        String tempExpression = mExpression.getText().toString();
        tempExpression =  tempExpression.substring(0,tempExpression.length()-1);
        mExpression.setText(tempExpression);
        showResult();
    }
    void showResult(){
        String tempExpression = mExpression.getText().toString();
        tempExpression = tempExpression.replace("%","#");
        Expression e = new Expression(tempExpression);

        double decResult;
        decResult = e.calculate();
        int intResult;
        intResult = (int) e.calculate();
        if(intResult == decResult){
            String tempResult = String.valueOf(intResult);
            if(0 !=(tempResult.compareTo("NaN"))) {
                mResult.setText(tempResult);
            } else
                mResult.setText(" ");
        }
        else {
            String tempResult = String.valueOf(decResult);
            if(0 !=(tempResult.compareTo("NaN"))) {
                mResult.setText(tempResult);
            }
            else{
                mResult.setText(" ");
            }
        }
    }
    void clearScreen(){
        mExpression.setText(" ");
        mResult.setText("0");
    }
}
