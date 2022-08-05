package com.cookandroid.and0802_02_impact;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnDial, btnWeb, btnGoogle, btnSearch, btnSms, btnPhoto, btnLook, btnSend, btnEnd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDial = findViewById(R.id.btn1);
        btnWeb = findViewById(R.id.btn2);
        btnGoogle = findViewById(R.id.btn3);
        btnSearch = findViewById(R.id.btn4);
        btnSms = findViewById(R.id.btn5);
        btnPhoto = findViewById(R.id.btn6);
        btnLook = findViewById(R.id.btn7);
        btnSend = findViewById(R.id.btn8);
        btnEnd = findViewById(R.id.btn9);
        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("tel:010-1234-5678");
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);
            }
        });

        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://www.hanbit.co.kr");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://maps.google.com/maps?q="+37.559133+","+126.927824);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, "안드로이드");
                startActivity(intent);
            }
        });

        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.putExtra("sms_body", "안녕하세요?");
                intent.setData(Uri.parse("smsto:"+Uri.encode("010-1234-5678")));
                startActivity(intent);
            }
        });

        btnPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);
            }
        });

        btnLook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("content://contacts/people/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("mailto:"+"birchTree@naver.com");
                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                intent.putExtra("sms_body", "hello");
                startActivity(intent);
            }
        });

        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }//oncreate

    @Override
    protected void onStart() {
        super.onStart();
        android.util.Log.i("액티비티 테스트", "onStart()");
    }
    @Override
    protected void onResume() {
        super.onResume();
        android.util.Log.i("액티비티 테스트", "onResume()");
    }
    @Override
    protected void onPause() {
        super.onPause();
        android.util.Log.i("액티비티 테스트", "onPause()");
    }
    @Override
    protected void onStop() {
        super.onStop();
        android.util.Log.i("액티비티 테스트", "onStop()");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        android.util.Log.i("액티비티 테스트", "onRestart()");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        android.util.Log.i("액티비티 테스트", "onDestory()");
    }
}