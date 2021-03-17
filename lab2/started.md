## Lab 2. Get started

[Codelab 1.1: Android Studio and Hello World](https://codelabs.developers.google.com/codelabs/android-training-hello-world/#0)

链接：http://ajb.aston.ac.uk/codelabs/Unit_1.1/index.html?index=..%2F..index#0

1. 安装Android Studio

2. 创建Hello world程序

3. 使用虚拟设备（仿真器）

4. 使用物理设备

5. 更改应用程序Gradle配置

   module中修改minSdkVersion的值 ，然后sync now

6. 将日志语句添加到您的应用程序

   Follow these steps to add your own `Log` message to your Hello World app:

   1. Open your Hello World app in Android studio, and open `MainActivity`.

   2. To add unambiguous imports automatically to your project (such as `android.util.Log` required for using `Log`), choose **File > Settings** in Windows, or **Android Studio > Preferences** in macOS.

   3. Choose **Editor > General >Auto Import**. Select all checkboxes and set **Insert imports on paste** to **All**.

   4. Click **Apply** and then click **OK**.

   5. In the`onCreate()`method of`MainActivity`, add the following statement:

      ```
      Log.d("MainActivity", "Hello World"); 
      ```

      The`onCreate()`method should now look like the following code:

      ```
      @Override
      protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);
          Log.d("MainActivity", "Hello World");
      }
      ```

   6. If the Logcat pane is not already open, click the Logcat tab at the bottom of Android Studio to open it.

   7. Check that the name of the target and package name of the app are correct.

   8. Change the Log level in the Logcat pane to Debug (or leave as Verbose since there are so few log messages).

   9. Run your app.

   And get this log:

   ```
   2021-03-17 16:52:36.592 8867-8867/com.example.myapplication D/MainActivity: Hello World
   ```

7. 编码

   Textview里边改成 android:text="@string/show_message"

   res string里加入<string name="show_message">happy</string>

   Log.e()