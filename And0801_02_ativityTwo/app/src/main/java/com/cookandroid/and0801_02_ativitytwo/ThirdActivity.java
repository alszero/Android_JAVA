package com.cookandroid.and0801_02_ativitytwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {
    Button thirdExit;
    TextView txtContent3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        setTitle("[김민영]세번째 화면");
        setContentView(R.layout.activity_third);
        txtContent3 = findViewById(R.id.txtContent3);
        thirdExit = findViewById(R.id.thirdExit);
        /////////////////////////////////////////////
        Intent in = getIntent();
        String str = in.getStringExtra("Content");
        ///////////////////////////////////////////////////////////////

        txtContent3.setText("넘겨받은 내용 :"+str);
        thirdExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); //닫는거(종료)
            }
        });
    }
}