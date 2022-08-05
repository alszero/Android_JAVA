package com.cookandroid.and0725_01_test;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edt_name;
    Button btn_OK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher_round);
        setTitle("[김민영]위젯 속성 연습");
        edt_name = findViewById(R.id.edt_name);
        btn_OK = findViewById(R.id.btn_OK);
        btn_OK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = edt_name.getText().toString();
                Toast.makeText(getApplicationContext(), "입력한 이름:"+str, Toast.LENGTH_SHORT).show();
                btn_OK.setBackgroundColor(Color.BLUE);
            }
        });

    }
}