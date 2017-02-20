package com.cilstoredemo;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;

import com.facebook.react.ReactActivityDelegate;
import com.facebook.react.ReactNativeHost;

import javax.annotation.Nullable;

public class CILReactActivityDelegate extends ReactActivityDelegate {
    private ReactNativeHost mReactNativeHost;

    public CILReactActivityDelegate(Activity activity, @Nullable String mainComponentName) {
        super(activity, mainComponentName);
    }

    public CILReactActivityDelegate(FragmentActivity fragmentActivity, @Nullable String mainComponentName) {
        super(fragmentActivity, mainComponentName);
    }

    @Override
    protected ReactNativeHost getReactNativeHost() {
        return mReactNativeHost;
    }

    public void setReactNativeHost(ReactNativeHost mReactNativeHost) {
        this.mReactNativeHost = mReactNativeHost;
    }
}
