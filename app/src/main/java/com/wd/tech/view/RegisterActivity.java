package com.wd.tech.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wd.tech.R;

public class RegisterActivity extends AppCompatActivity {

    int sexI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        String sex = "男";
        if(sex.equals("男")){
            sexI=0;
        }else{
            sexI=1;
        }

    }
}
