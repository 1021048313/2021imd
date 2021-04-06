# Activities and intents

## Practice

http://ajb.aston.ac.uk/codelabs/Unit_2.1/index.html?index=..%2F..index#0

两个Activity，见项目Two_activity，

项目截图、视频命名为practice



## Homework

Toast传送count值，见项目Toast_activity，关键代码如下：

项目截图、视频命名为homework

1. 复制并改名lab3的Hello Toast

2. 添加一个新的activity，并在xml文件中配置parent

   > ```xml
   > android:parentActivityName=".MainActivity">
   > <meta-data
   >     android:name="android.support.PARENT_ACTIVITY"
   >     android:value=".MainActivity"
   > ```

3. 修改sayhello button的onclick函数

   ```java
   Intent intent=new Intent(this, showhello.class);
   //获取计数
   String message=Integer.toString(mCount);
   intent.putExtra(EXTRA_MESSAGE,message);
   startActivity(intent);
   ```

4. 修改第二个activity的layout number_message用于显示计数值

5. 修改第二个activity的onCreate函数

   ```java
   //activate the activity
   Intent intent=getIntent();
   //get string from Intent extra
   String message=intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
   //find TextView
   TextView textView=findViewById(R.id.number_message);
   textView.setText(message);
   ```

   

   

   

