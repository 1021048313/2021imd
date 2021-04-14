package com.example.droidcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

public class OrderActivity extends AppCompatActivity {
    private static final String TAG = "getintent";
    //    声明
    private TextView showorder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        showorder=findViewById(R.id.showorder);
        Intent intent = getIntent();
        String orderlist=intent.getStringExtra("orderlist");
        showorder.setText(orderlist);

    }
}