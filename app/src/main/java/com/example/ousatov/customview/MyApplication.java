package com.example.ousatov.customview;

import android.app.Application;


public class MyApplication extends Application {

    private static MyApplication context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;

        FontCache.initCache();
    }


    public static MyApplication getInstance() {
        return context;
    }
}
