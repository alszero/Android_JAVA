package com.cookandroid.and0728_03_optionmenu;

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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView img;
    Button btn;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = findViewById(R.id.img);
        btn = findViewById(R.id.btnTel);
        txt = findViewById(R.id.txt);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("전화번호 등록");
                dlg.setIcon(R.mipmap.ic_launcher_round);
                final View dlgView = (View)View.inflate(MainActivity.this,
                        R.layout.dlg, null);
                dlg.setView(dlgView);

                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditText edName = dlgView.findViewById(R.id.edtName);
                        EditText edTel = dlgView.findViewById(R.id.edtTel);
                        String str = "이름 :" + edName.getText().toString()+"\n"+
                                "전화번호 :" + edTel.getText().toString();
                        txt.setText(str);
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
            case R.id.option_img2:
                img.setImageResource(R.drawable.glitch_hc);
                return true;

            case R.id.option_img1:
                img.setImageResource(R.drawable.beatbox_hc);
                return true;

            case R.id.option_img3:
                img.setImageResource(R.drawable.sticker_hc);
                return true;

            default: Toast.makeText(getApplicationContext(), "선택 안됨", Toast.LENGTH_SHORT).show();
                return false;
        }
    }
}