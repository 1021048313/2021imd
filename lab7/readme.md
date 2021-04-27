# lab7 User navigation

## practice

### A

1. code challenge-设置预先选中的按钮

   - 修改layout

     在某个Button中增加`android:checked="true"`

   - java代码

     onCreate中增加

     ```java
     RadioButton first_button=findViewById(R.id.sameday);
     first_button.setChecked(true);
     ```

   code challenge-拨号功能

   ​	见项目文件DialNumber

   ​	关键代码

   ```java
   package com.example.dialnumber;
   
   import androidx.appcompat.app.AppCompatActivity;
   
   import android.content.Intent;
   import android.net.Uri;
   import android.os.Bundle;
   import android.util.Log;
   import android.view.KeyEvent;
   import android.view.inputmethod.EditorInfo;
   import android.widget.AdapterView;
   import android.widget.EditText;
   import android.widget.TextView;
   
   public class MainActivity extends AppCompatActivity {
   
       private static final String TAG ="Dial phone number" ;
   
       @Override
       protected void onCreate(Bundle savedInstanceState) {
           super.onCreate(savedInstanceState);
           setContentView(R.layout.activity_main);
           EditText editText = findViewById(R.id.phone_text);
           if (editText != null)
               editText.setOnEditorActionListener
                       (new TextView.OnEditorActionListener() {
                           @Override
                           public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                               boolean handled = false;
                               if (actionId == EditorInfo.IME_ACTION_SEND) {
                                   dialNumber();
                                   handled = true;
                               }
                               return handled;
                           }
   
                           // If view is found, set the listener for editText.
                       });
       }
       private void dialNumber() {
           // Find the editText_main view.
           EditText editText = findViewById(R.id.phone_text);
           String phoneNum = null;
           // If the editText field is not null,
           // concatenate "tel: " with the phone number string.
           if (editText != null) phoneNum = "tel:" +
                   editText.getText().toString();
           // Optional: Log the concatenated phone number for dialing.
           Log.d(TAG, "dialNumber: " + phoneNum);
           // Specify the intent.
           Intent intent = new Intent(Intent.ACTION_DIAL);
           // Set the data for the intent as the phone number.
           intent.setData(Uri.parse(phoneNum));
           // If the intent resolves to a package (app),
           // start the activity with the intent.
           startActivity(intent);
   //        if (intent.resolveActivity(getPackageManager()) != null) {
   //            startActivity(intent);
   //        } else {
   //            Log.d("ImplicitIntents", "Can't handle this!");
   //        }
       }
   }
   ```

录屏和截图见a命名的两个文件

### B

```xml
implementation 'com.android.support:design:26.1.0'
```

无法加入，采用自带的组件

录屏和截图见b命名的两个文件

### C

录屏和截图见c命名的两个文件