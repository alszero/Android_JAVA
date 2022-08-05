package com.cookandroid.and0726_06_food;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    CheckBox str;
    RadioGroup rg;
    TextView txt2;
    Button btn_re;
    ImageView img;
    RadioButton btn1, btn2, btn3, btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        str = findViewById(R.id.str);
        rg = findViewById(R.id.rg);
        txt2 = findViewById(R.id.txt2);
        btn_re = findViewById(R.id.btn_re);
        img = findViewById(R.id.img);

        str.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (str.isChecked() == true) {
                    txt2.setVisibility(View.VISIBLE);
                    rg.setVisibility(View.VISIBLE);
                    btn_re.setVisibility(View.VISIBLE);
                    img.setVisibility(View.VISIBLE);
                }else{
                    txt2.setVisibility(View.INVISIBLE);
                    rg.setVisibility(View.INVISIBLE);
                    btn_re.setVisibility(View.INVISIBLE);
                    img.setVisibility(View.INVISIBLE);
                }
            }
        });

        btn_re.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rg.clearCheck();
            }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.btn1: img.setImageResource(R.drawable.mov01); break;

                    case R.id.btn2: img.setImageResource(R.drawable.mov02); break;

                    case R.id.btn3: img.setImageResource(R.drawable.mov03); break;

                    case R.id.btn4: img.setImageResource(R.drawable.mov04); break;
                }
            }
        });
    }
}