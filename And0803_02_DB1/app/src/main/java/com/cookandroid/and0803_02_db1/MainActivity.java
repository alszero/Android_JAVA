package com.cookandroid.and0803_02_db1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtName, edtNumber;
    TextView txtNameResult, txtNumberResult;
    Button btnClear, btnInsert, btnSelect, btnEdit, btnDelete;
    MyDBHelper myHelper;
    SQLiteDatabase sqlDB;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("[민영]가수그룹관리DB실습");
        edtName = findViewById(R.id.edtName);
        edtNumber = findViewById(R.id.edtNum);
        txtNameResult = findViewById(R.id.txtGNameResult);
        txtNumberResult = findViewById(R.id.txtGNumberResult);
        btnClear = findViewById(R.id.btnre);
        btnInsert = findViewById(R.id.btntxt);
        btnSelect = findViewById(R.id.btnsearch);
        btnEdit = findViewById(R.id.btnedit);
        btnDelete = findViewById(R.id.btndelete);
        myHelper = new MyDBHelper(this);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //DBd의 테이블 삭제 후 다시 생성
                sqlDB = myHelper.getWritableDatabase(); //수정모드 오픈
                myHelper.onUpgrade(sqlDB, 1, 2); //숫자는 버전의미로 아무거나
                sqlDB.close();
            }
        });
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String name = edtName.getText().toString().trim();
                    int num = Integer.parseInt(edtNumber.getText().toString().trim());
                    if (name.isEmpty()){
                        Toast.makeText(getApplicationContext(), "이름입력필수",
                                Toast.LENGTH_SHORT).show();
                    }else{
                        sqlDB = myHelper.getWritableDatabase();
                        sqlDB.execSQL("insert into groupTBL(gName, gNumber) values('"+name+"', "+num+");");
                        sqlDB.close();
                        Toast.makeText(getApplicationContext(), "입력성공",
                                Toast.LENGTH_SHORT).show();
                        edtName.setText(""); edtNumber.setText("");
                        btnSelect.callOnClick(); //btnSelect()함수 호출
                    }
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "입력실패",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlDB = myHelper.getReadableDatabase();
                Cursor cursor = sqlDB.rawQuery("select * from groupTBL;", null);
                String strNames = "그룹이름\r\n"+"---------------\r\n";
                String strNums = "인원수\r\n"+"---------------\r\n";
                while (cursor.moveToNext()){
                    strNames+=cursor.getString(0)+"\n";
                    strNums+=cursor.getString(1)+"\n";
                }
                txtNameResult.setText(strNames);
                txtNumberResult.setText(strNums);
                cursor.close();
                sqlDB.close();
                Toast.makeText(getApplicationContext(), "조회성공",
                        Toast.LENGTH_SHORT).show();
            }
        });
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View v = View.inflate(getApplicationContext(), R.layout.dlg, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("그룹 정보 변경");
                dlg.setView(v);
                final EditText edtEditGName = v.findViewById(R.id.edtUpdateGName);
                final EditText edtEditGNumber = v.findViewById(R.id.edtUpdateGNumber);
                dlg.setPositiveButton("변경", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        try {
                            sqlDB = myHelper.getWritableDatabase();
                            String name = edtEditGName.getText().toString().trim();
                            String number = edtEditGNumber.getText().toString().trim();
                            if(!name.isEmpty() && !number.isEmpty()) {
                                String sql = ("UPDATE groupTBL SET gNumber= "+ number +" WHERE gName = '"+name+"'");
                                sqlDB.execSQL(sql);
                                sqlDB.close();
                                Toast.makeText(getApplicationContext(), "변경됨", Toast.LENGTH_SHORT).show();
                                btnSelect.callOnClick();
                            }else{
                                Toast.makeText(getApplicationContext(), "이름을 입력하세요", Toast.LENGTH_SHORT).show();
                            }
                        }catch (Exception e){
                            Toast.makeText(getApplicationContext(), "변경 실패", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                dlg.setNegativeButton("취소", null); dlg.show();
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View v = View.inflate(getApplicationContext(),R.layout.delete, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("그룹 삭제");  dlg.setView(v);
                final EditText edtDeleteGName = v.findViewById(R.id.edtdelname);
                dlg.setPositiveButton("삭제", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        try {
                            sqlDB = myHelper.getWritableDatabase();
                            String name = edtDeleteGName.getText().toString().trim();
                            if (!name.isEmpty()){
                                sqlDB.execSQL("DELETE FROM groupTBL WHERE gName = '" + name + "';");
                                Toast.makeText(getApplicationContext(), name + "삭제됨",
                                        Toast.LENGTH_SHORT).show();
                                sqlDB.close();
                                btnSelect.callOnClick();
                            }else Toast.makeText(getApplicationContext(), "이름을 입력하세요.",
                                    Toast.LENGTH_SHORT).show();
                        }catch (Exception e){
                            Toast.makeText(getApplicationContext(), "삭제 실패",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                dlg.setNegativeButton("취소", null); dlg.show();
            }
        });
    }
}