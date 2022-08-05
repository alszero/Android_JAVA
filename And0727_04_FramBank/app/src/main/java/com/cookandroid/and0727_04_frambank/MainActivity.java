package com.cookandroid.and0727_04_frambank;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2, btn3, Inputbtn, Outputbtn;
    LinearLayout bankn, putm, outm;
    EditText edtInput, edtOutput;
    TextView rebalance;
    int total = 10000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        bankn = findViewById(R.id.bankn);
        putm = findViewById(R.id.putm);
        outm = findViewById(R.id.outm);
        edtInput = findViewById(R.id.edtInput);
        edtOutput = findViewById(R.id.edtOutput);
        rebalance = findViewById(R.id.rebalance);
        Inputbtn = findViewById(R.id.Inputbtn);
        Outputbtn = findViewById(R.id.Outputbtn);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn1.setBackgroundColor(Color.parseColor("#F4F47F"));
                btn2.setBackgroundColor(Color.parseColor("#E1DDDD"));
                btn3.setBackgroundColor(Color.parseColor("#E1DDDD"));
                bankn.setVisibility(View.VISIBLE);
                putm.setVisibility(View.INVISIBLE);
                outm.setVisibility(View.INVISIBLE);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn1.setBackgroundColor(Color.parseColor("#E1DDDD"));
                btn2.setBackgroundColor(Color.parseColor("#F4F47F"));
                btn3.setBackgroundColor(Color.parseColor("#E1DDDD"));
                bankn.setVisibility(View.INVISIBLE);
                putm.setVisibility(View.VISIBLE);
                outm.setVisibility(View.INVISIBLE);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn1.setBackgroundColor(Color.parseColor("#E1DDDD"));
                btn2.setBackgroundColor(Color.parseColor("#E1DDDD"));
                btn3.setBackgroundColor(Color.parseColor("#F4F47F"));
                bankn.setVisibility(View.INVISIBLE);
                putm.setVisibility(View.INVISIBLE);
                outm.setVisibility(View.VISIBLE);
            }
        });
        Inputbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //입금
                int n = Integer.parseInt(edtInput.getText().toString());
                total += n; rebalance.setText("잔액: "+total+"원");
                Toast.makeText(getApplicationContext(),
                        n+"원 입금\n잔액은 "+total+"입니다.", Toast.LENGTH_SHORT).show();
                edtInput.setText("0");
            }
        });
        Outputbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n = Integer.parseInt(edtOutput.getText().toString());
                total -= n; rebalance.setText("잔액: "+total+"원");
                Toast.makeText(getApplicationContext(),
                        n+"원 출금\n잔액은 "+total+"입니다.", Toast.LENGTH_SHORT).show();
                edtOutput.setText("0");
            }
        });
    }
}