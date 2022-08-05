package com.cookandroid.project4_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView txtpet;
    CheckBox chk;
    RadioGroup rg;
    Button btnOK;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("김민영");
        chk = findViewById(R.id.chk);
        txtpet = findViewById(R.id.txtPet);
        rg = findViewById(R.id.rg);
        btnOK = findViewById(R.id.btnOk);
        img = findViewById(R.id.img);
        chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(chk.isChecked()){    //true
                    txtpet.setVisibility(View.VISIBLE);
                    rg.setVisibility(View.VISIBLE);
                    btnOK.setVisibility(View.VISIBLE);
                    img.setVisibility(View.VISIBLE);
                }else{
                    txtpet.setVisibility(View.INVISIBLE);
                    rg.setVisibility(View.INVISIBLE);
                    btnOK.setVisibility(View.INVISIBLE);
                    img.setVisibility(View.INVISIBLE);
                    rg.clearCheck();
                    img.setImageDrawable(null);
                }
            }
        });
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               //종료
                finish();
            }
        });
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rdoDog :
                        img.setImageResource(R.drawable.dog3);
                        break;
                    case R.id.rdoCat :
                        img.setImageResource(R.drawable.cat1);
                        break;
                    case R.id.rdoRabbit :
                        img.setImageResource(R.drawable.rabbit);
                        break;
                }
            }
        });
    }
}