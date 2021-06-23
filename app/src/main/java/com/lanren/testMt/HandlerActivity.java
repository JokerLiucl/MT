package com.lanren.testMt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.lanren.mt.R;
import com.lanren.testMt.builder.SetMeal;

public class HandlerActivity extends AppCompatActivity {

    private Handler mHandler;
    private TextView mTime;
    private Button mStart;
    private Button mReset;
    private int countTime = 10;

    private static final int START_TIME = 1;
    private static final int RESET_TIME = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);

        initView();
        mHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what == START_TIME){
                    if (countTime > 0){
                        countTime -= 1;
                        mTime.setText(countTime + "");
                        mHandler.sendEmptyMessageDelayed(START_TIME,1000);
                    }else {
                        Toast.makeText(HandlerActivity.this,"倒计时结束",Toast.LENGTH_SHORT).show();
                    }
                }

                if (msg.arg1 == RESET_TIME){
                    mHandler.removeMessages(START_TIME);
                    countTime = 10;
                    mTime.setText(countTime + "");
                }
            }
        };
    }

    private void initView() {
        mTime = findViewById(R.id.time);
        mStart = findViewById(R.id.start);
        mReset = findViewById(R.id.reset);
        findViewById(R.id.taocan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetMeal setMeal = new SetMeal.Builder()
                        .hanbao(2)
                        .jichi(2)
                        .kele(1)
                        .build();
                Log.i("liucl",setMeal.toString());
            }
        });

        mStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mHandler.sendEmptyMessageDelayed(START_TIME,1000);
            }
        });

        mReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message message = new Message();
                message.arg1 = RESET_TIME;
                mHandler.sendMessage(message);
            }
        });
    }
}
