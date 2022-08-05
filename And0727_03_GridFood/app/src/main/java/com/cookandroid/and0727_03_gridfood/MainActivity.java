package com.cookandroid.and0727_03_gridfood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView imageview1;
    RadioGroup rg;
    RadioButton sea, tomato, white;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg = findViewById(R.id.rg);
        btn = findViewById(R.id.btn);
        sea = findViewById(R.id.sea);
        tomato = findViewById(R.id.tomato);
        white = findViewById(R.id.white);
        imageview1 = findViewById(R.id.imageview1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (rg.getCheckedRadioButtonId()){
                    case R.id.sea:
                        Toast.makeText(getApplicationContext(), "해물 파스타 선택", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.tomato:
                        Toast.makeText(getApplicationContext(), "토마토 파스타 선택", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.white:
                        Toast.makeText(getApplicationContext(), "까르보나라 선택", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.sea:imageview1.setImageResource(R.drawable.fox);
                    break;
                    case R.id.tomato:imageview1.setImageResource(R.drawable.fox2);
                        break;
                    case R.id.white:imageview1.setImageResource(R.drawable.dog3);
                        break;
                }
            }
        });
    }
}