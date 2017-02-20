package com.cilstoredemo;

import com.facebook.react.ReactActivity;
import com.facebook.react.ReactActivityDelegate;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Nullable;

public class CILReactActivity extends ReactActivity {
    // NOTE：不带后缀bundle
    protected String getBundleName() {
        // default name
        return "index.android";
    }

    @Override
    protected ReactActivityDelegate createReactActivityDelegate() {
        CILReactActivityDelegate reactActivityDelegate = new CILReactActivityDelegate(this, getMainComponentName());
        // createReactActivityDelegate的调用是在constructor，而this.getApplication()此时是null，会在onCreate中才会有值
//        reactActivityDelegate.setReactNativeHost(new ReactNativeHost(this.getApplication()) {
        reactActivityDelegate.setReactNativeHost(new ReactNativeHost(MainApplication.getApplication()) {
            @Override
            public boolean getUseDeveloperSupport() {
                // 使用本地bundle，设置为True，开发模式设置为False
                return BuildConfig.DEBUG;
            }

            @Override
            protected List<ReactPackage> getPackages() {
                return Arrays.<ReactPackage>asList(
                        new MainReactPackage()
                );
            }

            @Override
            protected String getJSMainModuleName() {
                return getBundleName();
            }

            @Nullable
            @Override
            protected String getBundleAssetName() {
                return getBundleName() + ".bundle";
            }
        });
        return reactActivityDelegate;
    }
}
