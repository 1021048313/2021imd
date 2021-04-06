package com.example.sayhello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE=
            "com.example.android.showhello.extra.message";

    private int mCount;
    private TextView mShowCount;
    private Button mToastbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化mCount
        mCount=0;
        //找到id对应的tetview
        mShowCount=(TextView) findViewById(R.id.show_count);
        //找到showtoast对应的button
        mToastbutton=(Button) findViewById(R.id.button_toast);
    }

    public void showToast(View view) {
//        Toast toast=Toast.makeText(this,R.string.toast_message,Toast.LENGTH_SHORT);
//        toast.show();
        //测试点击该按钮
//        Log.d(LOG_TAG, "Button clicked!");
        //功能
        Intent intent=new Intent(this, showhello.class);
        //获取计数
        String message=Integer.toString(mCount);
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivity(intent);



    }

    public void countUp(View view) {
        mCount++;
        if (mShowCount!=null)
        {
            mShowCount.setText(Integer.toString(mCount));
        }
    }
}