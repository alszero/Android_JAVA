package com.cookandroid.and0726_05_chkfruit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox[] chkList = new CheckBox[4];
    Integer [] chkTest = {R.id.stra, R.id.grap, R.id.kiwi, R.id.jamo};
    Button btn;
    TextView txtresult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("체크박스 실습2[김민영]");
        btn = findViewById(R.id.btn);
        txtresult = findViewById(R.id.txtresult);

        for(int i =0; i<chkList.length; i++) chkList[i] = findViewById(chkTest[i]);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = "";
                for (int i =0; i<chkList.length; i++){
                    if(chkList[i].isChecked()==true){
                        str+= chkList[i].getText().toString() + " ";
                    }
                }
                txtresult.setText("선택 결과:"+str);
            }
        });

        for (int i=0; i< chkList.length; i++){
            final int k=i;
            chkList[i].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    String str = "";
                    for (int i = 0; i<chkList.length; i++) {
                        if (chkList[i].isChecked() == true) {
                            str += chkList[i].getText().toString() + " ";
                        }
                    }
                    txtresult.setText("결과: " + str);
                }
            });
        }
    }
}