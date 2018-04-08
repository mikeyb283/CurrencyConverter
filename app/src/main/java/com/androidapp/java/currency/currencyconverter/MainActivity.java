package com.androidapp.java.currency.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    double conversionRate = 0.71;
    double amountEntered = 0.0;
    double convertedCurrency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher_foreground);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        final EditText toConvert = (EditText) findViewById(R.id.user_input);
        final RadioButton dollarsTopounds = (RadioButton) findViewById(R.id.dollarsToPounds);
        final RadioButton poundsTodollars = (RadioButton) findViewById(R.id.poundsToDollars);
        final TextView textResult = (TextView)findViewById(R.id.textResult);
        Button convert = (Button) findViewById(R.id.convert);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                amountEntered = Double.parseDouble(toConvert.getText().toString());
                DecimalFormat currency = new DecimalFormat("###,###.##");
                if (dollarsTopounds.isChecked()){
                    if (amountEntered <= 10000) {
                        convertedCurrency = amountEntered * conversionRate;
                        textResult.setText(String.format("$" + currency.format(convertedCurrency)));
                    }else {
                        Toast.makeText(MainActivity.this, "Amount must be less than $10,000", Toast.LENGTH_LONG).show();
                    }
                }
                if (poundsTodollars.isChecked()){
                    if (amountEntered <= 10000) {
                        convertedCurrency = amountEntered / conversionRate;
                        textResult.setText(String.format("£" + currency.format(convertedCurrency)));
                    }else {
                        Toast.makeText(MainActivity.this, "Amount must be less than £10,000", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

    }
}