package com.cookandroid.and0726_02_radioflower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("실습1[김민영]");
        rg = findViewById(R.id.rg);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rose :
                        Toast.makeText(getApplicationContext(), "장미", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.panzy :
                        Toast.makeText(getApplicationContext(), "팬지", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.lily :
                        Toast.makeText(getApplicationContext(), "백합", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    public void onRadiobtn(View v) {
        boolean chk = ((RadioButton)v).isChecked();
        if(chk){
            Toast.makeText(getApplicationContext(),
                    ((RadioButton)v).getText().toString(), Toast.LENGTH_SHORT).show();
        }else Toast.makeText(getApplicationContext(),
                ((RadioButton)v).getText().toString(), Toast.LENGTH_SHORT).show();
    }
}
