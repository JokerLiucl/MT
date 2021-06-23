package com.lanren.testMt;

import android.app.Application;

import com.lanren.testMt.utils.TypefaceUtil;
import com.loan.loandatasdk.LoanDataSDK;


public class MainApplocation extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        TypefaceUtil.replaceSystemDefaultFont(this,"font/avenir_medium.ttf");

        //模拟新添加的功能
        LoanDataSDK.getInstance().init(getApplicationContext(),"1111111");
    }
}
