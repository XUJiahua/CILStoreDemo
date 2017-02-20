package com.cilstoredemo;

/**
 * 主体copy自ReactActivity，稍作修改，修改部分有注释
 * <p>
 * Copyright (c) 2015-present, Facebook, Inc.
 * All rights reserved.
 * <p>
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */

/**
 * Copyright (c) 2015-present, Facebook, Inc.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;

import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.modules.core.PermissionAwareActivity;
import com.facebook.react.modules.core.PermissionListener;
import com.facebook.react.shell.MainReactPackage;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Nullable;

/**
 * Base Activity for React Native applications.
 */
public class CILReactActivity extends Activity
        implements DefaultHardwareBackBtnHandler, PermissionAwareActivity {

    public static final String BundleName = "com.cardinfolink.smart.pos.CILReactActivity.bundleName";
    public static final String MainComponentName = "com.cardinfolink.smart.pos.CILReactActivity.mainComponentName";

    private CILReactActivityDelegate mDelegate;

    /**
     * 新增：bundle名称
     */
    private String bundleName;
    /**
     * 新增：bundle中的主模块名称
     */
    private String mainComponentName;

    /**
     * Returns the name of the main component registered from JavaScript.
     * This is used to schedule rendering of the component.
     * e.g. "MoviesApp"
     */
    protected @Nullable
    String getMainComponentName() {
        return mainComponentName;
    }

    /**
     * Called at construction time, override if you have a custom delegate implementation.
     *
     * 重写，注入bundleName
     */
    protected CILReactActivityDelegate createReactActivityDelegate() {
        CILReactActivityDelegate reactActivityDelegate = new CILReactActivityDelegate(this, getMainComponentName());
        reactActivityDelegate.setReactNativeHost(new ReactNativeHost(MainApplication.getApplication()) {
            @Override
            public boolean getUseDeveloperSupport() {
                // NOTE: 使用本地bundle，设置为True，开发模式设置为False
                return !BuildConfig.DEBUG;
            }

            @Override
            protected List<ReactPackage> getPackages() {
                return Arrays.<ReactPackage>asList(
                        new MainReactPackage()
                        // NOTE: 自定义Package放这里
                );
            }

            @Override
            protected String getJSMainModuleName() {
                return bundleName;
            }

            @Nullable
            @Override
            protected String getBundleAssetName() {
                return bundleName + ".bundle";
            }
        });
        return reactActivityDelegate;
    }

    /**
     * 主要的改写逻辑在onCreate
     * ReactActivityDelegate实例的创建，依赖几个参数，一个是bundleName，一个是mainComponentName，在onCreate前是不知道的
     * 既然mDelegate第一次被使用是在onCreate，那么mDelegate的创建也放在onCreate中
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.bundleName = getIntent().getStringExtra(BundleName);
        this.mainComponentName = getIntent().getStringExtra(MainComponentName);

        if (this.bundleName == null ||
                this.bundleName.equals("") ||
                this.mainComponentName == null ||
                this.mainComponentName.equals("")) {
            throw new IllegalArgumentException("bundleName and mainComponentName are required");
        }

        mDelegate = createReactActivityDelegate();
        mDelegate.onCreate(savedInstanceState);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mDelegate.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mDelegate.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mDelegate.onDestroy();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        mDelegate.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        return mDelegate.onKeyUp(keyCode, event) || super.onKeyUp(keyCode, event);
    }

    @Override
    public void onBackPressed() {
        if (!mDelegate.onBackPressed()) {
            super.onBackPressed();
        }
    }

    @Override
    public void invokeDefaultOnBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onNewIntent(Intent intent) {
        if (!mDelegate.onNewIntent(intent)) {
            super.onNewIntent(intent);
        }
    }

    @Override
    public void requestPermissions(
            String[] permissions,
            int requestCode,
            PermissionListener listener) {
        mDelegate.requestPermissions(permissions, requestCode, listener);
    }

    @Override
    public void onRequestPermissionsResult(
            int requestCode,
            String[] permissions,
            int[] grantResults) {
        mDelegate.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    protected final ReactNativeHost getReactNativeHost() {
        return mDelegate.getReactNativeHost();
    }

    protected final ReactInstanceManager getReactInstanceManager() {
        return mDelegate.getReactInstanceManager();
    }

    protected final void loadApp(String appKey) {
        mDelegate.loadApp(appKey);
    }
}
