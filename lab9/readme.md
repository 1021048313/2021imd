# lab9

homework: 见项目Urlget 效果见homework命名的文件。

## 设计

### 选择框-spinner

1. layout.xml：添加

    ```xml
    <Spinner
    android:id="@+id/protocol"/>
    ```

2. 设置表项内容 strings.xml

    ```xml
    <!--    Spinner的表项内容-->
    <string-array name="protocol_array">
    <item>http</item>
    <item>https</item>
    </string-array>
    ```

3. adapter显示 MainActivity.java的OnCreate

    ```java
    //        Spinner
    Spinner spinner = (Spinner) findViewById(R.id.protocol);
    // Create an ArrayAdapter using the string array and a default spinner layout
    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
    R.array.protocol_array, android.R.layout.simple_spinner_item);
    // Specify the layout to use when the list of choices appears
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    // Apply the adapter to the spinner
    spinner.setAdapter(adapter);
    ```

4. 响应用户选择：在onCreate里继续加

	其中`private String protocol_result;`用于保存protocol的值。

    ```java
    //响应用户-Spinner
    spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    protocol_result=(String) parent.getItemAtPosition(position);
    //                System.out.println(getSpinnerItem);
    }

    //没有设定空项，所以只要打开应用就会选中第一个
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    //                String getSpinnerItem=(String) parent;
    }
    });
    ```

### 输入框-Edittext

1. layout.xml

    ```xml
    android:onClick="getwholeurl"
    ```

2. 键盘下去

    ```java
    //隐藏键盘
    InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
    if (inputManager != null ) {
    inputManager.hideSoftInputFromWindow(view.getWindowToken(),
    InputMethodManager.HIDE_NOT_ALWAYS);
    }
    System.out.println(url_text);
    ```



### 按钮-Button

1. layout.xml

   ```xml
           android:onClick="getwholeurl"
   ```

2. java

   1. 响应用户输入的Edittext，并完成url

      ```java
      //获取EditText内容
      url_text = input_text.getText().toString();
      //合并
String urlstring=protocol_result+"://"+text_input;
      ```
   
   2. 连接网页
   
      ```java
      //检查网络连接
      ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
      NetworkInfo networkInfo = null;
      if (connMgr != null) {
          networkInfo = connMgr.getActiveNetworkInfo();
      }
      if (networkInfo != null && networkInfo.isConnected()) {
          Bundle queryBundle = new Bundle();
          queryBundle.putString("urlstring", urlstring);
          getSupportLoaderManager().restartLoader(0, queryBundle, this);
          scrolltext.setText(R.string.loading);
      }else {
          urlstring.length();
          scrolltext.setText(R.string.no_network);
      }
      ```
   

### 滚动-ScrollView

TextView用到setText

## 查询

1. 设置manifest

   ```xml
   <intent-filter>
       <action android:name="android.intent.action.MAIN" />
       <category android:name="android.intent.category.LAUNCHER" />
   </intent-filter>
   ```

2. 对MainActivity，implements LoaderManager.LoaderCallbacks<String>，并补全函数

   ```java
   @NonNull
   @Override
   public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {
       String urlstring = "";
       if (args != null) {
           //在上面Button中queryBundle.putString("urlstring", urlstring);这一句
           urlstring = args.getString("urlstring");
       }
       //PageLoader类写在下面
       return new PageLoader(this, urlstring);
   }
   
   @Override
   public void onLoadFinished(@NonNull Loader<String> loader, String data) {
       //        super.onPostExecute(s);
       //parse  website
       //        System.out.println("data"+data);
       //不用解析所以直接setText就行
       scrolltext.setText(data);
   
   }
   ```

3. 新建PageLoader类

   ```java
   public class PageLoader extends AsyncTaskLoader<String>{
       private String urlstring;
   
       PageLoader(Context context, String urlstring) {
           super(context);
           this.urlstring = urlstring;
       }
       public PageLoader(@NonNull Context context) {
           super(context);
       }
   
       @Override
       protected void onStartLoading() {
           super.onStartLoading();
           forceLoad();
       }
   
       @Nullable
       @Override
       public String loadInBackground() {
           //NetworkUtils类在下面，用到它的一个函数
           return NetworkUtils.getPageInfo(urlstring);
       }
   }
   ```

4. 新建NetworkUtils类

   获取网页源码

   ```java
   public class NetworkUtils {
       //log
       private static final String LOG_TAG = com.example.urlget.NetworkUtils.class.getSimpleName();
       static String getPageInfo(String urlstring){
           //connect internet
           HttpURLConnection urlConnection = null;
           BufferedReader reader = null;
           String webpage = null;
           try{
               URL requestURL=new URL(urlstring);
   
               //open url
               urlConnection=(HttpURLConnection) requestURL.openConnection();
               urlConnection.setRequestMethod("GET");
               urlConnection.connect();
               //response-ready
               InputStream inputStream=urlConnection.getInputStream();
               reader=new BufferedReader(new InputStreamReader(inputStream));
               StringBuilder builder=new StringBuilder();
               //response-resolve:read line-by-line
               String line;
               while ((line=reader.readLine())!=null){
   //                System.out.println("line"+line+"\n");
                   builder.append((line));
                   builder.append("\n");//only easy for debug
               }
               //check
               if (builder.length()==0){
                   return null;
               }
               //builder->string
               webpage=builder.toString();
   
           }
           catch (IOException e) {
               System.out.println("catch");
               e.printStackTrace();
           }
           finally {
               System.out.println("finally");
               //connection close
               if(urlConnection!=null){
                   urlConnection.disconnect();
               }
               //reader close
               if(reader!=null){
                   try {
                       reader.close();
                   }
                   catch (IOException e){
                       e.printStackTrace();
                   }
               }
           }
           Log.d(LOG_TAG,webpage);
           return webpage;
       }
   
   }
   ```

   



