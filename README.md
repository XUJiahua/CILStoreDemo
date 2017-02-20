# Demo 使用RN做应用插件

## 调试模式
npm start
adb reverse tcp:8081 tcp:8081

默认bundle：
localhost:8081/index.android.bundle?platform=android&dev=true&hot=true&minify=false

新增bundle:
localhost:8081/index.android2.bundle?platform=android&dev=true&hot=true&minify=false

## 打包到本地
react-native bundle --platform android --dev false --entry-file index.android.js --bundle-output android/app/src/main/assets/index.android.bundle --assets-dest android/app/src/main/res/

react-native bundle --platform android --dev false --entry-file index.android2.js --bundle-output android/app/src/main/assets/index.android2.bundle --assets-dest android/app/src/main/res/

另外getUseDeveloperSupport方法返回true即可。