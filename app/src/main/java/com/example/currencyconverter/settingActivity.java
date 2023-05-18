package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.security.PublicKey;

public class settingActivity extends AppCompatActivity {
    public RadioGroup FromGroup,ToGroup;
   public static String FromCurency, ToCurency;
   Button CurencyConfirmBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        FromGroup = findViewById(R.id.fromGroup);
        ToGroup = findViewById(R.id.ToGroup);
        CurencyConfirmBtn = findViewById(R.id.curencyConfirmBtn);
        FromGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // Get the selected Radio Button
                RadioButton radioButton = group.findViewById(checkedId);

                // on below line we are setting text
                // for our status text view.
              //  statusTV.setText(radioButton.getText());
                FromCurency = radioButton.getText().toString();
                System.out.println("ChekButton: "+FromCurency);

            }
        });

        ToGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // Get the selected Radio Button
                RadioButton radioButton1 = group.findViewById(checkedId);

                // on below line we are setting text
                // for our status text view.
                //  statusTV.setText(radioButton.getText());
                ToCurency = radioButton1.getText().toString();
                System.out.println("ChekButton: "+ToCurency);
            }
        });

        CurencyConfirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(settingActivity.this, MainActivity.class));
            }
        });
    }
}