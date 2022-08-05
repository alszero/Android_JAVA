package com.cookandroid.and0726_02_radioidol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("ComTest");

        rg = findViewById(R.id.rg);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                switch (rg.getCheckedRadioButtonId()){
                    case R.id.nctdream: Toast.makeText(getApplicationContext(), "NCTDREAM을 선택하였습니다.", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nct127: Toast.makeText(getApplicationContext(), "NCT127을 선택하였습니다.", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.wayv: Toast.makeText(getApplicationContext(), "WayV을 선택하였습니다.", Toast.LENGTH_SHORT).show();
                        break;

                }
            }
        });
    }

}
