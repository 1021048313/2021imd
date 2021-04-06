package com.example.sayhello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class showhello extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showhello);
        //activate the activity
        Intent intent=getIntent();
        //get string from Intent extras
        String message=intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        //find TextView
        TextView textView=findViewById(R.id.number_message);
        textView.setText(message);
    }
}