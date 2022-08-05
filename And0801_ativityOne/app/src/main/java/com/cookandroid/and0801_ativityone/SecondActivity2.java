package com.cookandroid.and0801_ativityone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity2 extends AppCompatActivity {
    Button btnSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("[김민영]두번째화면");
        setContentView(R.layout.activity_second2);
        btnSecond = findViewById(R.id.btnSecond);
        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); //닫는거(종료)
            }
        });
    }
}