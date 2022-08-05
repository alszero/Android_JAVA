package com.cookandroid.and0729_02_diary_innermem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button btmWrite;
    EditText edtdiary;
    DatePicker dp;
    String fileName; //파일이름
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("[일기장-내장메모리에 저장]");
        setContentView(R.layout.activity_main);
        btmWrite = findViewById(R.id.btnWrite);
        edtdiary = findViewById(R.id.edtdiary);
        dp = findViewById(R.id.datePicker1);
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);  //시스템 달력에서 년도 가져오기
        int month = cal.get(Calendar.MONTH); //시스템 달력에서 월(0부터 시작) 가져오기
        int day = cal.get(Calendar.DAY_OF_MONTH); //시스템 달력에서 일 가져오기
        fileName = year+"_"+(month+1)+"_"+day+".txt"; // 파일이름 만들기 "년_월_일.txt"
        // 오늘날짜의 일기가 있으면 읽어서 edtDiary에 setText()하기
        String str = readDiary(fileName); //일기 읽기 완성
        edtdiary.setText(str);
        btmWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileOutputStream outFs = openFileOutput(fileName, Context.MODE_PRIVATE); // MODE_PRIVATE : 파일 쓰기용으로 open
                    String str = edtdiary.getText().toString();
                    outFs.write(str.getBytes());
                    outFs.close();
                    Toast.makeText(getApplicationContext(), fileName + "파일 생성됨", Toast.LENGTH_SHORT).show();
                }catch (Exception e){}
            }
        });
        dp.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int y, int m, int d) {
                fileName = y+"_"+(m+1)+"_"+d+".txt";
                String str = readDiary(fileName); //일기 있으면 가져오기
                edtdiary.setText(str);
            }
        });
    }
    // 파일 읽기 함수 따로 정의
    String readDiary(String fname){
        String diaryData = null; //일기 내용 저장하는 변수
        try {
            FileInputStream inFs = openFileInput(fname);
            byte[] in = new byte[500];
            inFs.read(in); //str.toString();
            diaryData = (new String(in)).trim();    // 양끝에 공백제거함수 trim()
            btmWrite.setText("수정하기");
            inFs.close();
        }catch (Exception e){
            btmWrite.setText("새로저장");
        }
        return diaryData;
    }
}