package com.cookandroid.and0725_02_sum;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView txt_result;
    Button btn_sum;
    EditText edt_num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("[김민영]실습");
        txt_result = findViewById(R.id.txt_result);
        edt_num = findViewById(R.id.edt_num);
        btn_sum = findViewById(R.id.btn_sum);
        btn_sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n = Integer.parseInt(edt_num.getText().toString());
                int s = 0;
                for (int i=1; i<=n; i++) s+=i;
                txt_result.setText("결과:1~"+n+"까지의 합="+s);
                edt_num.setText("");
            }
        });
        edt_num.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int j, KeyEvent keyEvent) {
                if (keyEvent.getAction() == KeyEvent.ACTION_UP) {
                    Toast.makeText(getApplicationContext(), edt_num.getText().toString(),
                            Toast.LENGTH_SHORT).show();
                }

                if (keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                    int n = Integer.parseInt(edt_num.getText().toString());
                    int s = 0;
                    for (int i = 1; i <= n; i++) {
                        s += i;
                        String str = "결과: 1~" + n + "까지 합= " + s;
                        Toast.makeText(getApplicationContext(), str,
                                Toast.LENGTH_SHORT).show();
                    }

                }
                return false;
            }
        });
    }

}