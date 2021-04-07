# Lab 5. Implicit Intents

## practice

http://ajb.aston.ac.uk/codelabs/Unit_2.3/index.html?index=..%2F..index#0

第一个app的manifest文件中`<intent-filter>`中加入

```xml
<category android:name="android.intent.category.BROWSABLE" />
```

终于可以出现选择应用

程序截图和录屏见parctice命名文件

## homework

要求：相机拍照功能

0. 布局中加一个按钮

1. <manifst中添加

   ```xml
   <uses-feature android:name="android.hardware.camera"
           android:required="true" />
   ```

2. MainActivity中

   ```java
       static final int REQUEST_IMAGE_CAPTURE = 1;
   ```

   按钮的onclick功能函数

   ```java
   Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
   if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
       startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
   }
   ```

相机功能在真机模拟

截屏和视频见homework文件