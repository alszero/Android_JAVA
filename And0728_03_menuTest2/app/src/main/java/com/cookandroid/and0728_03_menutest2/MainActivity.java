package com.cookandroid.and0728_03_menutest2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.cookandroid.and0728_03_menutest2.R.id.itemBlue;

public class MainActivity extends AppCompatActivity {
    Button btnend;
    TextView txtName, txtTel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnend = findViewById(R.id.btnend);
        txtName = findViewById(R.id.txtName);
        txtTel = findViewById(R.id.txtTel);
        btnend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
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
        switch (item.getItemId()) {
            case R.id.itemReg:
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("전화번호 등록");
                dlg.setIcon(R.mipmap.ic_launcher_round);
                final View dlgView = (View) View.inflate(MainActivity.this,
                        R.layout.dlg, null);
                dlg.setView(dlgView);

                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditText edName = dlgView.findViewById(R.id.edtName);
                        EditText edTel = dlgView.findViewById(R.id.edtTel);
                        String str1 = edName.getText().toString();
                        String str2 = edTel.getText().toString();
                        txtName.setText(str1);
                        txtTel.setText(str2);
                    }
                });
                dlg.show();
                return true;

            case R.id.itemBlue:
                txtName.setTextColor(Color.BLUE);
                return true;

            case R.id.itemGreen:
                txtName.setTextColor(Color.GREEN);
                return true;

            case R.id.itemDefault:
                txtName.setTextColor(Color.BLACK);
                return true;

            default: Toast.makeText(getApplicationContext(), "선택 안됨", Toast.LENGTH_SHORT).show();
                return false;
        }
    }
}