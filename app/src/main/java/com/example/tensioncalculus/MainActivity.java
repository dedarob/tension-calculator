package com.example.tensioncalculus;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Locale usLocale = Locale.US;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText massInput;
        EditText angleInput;

        Button calcButton;

        massInput = findViewById(R.id.massInput);
        angleInput = findViewById(R.id.angleInput);
        calcButton = (Button) findViewById(R.id.calc);
        calcButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    Locale usLocale = Locale.US;
                    double angle, mass;

                    angle = Float.parseFloat(angleInput.getText().toString());
                    mass = Float.parseFloat(massInput.getText().toString());

                    double weight = mass * 9.81;
                    double sin = Math.sin(Math.toRadians(angle));

                    double cos = Math.cos(Math.toRadians(angle));
                    double tb = weight / sin;
                    double td = cos * tb;


                    TextView tdOutput = findViewById(R.id.textView8);
                    String tdString = String.format("%.4f", td);
                    tdOutput.setText(tdString);

                    TextView tbOutput = findViewById(R.id.textView9);
                    String tbString = String.format("%.4f", tb);
                    tbOutput.setText(tbString);
                } catch (NumberFormatException e) {
                }
            }


        });
    }
}