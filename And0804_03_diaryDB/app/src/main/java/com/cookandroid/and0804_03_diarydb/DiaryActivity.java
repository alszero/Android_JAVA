package com.cookandroid.and0804_03_diarydb;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileOutputStream;

public class DiaryActivity extends AppCompatActivity {
    DatePicker dp;
    EditText edtDiary;
    Button btnWrite, btnDel;
    String fileName;
    MyDBHelper myHelper;
    SQLiteDatabase sqlDB;
    int cYear, cMonth, cDay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diary);
        setTitle("[일기장 SQLite]미녕");
        dp = findViewById(R.id.dp);
        edtDiary = findViewById(R.id.edtDiary);
        btnWrite = findViewById(R.id.btnWrite);
        btnDel = findViewById(R.id.btnDel);

        Intent in = getIntent();
        String fname = in.getStringExtra("fname"); //2022_08_05 >> {"2022" , "08", "05"}
        String[] arr = fname.split("_"); //"_"문자로 분리 >> 문자열 처리

        cYear = Integer.parseInt(arr[0]); //"2022"
        cMonth = Integer.parseInt(arr[1]) - 1; //"08" >> 자바에서 월은 0부터 시작
        cDay = Integer.parseInt(arr[2]); //"05"
        myHelper = new MyDBHelper(this); //데이터베이스 초기화
        fileName = cYear + "_" + (cMonth + 1) + "_" + cDay; //숫자 + 문자열 >> 문자열로 자동 형변환

        String str = readDiary(fileName);
        edtDiary.setText(str);

        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btnWrite.getText().toString().equals("새로 저장")) { //insert 처리
                    sqlDB = myHelper.getWritableDatabase();
                    sqlDB.execSQL("INSERT INTO DiaryTBL(diaryDate, content) " + " VALUES( '" + fileName + "', '" + edtDiary.getText().toString() + "');");
                    sqlDB.close();
                    Toast.makeText(getApplicationContext(), "입력됨", Toast.LENGTH_SHORT).show();
                    btnWrite.setText("수정하기");
                    btnDel.setVisibility(View.VISIBLE);

                }else{ //update 처리
                    sqlDB = myHelper.getWritableDatabase();
                    sqlDB.execSQL("UPDATE DiaryTBL SET content = '" + edtDiary.getText().toString() + "' WHERE diaryDate = '" + fileName + "' ;");
                    sqlDB.close();
                    Toast.makeText(getApplicationContext(), "수정됨", Toast.LENGTH_SHORT).show();
                }
            }
        });

        dp.init(cYear, cMonth, cDay, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int y, int m, int d) {
                fileName = y + "_" + (m + 1) + "_" + d;
                String str = readDiary(fileName);
                edtDiary.setText(str);
            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    sqlDB = myHelper.getWritableDatabase(); //선택한 날짜만 삭제
                    sqlDB.execSQL("delete from DiaryTBL where diaryDate = '" + fileName + "' ;");
                    sqlDB.close();
                    Toast.makeText(getApplicationContext(), "삭제됨", Toast.LENGTH_SHORT).show();
                    edtDiary.setText("");
                    btnWrite.setText("새로 저장");
                    btnDel.setVisibility(View.GONE);
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "삭제 실패", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
    private String readDiary(String fName) {
        String diaryStr = null;
        sqlDB = myHelper.getReadableDatabase();
        Cursor cursor;
        cursor = sqlDB.rawQuery("SELECT * FROM DiaryTBL WHERE diaryDate = '" + fName + "';", null);
        if(cursor.moveToFirst() == true){ //날짜에 일기가 존재하면
            diaryStr = cursor.getString(2); //content 내용 가져오기
            btnWrite.setText("수정하기");
            btnDel.setVisibility(View.VISIBLE); //삭제 버튼 보이도록 처리
        }else{
            btnDel.setVisibility(View.GONE); //삭제 버튼 없애기
            btnWrite.setText("새로 저장");
        }
        cursor.close();
        sqlDB.close();
        return diaryStr;
    }
}
