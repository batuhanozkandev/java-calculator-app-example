package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView result;

    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button button0;

    Button buttonSum;
    Button buttonMinus;
    Button buttonMulti;
    Button buttonDivide;
    Button buttonEqual;

    String value = "";
    String value2 = "";
    String specialChar = "";
    boolean isPressedSpecialButton = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.result);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        button0 = findViewById(R.id.button0);

        buttonSum = findViewById(R.id.buttonSum);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonMulti = findViewById(R.id.buttonMulti);
        buttonDivide = findViewById(R.id.buttonDivide);
        buttonEqual = findViewById(R.id.buttonEqual);

        myButton(button1, "1");
        myButton(button2, "2");
        myButton(button3, "3");
        myButton(button4, "4");
        myButton(button5, "5");
        myButton(button6, "6");
        myButton(button7, "7");
        myButton(button8, "8");
        myButton(button9, "9");
        myButton(button0, "0");

        buttonSum.setOnClickListener(
                view -> {
                    isPressedSpecialButton = true;
                    specialChar = "+";
                    result.setText(value + specialChar);
                }
        );
        buttonMinus.setOnClickListener(
                view -> {
                    isPressedSpecialButton = true;
                    specialChar = "-";
                    result.setText(value + specialChar);
                }
        );
        buttonMulti.setOnClickListener(
                view -> {
                    isPressedSpecialButton = true;
                    specialChar = "x";
                    result.setText(value + specialChar);
                }
        );
        buttonDivide.setOnClickListener(
                view -> {
                    isPressedSpecialButton = true;
                    specialChar = "/";
                    result.setText(value + specialChar);
                }
        );

        buttonEqual.setOnClickListener(
                view -> {
                    switch (specialChar) {
                        case "+":
                            result.setText(String.valueOf(Integer.parseInt(value) + Integer.parseInt(value2)));
                            break;
                        case "-":
                            result.setText(String.valueOf(Integer.parseInt(value) - Integer.parseInt(value2)));
                            break;
                        case "x":
                            result.setText(String.valueOf(Integer.parseInt(value) * Integer.parseInt(value2)));
                            break;
                        case "/":
                            result.setText(String.valueOf(Integer.parseInt(value) / Integer.parseInt(value2)));
                            break;
                    }
                }
        );


    }

    public void myButton(View button, String buttonNumber) {
        button.setOnClickListener(
                view -> {
                    if (!isPressedSpecialButton) {
                        value = value + buttonNumber;
                        result.setText(value);
                    } else {
                        value2 = value2 + buttonNumber;
                        result.setText(value + specialChar + value2);
                    }
                }
        );
    }
}