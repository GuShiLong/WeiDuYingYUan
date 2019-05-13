package com.wd.tech;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.wd.tech.view.GuidanceActivity;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayout;
    int time=2;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            time--;
            if(time==0){
                Intent intent=new Intent(MainActivity.this,GuidanceActivity.class);
                startActivity(intent);
                finish();
                handler.removeMessages(0);
            }
            handler.sendEmptyMessageDelayed(0,1000);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout=findViewById(R.id.linear_start);

//        linearLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
        handler.sendEmptyMessageDelayed(0,1000);
    }
}
