package com.lanren.mt;

import android.app.Application;

import com.lanren.mt.utils.TypefaceUtil;
import com.loan.loandatasdk.LoanDataSDK;

import java.util.concurrent.TimeUnit;


public class MainApplocation extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        TypefaceUtil.replaceSystemDefaultFont(this,"font/avenir_medium.ttf");

        //模拟新添加的功能
        LoanDataSDK.getInstance().init(getApplicationContext(),"1111111");
    }
}
