package com.cookandroid.and0728_02_menudlgtest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btngender, btnOk;
    EditText edtnum, edtgender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btngender=findViewById(R.id.btngender);
        btnOk=findViewById(R.id.btnOk);
        edtnum=findViewById(R.id.edtnum);
        edtgender=findViewById(R.id.edtgender);

        btngender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu p = new PopupMenu(getApplicationContext(), view);
                getMenuInflater().inflate(R.menu.menu_popup, p.getMenu());
                p.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch(menuItem.getItemId()){
                            case R.id.popup_man:
                                edtgender.setText("남자");
                                return true;

                            case R.id.popup_woman:
                                edtgender.setText("여자");
                                return true;

                            default: edtgender.setText("선택안됨");
                                return false;
                        }
                    }
                });
                p.show();
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("가입 정보 확인");
                dlg.setIcon(R.mipmap.ic_launcher_round);
                dlg.setMessage("전화번호: "+edtnum.getText() +"\n성별: "+ edtgender.getText());
                dlg.setPositiveButton("확인", null);
                dlg.show();
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "가입완료~",
                                Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "가입 취소하였습니다.",
                                Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.show();
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater minflater = getMenuInflater(); //메뉴 생성하는 것.
        minflater.inflate(R.menu.menu_option, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.option_reset:
                Toast.makeText(getApplicationContext(), "초기화완료!", Toast.LENGTH_SHORT).show();
                edtgender.setText("");
                edtnum.setText("");
                return true;

            case R.id.option_finsh:
                finish();
                return true;

            default: Toast.makeText(getApplicationContext(), "선택 안됨", Toast.LENGTH_SHORT).show();
                return false;
        }
    }


}