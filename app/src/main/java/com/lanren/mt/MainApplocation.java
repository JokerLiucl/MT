package com.lanren.mt;

import android.app.Application;

import com.lanren.mt.utils.TypefaceUtil;

import java.util.concurrent.TimeUnit;


public class MainApplocation extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        TypefaceUtil.replaceSystemDefaultFont(this,"font/avenir_medium.ttf");
    }
}
