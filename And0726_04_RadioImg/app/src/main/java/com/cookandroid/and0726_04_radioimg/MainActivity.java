package com.cookandroid.and0726_04_radioimg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn_show, btn_open;
    RadioGroup rg;
    ImageView img;
    EditText edtxt;
    int imgType=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("좀 그럴듯한 앱");
        btn_show = findViewById(R.id.btn_show);
        btn_open = findViewById(R.id.btn_open);
        edtxt = findViewById(R.id.edtxt);
        rg = findViewById(R.id.rg);
        img = findViewById(R.id.img);

        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), edtxt.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        btn_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent urlOpen = new Intent(Intent.ACTION_VIEW, Uri.parse(edtxt.getText().toString()));
                startActivity(urlOpen);
            }
        });
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.nuga :
                        img.setImageResource(R.drawable.pie);
                        break;

                    case R.id.oreo :
                        img.setImageResource(R.drawable.oreo);
                        break;
                }
            }
        });
    }
}