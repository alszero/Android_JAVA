package com.cookandroid.and0801_02_ativitytwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    Button secondExit;
    TextView txtContent2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        setTitle("[김민영]두번째화면");
        setContentView(R.layout.activity_second);
        txtContent2 = findViewById(R.id.txtContent2);
        secondExit = findViewById(R.id.secondExit);
        Intent in = getIntent();
        String str = in.getStringExtra("Content");
        txtContent2.setText("넘겨받은 내용 :"+str);
        secondExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); //닫는거(종료)
            }
        });
    }
}