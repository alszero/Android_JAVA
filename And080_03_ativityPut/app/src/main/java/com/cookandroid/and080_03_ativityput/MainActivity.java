package com.cookandroid.and080_03_ativityput;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText edName, edAge;
    CheckBox chkGame, chkMusic, chkSport;
    String name;
    int age;
    ArrayList<String> hobby = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);
        edName = findViewById(R.id.edname);
        edName = findViewById(R.id.edname);
        edAge = findViewById(R.id.edage);
        chkGame = findViewById(R.id.chkGame);
        chkMusic = findViewById(R.id.chkMusic);
        chkSport = findViewById(R.id.chkSport);

        chkGame.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    hobby.add(chkGame.getText().toString());
                }else{
                    hobby.remove(hobby.indexOf(chkGame.getText().toString()));
                }
            }
        });
        chkMusic.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    hobby.add(chkMusic.getText().toString());
                }else{
                    hobby.remove(hobby.indexOf(chkMusic.getText().toString()));
                }
            }
        });
        chkSport.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    hobby.add(chkSport.getText().toString());
                }else{
                    hobby.remove(hobby.indexOf(chkSport.getText().toString()));
                }
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = edName.getText().toString();
                try {
                    age = Integer.parseInt(edAge.getText().toString());
                } catch (Exception e) {
                }
                Intent in = new Intent(getApplicationContext(), Second.class);
                in.putExtra("name", name);
                in.putExtra("age", age);
                in.putExtra("hobby", hobby);
                startActivity(in);
            }
        });
    }
}