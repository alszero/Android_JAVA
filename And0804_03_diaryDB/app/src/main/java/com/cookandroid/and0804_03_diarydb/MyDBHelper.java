package com.cookandroid.and0804_03_diarydb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHelper extends SQLiteOpenHelper {
    public MyDBHelper(Context context) { super(context, "DiaryDB2.db", null, 1); }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //테이블 생성
        String str = "CREATE TABLE DiaryTBL(_id integer primary key autoincrement, diaryDate char(10), content varchar(500));";
        sqLiteDatabase.execSQL(str);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists DiaryTBL");
        onCreate(sqLiteDatabase);
    }
}
