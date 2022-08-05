package com.cookandroid.and0803_01_cuslistcar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Movie;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView list;
    CarAdapter cAdapter;
    ArrayList<CAR> cArray;
    CAR cItem;
    Integer[] poster = {R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04, R.drawable.mov05, R.drawable.mov06, R.drawable.mov07, R.drawable.mov08, R.drawable.mov09, R.drawable.mov10};
    String[] title = {"토이4", "호빗", "제이스본", "반지의 제왕", "정직한 후보", "나쁜녀석들", "겨울왕국", "알라딘", "극한직업", "스파이더맨"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("[민영]영화 커스텀 리스트");
        list = findViewById(R.id.list);
        cArray = new ArrayList<>();
        for(int i = 0; i < poster.length; i++){
            cItem = new CAR(ContextCompat.getDrawable(this, poster[i]), title[i]);
            cArray.add(cItem);
        } //무비 객체 배열 초기화(ArrayList에 값으로 생성)
        cAdapter = new CarAdapter(this, cArray);
        list.setAdapter(cAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                CAR item = (CAR)list.getItemAtPosition(i);
                customToast(item);
            }
        });
    }
    public void customToast(CAR item){
        View layout = getLayoutInflater().inflate(R.layout.car_toast, null);
        ImageView img = layout.findViewById(R.id.toast_img);
        TextView txt = layout.findViewById(R.id.toast_txt);
        img.setImageDrawable(item.getImage());
        txt.setText(item.getTitle());
        Toast t = new Toast(getApplicationContext());
        t.setView(layout);
        t.setGravity(Gravity.CENTER_VERTICAL,0,0);
        t.setDuration(Toast.LENGTH_SHORT);
        //위치지정
        t.show();

    }
}