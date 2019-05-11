package com.wd.tech.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.wd.tech.R;
import com.wd.tech.bean.RegisterBean;
import com.wd.tech.contract.ContractIntface;
import com.wd.tech.presenter.MyPresenter;
import com.wd.tech.util.EncryptUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterActivity extends AppCompatActivity implements ContractIntface.RegisterIntface {

    @BindView(R.id.register_ni)
    EditText registerNi;
    @BindView(R.id.register_xing)
    EditText registerXing;
    @BindView(R.id.register_chu)
    EditText registerChu;
    @BindView(R.id.register_phone)
    EditText registerPhone;
    @BindView(R.id.register_youx)
    EditText registerYoux;
    @BindView(R.id.register_pwd)
    EditText registerPwd;
    @BindView(R.id.btn_register)
    Button btnRegister;

    ContractIntface.PresenterIntface presenterIntface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        presenterIntface=new MyPresenter<>(this);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ni = registerNi.getText().toString();
                String chu = registerChu.getText().toString();
                String phone = registerPhone.getText().toString();
                String pwd = registerPwd.getText().toString();
                String xing = registerXing.getText().toString();
                String youx = registerYoux.getText().toString();

                String encrypt = EncryptUtil.encrypt(pwd);
                presenterIntface.toRegister(Integer.parseInt(xing),chu,youx,ni,phone,encrypt,encrypt);
            }
        });
    }

    @Override
    public void showRegister(Object obj) {
        RegisterBean registerBean= (RegisterBean) obj;
        if(registerBean.getMessage().equals("注册成功")){
            Toast.makeText(RegisterActivity.this,obj.toString(),Toast.LENGTH_LONG).show();
        }
    }
}
