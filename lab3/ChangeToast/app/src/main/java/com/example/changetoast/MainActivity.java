package com.example.changetoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int mCount;
    private TextView mShowCount;
    private Button zeroBtn,countBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化mCount
        mCount=0;
        //找到id对应的tetview
        mShowCount=(TextView) findViewById(R.id.show_count);
        //zero 按钮
        zeroBtn=(Button) findViewById(R.id.button_zero);
        //count按钮
        countBtn=(Button) findViewById(R.id.button_count);
    }

    public void showToast(View view) {
        Toast toast=Toast.makeText(this,R.string.toast_message,Toast.LENGTH_SHORT);
        toast.show();

    }

    public void countUp(View view) {
        mCount++;
        //根据mCount改变按钮颜色
        if (mCount%2==0)
        {
            countBtn.setBackgroundColor(getResources().getColor(R.color.teal_200));
        }
        else {
            countBtn.setBackgroundColor(getResources().getColor(R.color.black));
        }
        if (mCount>0)
        {
            zeroBtn.setBackgroundColor(getResources().getColor(R.color.purple_200));
        }
        if (mShowCount!=null)
        {
            mShowCount.setText(Integer.toString(mCount));
        }
    }

    public void changezero(View view) {
        mCount=0;
        zeroBtn.setBackgroundColor(getResources().getColor(R.color.gray));
        if (mShowCount!=null)
        {
            mShowCount.setText(Integer.toString(mCount));
        }



    }
}