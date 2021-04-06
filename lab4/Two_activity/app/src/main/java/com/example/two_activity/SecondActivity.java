package com.example.two_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY=
            "com.example.android.twoactivities.extra.REPLY";
    private EditText mReply;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //activate the activity
        Intent intent=getIntent();
        //get string from Intent extras
        String message=intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        //find TextView
        TextView textView=findViewById(R.id.text_message);
        textView.setText(message);



    }

    public void returnReply(View view) {
        //找到文本框
        mReply=findViewById(R.id.editText_second);
        //文本转换
        String reply=mReply.getText().toString();
        //reply的intent
        Intent replytIntent=new Intent();
        replytIntent.putExtra(EXTRA_REPLY,reply);
        //result
        setResult(RESULT_OK,replytIntent);
        //回到mainactivity
        finish();
    }
}