package com.example.chinni.jpcricket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CricketMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cricket_menu);
    }

    public void buttonClick(View view){
        Intent intent = new Intent(CricketMenu.this,MainActivity.class);
        startActivity(intent);
    }

    public void button2Click(View view){
        Intent intent = new Intent(CricketMenu.this,PlayersList.class);
        startActivity(intent);
    }
    public void button3Click(View view){
        Intent intent = new Intent(CricketMenu.this,News.class);
        startActivity(intent);
    }
}
