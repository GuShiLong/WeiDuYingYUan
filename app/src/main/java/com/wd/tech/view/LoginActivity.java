package com.wd.tech.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.wd.tech.R;
import com.wd.tech.app.App;
import com.wd.tech.bean.LoginBean;
import com.wd.tech.contract.ContractIntface;
import com.wd.tech.presenter.MyPresenter;
import com.wd.tech.util.EncryptUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements ContractIntface.UserIntface {

    @BindView(R.id.edit_phone)
    EditText editPhone;
    @BindView(R.id.edit_password)
    EditText editPassword;
    @BindView(R.id.image_yan)
    ImageView imageYan;
    @BindView(R.id.check_pwd)
    CheckBox checkPwd;
    @BindView(R.id.check_deng)
    CheckBox checkDeng;
    @BindView(R.id.text_zhuce)
    TextView textZhuce;
    @BindView(R.id.btn_login)
    Button btnLogin;

    boolean isHideFirst=true;
    ContractIntface.PresenterIntface presenterIntface;
    private SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        sp=getSharedPreferences("config",MODE_PRIVATE);
        presenterIntface=new MyPresenter<>(this);
        boolean flag = sp.getBoolean("flag", false);
        checkPwd.setChecked(flag);
        if(flag){
            String name = sp.getString("phone", "");
            String pwd = sp.getString("pwd", "");
            editPhone.setText(name);
            editPassword.setText(pwd);
        }
        imageYan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isHideFirst==true){
                    HideReturnsTransformationMethod instance = HideReturnsTransformationMethod.getInstance();
                    editPassword.setTransformationMethod(instance);
                    isHideFirst=false;
                }else{
                    PasswordTransformationMethod instance = PasswordTransformationMethod.getInstance();
                    editPassword.setTransformationMethod(instance);
                    isHideFirst=true;
                }
                int index = editPassword.getText().toString().length();
                editPassword.setSelection(index);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = editPhone.getText().toString();
                String pwd = editPassword.getText().toString();
                String encrypt = EncryptUtil.encrypt(pwd);
                presenterIntface.toLogin(phone,encrypt);
            }
        });
        textZhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void showLogin(Object obj) {
        LoginBean loginBean= (LoginBean) obj;
        String phone = editPhone.getText().toString();
        String pwd = editPassword.getText().toString();
        if(loginBean.getMessage().equals("登陆成功")){
            App.Phone=editPhone.getText().toString();
            App.Pwd=editPassword.getText().toString();
            App.SessionId= loginBean.getResult().getSessionId();
            App.UserId=loginBean.getResult().getUserId();
            App.Birthday=loginBean.getResult().getUserInfo().getBirthday();
            App.HeadPic=loginBean.getResult().getUserInfo().getHeadPic();
            App.LastLoginTime=loginBean.getResult().getUserInfo().getLastLoginTime();
            App.NickName=loginBean.getResult().getUserInfo().getNickName();
            App.Sex=loginBean.getResult().getUserInfo().getSex();

            SharedPreferences.Editor edit = sp.edit();
            if(checkPwd.isChecked()){
                edit.putString("phone",phone);
                edit.putString("pwd",pwd);
                edit.putBoolean("flag",true);
            }else{
                edit.clear();
            }
            edit.commit();
            Intent intent=new Intent(LoginActivity.this,ShowActivity.class);
            startActivity(intent);
            finish();
        }else{
            Toast.makeText(LoginActivity.this,obj.toString(),Toast.LENGTH_LONG);
        }
    }

}
