package com.wd.tech.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.wd.tech.R;
import com.wd.tech.adapter.MyViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class GuidanceActivity extends AppCompatActivity {

    ViewPager viewPager;
    Button btn_start;
    List<Integer> list=new ArrayList<>();
    MyViewAdapter adapter;
    private SharedPreferences sp;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.what==0){
                int i = viewPager.getCurrentItem();
                i++;
                viewPager.setCurrentItem(i);
                handler.sendEmptyMessageDelayed(0,1500);
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guidance);
        sp=getSharedPreferences("config",MODE_PRIVATE);
        boolean flag = sp.getBoolean("flag", false);
        if(flag){
            Intent intent=new Intent(GuidanceActivity.this,LoginActivity.class);
            startActivity(intent);
            finish();
        }
        viewPager=findViewById(R.id.view_guidance);
        btn_start=findViewById(R.id.btn_start);

        list.add(R.mipmap.yindao1);
        list.add(R.mipmap.yindao2);
        list.add(R.mipmap.yindao3);
        list.add(R.mipmap.yindao4);

        adapter=new MyViewAdapter(list, this);
        viewPager.setAdapter(adapter);
        //viewPager.setCurrentItem(list.size()*1000);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if(list.size()-1==position){
                    btn_start.setVisibility(View.VISIBLE);
                }else{
                    btn_start.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        handler.sendEmptyMessageDelayed(0,1500);
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(GuidanceActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();

                SharedPreferences.Editor edit = sp.edit();
                edit.putBoolean("flag",true);
                edit.commit();
            }
        });
    }
}
