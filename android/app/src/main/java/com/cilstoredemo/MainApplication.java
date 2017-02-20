package com.cilstoredemo;

import android.app.Application;

import com.facebook.soloader.SoLoader;

public class MainApplication extends Application {
    private static Application application;

    public static Application getApplication() {
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;

        SoLoader.init(this, /* native exopackage */ false);
    }
}
