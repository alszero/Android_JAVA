package com.cookandroid.project0616;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edX, edY;
    Button btnAdd, btnSub, btnMul;
    TextView txtResult;
    Button[] btnNums = new Button[10];
    Integer[] ids = {R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9};

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i = 0; i < btnNums.length; i++) {
            btnNums[i] = findViewById(ids[i]);

            final int index = i;
            btnNums[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (edX.isFocused()) {
                        String s = edX.getText().toString().toString() + index;
                        edX.setText(s);
                    } else if (edY.isFocused()) {
                        String s = edY.getText().toString() + index;
                        edY.setText(s);
                    } else {
                        Toast.makeText(getApplicationContext(),
                                "에디터부터 선택하세요.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            edX = findViewById(R.id.edX);
            edY = findViewById(R.id.edY);
            btnAdd = findViewById(R.id.btnAdd);
            btnSub = findViewById(R.id.btnSub);
            btnMul = findViewById(R.id.btnMul);
            txtResult = findViewById(R.id.txtResult);


            btnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //x+y 결과 출력
                    String strx = edX.getText().toString();
                    String stry = edY.getText().toString();
                    int result = Integer.parseInt(strx) + Integer.parseInt(stry);
                    txtResult.setText("계산결과: " + result);
                }
            });
            btnSub.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //x-y 결과 출력
                    String strx = edX.getText().toString();
                    String stry = edY.getText().toString();
                    int result = Integer.parseInt(strx) - Integer.parseInt(stry);
                    txtResult.setText("계산결과: " + result);
                }
            });
            btnMul.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //x*y 결과 출력
                    String strx = edX.getText().toString();
                    String stry = edY.getText().toString();
                    int result = Integer.parseInt(strx) * Integer.parseInt(stry);
                    txtResult.setText("계산결과: " + result);
                }
            });
        }
    }//onCreate()

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.option, menu); //xml을 메뉴로 생성
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int x = Integer.parseInt(edX.getText().toString());
        int y = Integer.parseInt(edY.getText().toString());
        switch (item.getItemId()){
            case R.id.itemAdd :
                txtResult.setText("계산결과: " + (x+y));
                break;
            case R.id.itemMul :
                txtResult.setText("계산결과: " + (x*y));
                break;
            case R.id.itemExit :
                finish();
        }
        return true;
    }
}