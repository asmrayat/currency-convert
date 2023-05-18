package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.badge.BadgeUtils;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    ImageView setting ;
    Button Convert;
    TextView FromText, ToText,Result;
    EditText Amount;
    double  amountResult,amountR;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setting = findViewById(R.id.setting);
        Convert = findViewById(R.id.convertBtn);
        FromText = findViewById(R.id.textFrom);
        ToText = findViewById(R.id.textSpacerNoTitle);
        Result = findViewById(R.id.result);
        Amount = findViewById(R.id.ammount);



        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, settingActivity.class));

            }
        });

        settingActivity settingActivityInstance = new settingActivity();
        settingActivityInstance.loadSettings(MainActivity.this);


        if (settingActivity.FromCurency.equals("USD") && settingActivity.ToCurency.equals("JPY")) {
            FromText.setText("US Dollars");
            ToText.setText("Japanese Yen");
        } else if (settingActivity.FromCurency.equals("USD") && settingActivity.ToCurency.equals("CAD")) {
            double conversionResult = amountResult * 1.3468278;
            FromText.setText("US Dollars");
            ToText.setText("Canadian Dollars");

        } else if (settingActivity.FromCurency.equals("USD") && settingActivity.ToCurency.equals("EUR")) {
            double conversionResult = amountResult * 0.92264332;
            FromText.setText("US Dollars");
            ToText.setText("Euros");
        } else if (settingActivity.FromCurency.equals("CAD") && settingActivity.ToCurency.equals("USD")) {

            FromText.setText("Canadian Dollars");
            ToText.setText("US Dollars");

        } else if (settingActivity.FromCurency.equals("CAD") && settingActivity.ToCurency.equals("JPY")) {
            FromText.setText("Canadian Dollars");
            ToText.setText("Japanese Yen");

        } else if (settingActivity.FromCurency.equals("CAD") && settingActivity.ToCurency.equals("EUR")) {
            FromText.setText("Canadian Dollars");
            ToText.setText("Euros");

        } else if (settingActivity.FromCurency.equals("JPY") && settingActivity.ToCurency.equals("USD")) {
            FromText.setText("Japanese Yen");
            ToText.setText("US Dollars");

        } else if (settingActivity.FromCurency.equals("JPY") && settingActivity.ToCurency.equals("CAD")) {
            FromText.setText("Japanese Yen");
            ToText.setText("Canadian Dollars");

        } else if (settingActivity.FromCurency.equals("JPY") && settingActivity.ToCurency.equals("EUR")) {
            FromText.setText("Japanese Yen");
            ToText.setText("Euros");

        } else if (settingActivity.FromCurency.equals("EUR") && settingActivity.ToCurency.equals("USD")) {

            FromText.setText("Euros");
            ToText.setText("US Dollars");

        } else if (settingActivity.FromCurency.equals("EUR") && settingActivity.ToCurency.equals("CAD")) {
            FromText.setText("Euros");
            ToText.setText("Canadian Dollars");


        } else if (settingActivity.FromCurency.equals("EUR") && settingActivity.ToCurency.equals("JPY")) {
            FromText.setText("Euros");
            ToText.setText("Japanese Yen");
        }


        Convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    if(TextUtils.isEmpty(Amount.getText().toString())){
                        Toast.makeText(MainActivity.this, "Enter Amount", Toast.LENGTH_SHORT).show();
                    }else {
                        amountResult = Double.parseDouble(Amount.getText().toString());

                        if (settingActivity.FromCurency.equals("USD") && settingActivity.ToCurency.equals("JPY")) {
                            double conversionResult = amountResult * 137.60221;
                            DecimalFormat decimalFormat = new DecimalFormat("#0.00");
                            String formattedResult = decimalFormat.format(conversionResult);
                            Result.setText(String.valueOf(formattedResult) + " Japanese Yen");
                        } else if (settingActivity.FromCurency.equals("USD") && settingActivity.ToCurency.equals("CAD")) {
                            double conversionResult = amountResult * 1.3468278;
                            DecimalFormat decimalFormat = new DecimalFormat("#0.00");
                            String formattedResult = decimalFormat.format(conversionResult);
                            Result.setText(String.valueOf(formattedResult) + " Canadian Dollars");

                        } else if (settingActivity.FromCurency.equals("USD") && settingActivity.ToCurency.equals("EUR")) {
                            double conversionResult = amountResult * 0.92264332;
                            DecimalFormat decimalFormat = new DecimalFormat("#0.00");
                            String formattedResult = decimalFormat.format(conversionResult);
                            Result.setText(String.valueOf(formattedResult) + " Euros");
                            System.out.println("checkOut3 : " + conversionResult);

                        } else if (settingActivity.FromCurency.equals("CAD") && settingActivity.ToCurency.equals("USD")) {
                            double conversionResult = amountResult * 0.7425036;
                            DecimalFormat decimalFormat = new DecimalFormat("#0.00");
                            String formattedResult = decimalFormat.format(conversionResult);
                            Result.setText(String.valueOf(formattedResult) + " US Dollars");
                            System.out.println("checkOut4 : " + conversionResult);


                        } else if (settingActivity.FromCurency.equals("CAD") && settingActivity.ToCurency.equals("JPY")) {
                            double conversionResult = amountResult * 102.17816;
                            DecimalFormat decimalFormat = new DecimalFormat("#0.00");
                            String formattedResult = decimalFormat.format(conversionResult);
                            Result.setText(String.valueOf(formattedResult) + " Japanese Yen");
                            System.out.println("checkOut5 : " + conversionResult);

                        } else if (settingActivity.FromCurency.equals("CAD") && settingActivity.ToCurency.equals("EUR")) {
                            double conversionResult = amountResult * 0.68510676;
                            DecimalFormat decimalFormat = new DecimalFormat("#0.00");
                            String formattedResult = decimalFormat.format(conversionResult);
                            Result.setText(String.valueOf(formattedResult) + " Euros");
                            System.out.println("checkOut6 : " + conversionResult);

                        } else if (settingActivity.FromCurency.equals("JPY") && settingActivity.ToCurency.equals("USD")) {
                            double conversionResult = amountResult * 0.0072666256;
                            DecimalFormat decimalFormat = new DecimalFormat("#0.00");
                            String formattedResult = decimalFormat.format(conversionResult);
                            Result.setText(String.valueOf(formattedResult) + " US Dollars");
                            System.out.println("checkOut7 : " + conversionResult);

                        } else if (settingActivity.FromCurency.equals("JPY") && settingActivity.ToCurency.equals("CAD")) {
                            double conversionResult = amountResult * 0.0097864086;
                            DecimalFormat decimalFormat = new DecimalFormat("#0.00");
                            String formattedResult = decimalFormat.format(conversionResult);
                            Result.setText(String.valueOf(formattedResult) + " Canadian Dollars");
                            System.out.println("checkOut8 : " + conversionResult);

                        } else if (settingActivity.FromCurency.equals("JPY") && settingActivity.ToCurency.equals("EUR")) {
                            double conversionResult = amountResult * 0.0067051046;
                            DecimalFormat decimalFormat = new DecimalFormat("#0.00");
                            String formattedResult = decimalFormat.format(conversionResult);
                            Result.setText(String.valueOf(formattedResult) + " Euros");
                            System.out.println("checkOut9 : " + conversionResult);

                        } else if (settingActivity.FromCurency.equals("EUR") && settingActivity.ToCurency.equals("USD")) {
                            double conversionResult = amountResult * 1.0837916;
                            DecimalFormat decimalFormat = new DecimalFormat("#0.00");
                            String formattedResult = decimalFormat.format(conversionResult);
                            Result.setText(String.valueOf(formattedResult) + " US Dollars");
                            System.out.println("checkOut10 : " + conversionResult);

                        } else if (settingActivity.FromCurency.equals("EUR") && settingActivity.ToCurency.equals("CAD")) {
                            double conversionResult = amountResult * 1.4595774;
                            DecimalFormat decimalFormat = new DecimalFormat("#0.00");
                            String formattedResult = decimalFormat.format(conversionResult);
                            Result.setText(String.valueOf(formattedResult) + " Canadian Dollars");

                        } else if (settingActivity.FromCurency.equals("EUR") && settingActivity.ToCurency.equals("JPY")) {
                            double conversionResult = amountResult * 149.15013;
                            DecimalFormat decimalFormat = new DecimalFormat("#0.00");
                            String formattedResult = decimalFormat.format(conversionResult);
                            Result.setText(String.valueOf(formattedResult) + " Japanese Yen");
                        }
                    }
            }
        });
    }
}