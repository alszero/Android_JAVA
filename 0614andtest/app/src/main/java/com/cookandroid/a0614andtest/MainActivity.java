package com.cookandroid.a0614andtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup group;
    RadioButton rbtn1, rbtn2;
    Button check, cancle, btn;
    String grade;
    CheckBox chk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        group = findViewById(R.id.group);
        rbtn1 = findViewById(R.id.rbtn1);
        rbtn2 = findViewById(R.id.rbtn2);
        check = findViewById(R.id.check);
        cancle = findViewById(R.id.cancle);
        chk = findViewById(R.id.chk);
        btn = findViewById(R.id.btn);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i==0)grade="2학년";
                else grade="3학년";
                if(radioGroup.getCheckedRadioButtonId()==R.id.rbtn1)
                    grade = rbtn1.getText().toString();
                else grade = rbtn2.getText().toString();
            }
        });
        chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)btn.setEnabled(true);
                else btn.setEnabled(false);
            }
        });
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "선택한 학년:"+grade,
                        Toast.LENGTH_SHORT).show();
            }
        });
        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                group.clearCheck();
                Toast.makeText(getApplicationContext(), "선택 취소함",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}