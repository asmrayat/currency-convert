package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

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
        // Load saved settings
        //loadSettings();

        // Set selected RadioButton based on loaded data
        setSelectedRadioButton(FromGroup, FromCurency);
        setSelectedRadioButton(ToGroup, ToCurency);
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
                saveSettings();
                startActivity(new Intent(settingActivity.this, MainActivity.class));
            }
        });
    }

    private void saveSettings() {
        SharedPreferences preferences = getSharedPreferences("Settings", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("FromCurrency", FromCurency);
        editor.putString("ToCurrency", ToCurency);
        editor.apply();
        Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show();
    }

    private SharedPreferences getSettingsSharedPreferences(Context context) {
        return context.getSharedPreferences("Settings", MODE_PRIVATE);
    }

    public void loadSettings(Context context) {
        SharedPreferences preferences = getSettingsSharedPreferences(context);
        FromCurency = preferences.getString("FromCurrency", "");
        ToCurency = preferences.getString("ToCurrency", "");
    }

    private void setSelectedRadioButton(RadioGroup radioGroup, String currency) {
        int count = radioGroup.getChildCount();
        for (int i = 0; i < count; i++) {
            View view = radioGroup.getChildAt(i);
            if (view instanceof RadioButton) {
                RadioButton radioButton = (RadioButton) view;
                if (radioButton.getText().toString().equals(currency)) {
                    radioButton.setChecked(true);
                    break;
                }
            }
        }
    }
}