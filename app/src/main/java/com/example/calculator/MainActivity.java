package com.example.calculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Integer first, second, sum;
    private String operation;
    private Boolean isOperationClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text_view);

    }

    public void onNumberClick(View view) {
        String text = ((MaterialButton) view).getText().toString();
        if (text.equals("AC")) {
            textView.setText("0");
            first = 0;
            second = 0;
        } else if (textView.getText().toString().equals("0") || isOperationClick) {
            textView.setText(text);
        } else {
            textView.append(text);
        }
        isOperationClick = false;
    }

    public void onOperationClick(View view) {
        int viewId = view.getId();
        if (viewId == R.id.btn_plus || viewId == R.id.btn_minus ||
                viewId == R.id.btn_multiplication || viewId == R.id.btn_division) {
            first = Integer.valueOf(textView.getText().toString());
            isOperationClick = true;
            operation = ((Button) view).getText().toString();
        } else if (viewId == R.id.btn_equal) {
            second = Integer.valueOf(textView.getText().toString());
            findResult();
        }
    }

        private void findResult () {
            switch (operation) {
                case "+":
                    sum = first + second;
                    break;
                case "-":
                    sum = first - second;
                    break;
                case "x":
                    sum = first * second;
                    break;
                case "/":
                    if (second != 0) {
                        sum = first / second;
                    } else {
                        textView.setText("Error: Division by Zero");
                        return;
                    }
                    break;
            }
            textView.setText(sum.toString());
        }

    }