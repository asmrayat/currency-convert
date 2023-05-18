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

       // settingActivity.loadSettings();

        FromText.setText(settingActivity.FromCurency);
        ToText.setText(settingActivity.ToCurency);


        Convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (TextUtils.isEmpty(Amount.getText().toString())) {
                    Toast.makeText(MainActivity.this, "You did not enter any amount", Toast.LENGTH_SHORT).show();

                }
                else if (Amount.getText().toString().length()>0){
                    amountR = Double.parseDouble(Amount.getText().toString());
                    double  conversionResult = amountR * 137.60221;
                    DecimalFormat decimalFormat = new DecimalFormat("#0.00");
                    String formattedResult = decimalFormat.format(conversionResult);
                    Result.setText(String.valueOf(formattedResult));
                }
                else {




                    amountResult = Double.parseDouble(Amount.getText().toString());
                    System.out.println("getTK : " + amountResult);



                    if (settingActivity.FromCurency.equals("USD") && settingActivity.ToCurency.equals("JPY")) {
                        double conversionResult = amountResult * 137.60221;
                        Result.setText(String.valueOf(conversionResult));
                        System.out.println("getDollar : " + conversionResult);
                    } else if (settingActivity.FromCurency.equals("USD") && settingActivity.ToCurency.equals("CAD")) {
                        double conversionResult = amountResult * 1.3468278;
                        Result.setText(String.valueOf(conversionResult));
                    } else if (settingActivity.FromCurency.equals("USD") && settingActivity.ToCurency.equals("EUR")) {
                        double conversionResult = amountResult * 0.92264332;
                        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
                        String formattedResult = decimalFormat.format(conversionResult);
                        Result.setText(String.valueOf(formattedResult));
                    } else if (settingActivity.FromCurency.equals("CAD") && settingActivity.ToCurency.equals("USD")) {
                        double conversionResult = amountResult * 0.7425036;
                        Result.setText(String.valueOf(conversionResult));
                    } else if (settingActivity.FromCurency.equals("CAD") && settingActivity.ToCurency.equals("JPY")) {
                        double conversionResult = amountResult * 102.17816;
                        Result.setText(String.valueOf(conversionResult));
                    } else if (settingActivity.FromCurency.equals("CAD") && settingActivity.ToCurency.equals("EUR")) {
                        double conversionResult = amountResult * 0.68510676;
                        Result.setText(String.valueOf(conversionResult));
                    } else if (settingActivity.FromCurency.equals("JPY") && settingActivity.ToCurency.equals("USD")) {
                        double conversionResult = amountResult * 0.0072666256;
                        Result.setText(String.valueOf(conversionResult));
                    } else if (settingActivity.FromCurency.equals("JPY") && settingActivity.ToCurency.equals("CAD")) {
                        double conversionResult = amountResult * 0.0097864086;
                        Result.setText(String.valueOf(conversionResult));
                    } else if (settingActivity.FromCurency.equals("JPY") && settingActivity.ToCurency.equals("EUR")) {
                        double conversionResult = amountResult * 0.0067051046;
                        Result.setText(String.valueOf(conversionResult));
                    } else if (settingActivity.FromCurency.equals("EUR") && settingActivity.ToCurency.equals("USD")) {
                        double conversionResult = amountResult * 1.0837916;
                        Result.setText(String.valueOf(conversionResult));
                    } else if (settingActivity.FromCurency.equals("EUR") && settingActivity.ToCurency.equals("CAD")) {
                        double conversionResult = amountResult * 1.4595774;
                        Result.setText(String.valueOf(conversionResult));
                    } else if (settingActivity.FromCurency.equals("EUR") && settingActivity.ToCurency.equals("JPY")) {
                        double conversionResult = amountResult * 149.15013;
                        Result.setText(String.valueOf(conversionResult));
                    }
                }
            }
        });
    }
}