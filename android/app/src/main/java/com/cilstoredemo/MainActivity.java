package com.cilstoredemo;

public class MainActivity extends CILReactActivity {


//    private String mainComponentName;
//    private String bundleName;
//
//    public MainActivity(String bundleName, String mainComponentName) {
//        this.bundleName = bundleName;
//        this.mainComponentName = mainComponentName;
//    }
//
//    public MainActivity(String mainComponentName) {
//        this.mainComponentName = mainComponentName;
//    }

    /**
     * Returns the name of the main component registered from JavaScript.
     * This is used to schedule rendering of the component.
     */
    @Override
    protected String getMainComponentName() {
//        return mainComponentName;
        return "CILStoreDemo";
    }

//    @Override
//    protected String getBundleName() {
//        if (bundleName == null) {
//            return super.getBundleName();
//        }
//        return bundleName;
//    }
}
