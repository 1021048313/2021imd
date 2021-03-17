# flutter

## 简介

### 说明

>  [Flutter](https://flutter.dev) is Google’s UI toolkit for building beautiful, natively compiled applications for [mobile](https://flutter.dev/docs), [web](https://flutter.dev/web), and [desktop](https://flutter.dev/desktop) from a single codebase.

### 特性

- 快速发展

  可以迅速构建页面

- 富有表现力且灵活的用户界面

  快速发布功能，重点放在本地最终用户体验上

- 富有表现力且灵活的用户界面

  窗口小部件包含所有关键的平台差异

## 使用

### 安装flutter

参考：https://flutter.cn/docs/get-started/install/windows

对windows10系统

1. 下载压缩包并解压https://flutter.cn/docs/get-started/install/windows放到flutter的配置文件夹中

2. 下载安装包https://developer.android.google.cn/studio?hl=zh-cn然后直接装

   顺带安装一下Google USB（测试的android手机版本只有4.4，估计也不太能用）

   手机开发者模式-usb调试

3. 安装Flutter和Dart插件

4. 环境变量里边搞一下flutter

   系统变量的Path里加入\flutter\bin，用flutter --version检验

5. 配置国内镜像

   用户变量里，加两个：

   - FLUTTER_STORAGE_BASE_URL                https://storage.flutter-io.cn
   - PUB_HOSTED_URL                    https://pub.flutter-io.cn

### 写项目

#### 一些bug

1. 创建一个flutter项目，sdkpath里边填.\flutter就行，不用bin

2. 创建项目出现报错`Could not find an option named "platforms". Run 'flutter -h' (or 'flutter   -h') for available flutter commands and options.`

   flutter doctor看一下，更新之后出现：

   ```
   Doctor summary (to see all details, run flutter doctor -v):
   [√] Flutter (Channel stable, v1.0.0, on Microsoft Windows [Version 10.0.19041.804], locale en-US)
   [!] Android toolchain - develop for Android devices (Android SDK 30.0.3)
       X Android license status unknown.
   [!] Android Studio (not installed)
   [!] Connected device
       ! No devices available
   
   ! Doctor found issues in 3 categories.
   ```

3. android license 缺失

   执行flutter doctor --android-licenses，报错：

   ```
   A newer version of the Android SDK is required. To update, run:
   C:\Users\admin\AppData\Local\Android\sdk\tools\bin\sdkmanager --update
   ```

   根据提示执行命令，后报错

   ```
   Exception in thread "main" java.lang.NoClassDefFoundError: javax/xml/bind/annotation/XmlSchema
           at com.android.repository.api.SchemaModule$SchemaModuleVersion.<init>(SchemaModule.java:156)
           at com.android.repository.api.SchemaModule.<init>(SchemaModule.java:75)
           at com.android.sdklib.repository.AndroidSdkHandler.<clinit>(AndroidSdkHandler.java:81)
           at com.android.sdklib.tool.sdkmanager.SdkManagerCli.main(SdkManagerCli.java:73)
           at com.android.sdklib.tool.sdkmanager.SdkManagerCli.main(SdkManagerCli.java:48)
   Caused by: java.lang.ClassNotFoundException: javax.xml.bind.annotation.XmlSchema
           at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:606)
           at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:168)
           at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:522)
           ... 5 more
   ```

4. java.lang.ClassNotFoundException: javax.xml.bind.annotation.XmlSchema问题

   > JAXB API是java EE 的API，因此在java SE 9.0 中不再包含这个 Jar 包。 
   > java 9 中引入了模块的概念，默认情况下，Java SE中将不再包含java EE 的Jar包 
   > 而在 java 6/7 / 8 时关于这个API 都是捆绑在一起的

   方法：

   - 降低版本 jdk8就行

   - 手动加：下载这些jar包（或者在maven里加依赖）
     - http://search.maven.org/remotecontent?filepath=com/sun/activation/javax.activation/1.2.0/javax.activation-1.2.0.jar

     - http://search.maven.org/remotecontent?filepath=javax/xml/bind/jaxb-api/2.3.0/jaxb-api-2.3.0.jar

     - http://search.maven.org/remotecontent?filepath=com/sun/xml/bind/jaxb-core/2.3.0/jaxb-core-2.3.0.jar

     - http://search.maven.org/remotecontent?filepath=com/sun/xml/bind/jaxb-impl/2.3.0/jaxb-impl-2.3.0.jar

       下完之后把它们放到项目的\libs文件夹下面，参考android studio中添加jar包

   - 添加依赖

   

