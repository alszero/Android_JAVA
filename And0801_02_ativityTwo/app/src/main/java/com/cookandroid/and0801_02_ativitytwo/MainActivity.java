package com.cookandroid.and0801_02_ativitytwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnew;
    RadioGroup rg;
    RadioButton Secondact, Thirdact;
    EditText edtContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtContent = findViewById(R.id.edtContent);
        btnew = findViewById(R.id.btnew);
        Secondact = findViewById(R.id.Secondact);
        Thirdact = findViewById(R.id.Thirdact);
        rg = findViewById(R.id.rg);
        btnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = edtContent.getText().toString();
                switch (rg.getCheckedRadioButtonId()){
                    case R.id.Secondact :
                        Intent in = new Intent(getApplicationContext(), SecondActivity.class);
                        in.putExtra("Content", str);
                        startActivity(in); //SecondActivity화면에 열기
                        break;

                    case R.id.Thirdact :
                        Intent in2 = new Intent(getApplicationContext(), ThirdActivity.class);
                        in2.putExtra("Content", str);
                        startActivity(in2); //SecondActivity화면에 열기
                        break;
                }
            }
        });
    }
}