package com.dylanreinsma.numbershapes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    class Number {
        int number;

        public boolean isSquare() {
            double squareRoot = Math.sqrt(number);
            if (squareRoot == Math.floor(squareRoot)) {
                return true;
            } else {
                return false;
            }
        }

        public boolean isTriangular() {
            int x = 1;
            int triangularNumber = 1;
            while (triangularNumber < number) {
                x++;
                triangularNumber = triangularNumber + x;
            }

            if (triangularNumber == number) {
                return true;
            } else {
                return false;
            }
        }
    }

    public void testNumber(View view) {
        EditText editText = findViewById(R.id.editText);
        if (editText.getText().toString().isEmpty()) {
            message = "Please enter a number";
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        } else {
            Number myNumber = new Number();
            myNumber.number = Integer.parseInt(editText.getText().toString());
            if (myNumber.isSquare() && myNumber.isTriangular()) {
                message = "Number is both Square and Triangular!";
            } else if (myNumber.isSquare()) {
                message = "Number is square!";
            } else if (myNumber.isTriangular()) {
                message = "Number is triangular!";
            } else {
                message = "Number isn't square or triangular";
            }
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        }
    }
}

