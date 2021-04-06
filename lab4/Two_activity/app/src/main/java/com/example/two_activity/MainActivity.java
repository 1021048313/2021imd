package com.example.two_activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    //Intent extra
    public static final String EXTRA_MESSAGE=
            "com.example.android.twoactivity.extra.message";
    //EditText
    private EditText mMessageEditText;
    //reply message from another activity
    public static final int TEXT_REQUEST=1;
    private TextView mReplyHeadTextView;
    private TextView mReplyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //找到EditText
        mMessageEditText=findViewById(R.id.editText_main);
        //找到两个replyTextView
        mReplyHeadTextView=findViewById(R.id.text_header_reply);
        mReplyTextView=findViewById(R.id.text_message_reply);


    }

    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent=new Intent(this, SecondActivity.class);
        //get input message
        String message=mMessageEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivityForResult(intent,TEXT_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply=data.getStringExtra(SecondActivity.EXTRA_REPLY);
                //修改visibility
                mReplyTextView.setVisibility(View.VISIBLE);
                mReplyHeadTextView.setVisibility(View.VISIBLE);
                mReplyTextView.setText(reply);
                //清空原来下面的文本框
                mMessageEditText.setText("");
            }
        }
    }
}