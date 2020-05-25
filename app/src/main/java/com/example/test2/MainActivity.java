package com.example.test2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * 作业2：一个抖音笔试题：统计页面所有view的个数
 * Tips：ViewGroup有两个API
 * {@link android.view.ViewGroup #getChildAt(int) #getChildCount()}
 * 用一个TextView展示出来
 */
public class MainActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv1);
        tv.setText("There're " +Integer.toString(getAllChildViewCount(findViewById(R.id.root))) + " views.");
    }

    public int getAllChildViewCount(View view) {
        //todo 补全你的代码
        int n = 0;
        if(view == null){
            return 0;
        }
        else{
            if(view instanceof ViewGroup){
                n++;
                for(int i = 0; i < ((ViewGroup)view).getChildCount(); i++){
                    View son = ((ViewGroup)view).getChildAt(i);
                    if(son instanceof ViewGroup){
                        n += getAllChildViewCount(son);
                    }
                    else{
                        n++;
                    }
                }
            }
        }
        return n;
    }

}
