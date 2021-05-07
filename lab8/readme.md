# lab8

## practice

几个问题：

1. 无法新建activity：改一下minSdkVersion 16

2. 出现E/roid.materialm: Invalid ID 0x00000000.

   新建detail的时候不要选activity的框

3. 出现报错
   
   ```
   There were multiple failures while executing work items
      > A failure occurred while executing com.android.build.gradle.tasks.MergeResources$FileGenerationWorkAction
         > Error while processing D:\git\imd\2021imd\lab8\MaterialMe-Starter\app\src\main\res\drawable\ic_reset.xml : Can't process attribute android:fillColor="@android:color/white": references to other resources are not supported by build-time PNG generation. See http://developer.android.com/tools/help/vector-asset-studio.html for details.
   ```
   
   在build.gradle - defaultConfig中加入
   
   ```
   vectorDrawables.useSupportLibrary = true
   ```

## homework

1. Enable window content transitions in your theme.

   styles中需要加入

   ```xml
           <item name="android:windowContentTransitions">true</item>
   ```

4. Assign a common name to the shared elements in both layouts with the `android:transitionName` attribute.

   在activity_detail.xml和list_item.xml的ImageView中增加

   ```xml
   android:transitionName="shared_sports"
   ```

3. Use the `ActivityOptions.makeSceneTransitionAnimation()` function.

   修改SportsAdapter.java的onClick方法

   ```java
               ActivityOptions options = ActivityOptions
                       .makeSceneTransitionAnimation((Activity)mContext, getImageView(), "shared_sports");
               // start the new activity
               ActivityCompat.startActivity(mContext,detailIntent, options.toBundle());
   ```

   其中getImageView()方法是返回mSportsImage

截图和录屏见homework命名的两个文件。

