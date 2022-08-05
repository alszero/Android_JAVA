package com.cookandroid.and0725_05_picture;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button btn_ch, btn_hd;
    ImageView img;
    int imgType=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_ch = findViewById(R.id.btn_ch);
        btn_hd = findViewById(R.id.btn_hd);
        img = findViewById(R.id.img);

        btn_hd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(img.getVisibility()==View.VISIBLE){
                    img.setVisibility(View.INVISIBLE);
                }
                else{
                    img.setVisibility(View.VISIBLE);
                }
            }
        });
        btn_ch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(imgType==1){
                    img.setImageResource(R.drawable.dog); imgType=2;
                }else{
                    img.setImageResource(R.drawable.cat2); imgType=1;
                }
            }
        });
    }
}