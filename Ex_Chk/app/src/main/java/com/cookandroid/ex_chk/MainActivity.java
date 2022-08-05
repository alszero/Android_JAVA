package com.cookandroid.ex_chk;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity<chk1> extends AppCompatActivity {
    CheckBox chk1;
    CheckBox chk2;
    CheckBox chk3;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("연습문제4-7");
        chk1 = findViewById(R.id.chk1);
        chk2 = findViewById(R.id.chk2);
        chk3 = findViewById(R.id.chk3);
        btn = findViewById(R.id.btn);

        chk1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
               if(b)btn.setEnabled(true);
               else btn.setEnabled(false);
            }
        });
        chk2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)btn.setVisibility(View.VISIBLE);
                else btn.setVisibility(View.INVISIBLE);
            }
        });
        chk3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)btn.setRotation(45);
                else btn.setRotation(0);
            }
        });
    }
}