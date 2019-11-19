package com.lanren.mt.utils;

import android.content.Context;
import android.content.SharedPreferences;



public class QuickSharedPreferences {
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;
    private static final String SHAREPREFERENCE_NAME = "lanren_sp_name";

    public static void setIsStudent(Context context,boolean isStudent){
        sharedPreferences = context.getSharedPreferences(SHAREPREFERENCE_NAME,Context.MODE_PRIVATE | Context.MODE_MULTI_PROCESS);
        editor = sharedPreferences.edit();
        editor.putBoolean("isStudent",isStudent);
        editor.commit();
    }

    public static boolean getIsStudent(Context context){
        sharedPreferences = context.getSharedPreferences(SHAREPREFERENCE_NAME,Context.MODE_PRIVATE | Context.MODE_MULTI_PROCESS);
        return sharedPreferences.getBoolean("isStudent", false);
    }

    public static void setSex(Context context,String sex){
        sharedPreferences = context.getSharedPreferences(SHAREPREFERENCE_NAME,Context.MODE_PRIVATE | Context.MODE_MULTI_PROCESS);
        editor = sharedPreferences.edit();
        editor.putString("Sex",sex);
        editor.commit();
    }

    public static String getSex(Context context){
        sharedPreferences = context.getSharedPreferences(SHAREPREFERENCE_NAME,Context.MODE_PRIVATE | Context.MODE_MULTI_PROCESS);
        return sharedPreferences.getString("Sex", "男");
    }
}
