package com.cookandroid.and0725_04_evenpoint;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edt_num1;
    EditText edt_num2;
    Button btn_sum;
    Button btn_point;
    TextView txt_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_num1 = findViewById(R.id.edt_num1);
        edt_num2 = findViewById(R.id.edt_num2);
        btn_sum = findViewById(R.id.btn_sum);
        btn_point = findViewById(R.id.btn_point);
        txt_result = findViewById(R.id.txt_result);

        btn_sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n1 = Integer.parseInt(edt_num1.getText().toString());
                int n2 = Integer.parseInt(edt_num2.getText().toString());
                int sum = 0;
                for(int i= n1; i<n2; i++){
                    if(i%2==0){
                        sum+=i;
                    }
                }
                txt_result.setText("계산결과: "+n1+"와"+n2+"까지의 짝수의 합:"+sum);
            }
        });
        btn_point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int p1 = Integer.parseInt(edt_num1.getText().toString());
                int p2 = Integer.parseInt(edt_num2.getText().toString());
                int result = p2-(p2%100);

                txt_result.setText("가용포인트:"+result);
            }
        });
    }
}