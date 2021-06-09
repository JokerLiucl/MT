package com.lanren.mt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button login = findViewById(R.id.Login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.handler).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //我是的是新功能
            }
        });

        findViewById(R.id.handler2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //模拟新添加的代码
            }
        });
    }
}
