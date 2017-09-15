package com.example.administrator.popupwindowdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv_popupwindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initEvents();

    }

    private void initViews() {
        tv_popupwindow = (TextView) findViewById(R.id.tv_popupwindow);
    }

    private void initEvents() {
        tv_popupwindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Tg_PopupWindowActivity.class);
                startActivity(intent);
            }
        });
    }

}
