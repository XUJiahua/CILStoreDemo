package com.cilstoredemo;

import android.app.Application;

import com.facebook.soloader.SoLoader;

public class MainApplication extends Application { //implements ReactApplication {
    private static Application application;

    public static Application getApplication() {
        return application;
    }

    //  private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
//    @Override
//    public boolean getUseDeveloperSupport() {
//      return BuildConfig.DEBUG;
//    }
//
//    @Override
//    protected List<ReactPackage> getPackages() {
//      return Arrays.<ReactPackage>asList(
//          new MainReactPackage()
//      );
//    }
//
//    @Override
//    protected String getJSMainModuleName() {
//      return "index.android2";
//    }
//  };
//
//  @Override
//  public ReactNativeHost getReactNativeHost() {
//    return mReactNativeHost;
//  }

  @Override
  public void onCreate() {
    super.onCreate();
      application = this;

    SoLoader.init(this, /* native exopackage */ false);
  }
}
