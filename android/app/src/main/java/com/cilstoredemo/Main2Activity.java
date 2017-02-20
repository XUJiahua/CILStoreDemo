package com.cilstoredemo;

public class Main2Activity extends CILReactActivity {
    // componentName倒是可以固定下来，不同的bundle代表不同的应用即可
    @Override
    protected String getMainComponentName() {
        return "CILStoreDemo2";
    }

    @Override
    protected String getBundleName() {
        return "index.android2";
    }
}
