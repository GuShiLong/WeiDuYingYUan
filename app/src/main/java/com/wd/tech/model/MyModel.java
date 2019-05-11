package com.wd.tech.model;

import com.google.gson.Gson;
import com.wd.tech.app.UrlAll;
import com.wd.tech.bean.LoginBean;
import com.wd.tech.bean.RegisterBean;
import com.wd.tech.util.OkHttpUtil;

import java.io.IOException;

import okhttp3.ResponseBody;
import rx.Observer;

/**
 * @Author：谷世龙
 * @E-mail： 15001194794@163.com
 * @Date：2019/5/10 20:09
 * @Description：描述信息
 */
public class MyModel {

    MyCallLogin myCallLogin;
    MyCallRegister myCallRegister;
    public void postLogin1(String phone,String pwd){
        OkHttpUtil util=OkHttpUtil.getInster();
        util.postData(UrlAll.URL_LOGIN, phone, pwd, new Observer<ResponseBody>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(ResponseBody responseBody) {
                try {
                    String s = responseBody.string();
                    Gson gson = new Gson();
                    LoginBean loginBean = gson.fromJson(s, LoginBean.class);
                    myCallLogin.success(loginBean);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void postZhuce(int sex,String birthday,String email,String nickName,String phone,String pwd,String pwd2){
        OkHttpUtil util=OkHttpUtil.getInster();
        util.postRegister(UrlAll.URL_REGISTER, sex, birthday, email, nickName, phone, pwd, pwd2, new OkHttpUtil.RetrofigIntface() {
            @Override
            public void success(Object obj) {
                String o= (String) obj;
                Gson gson = new Gson();
                RegisterBean registerBean = gson.fromJson(o, RegisterBean.class);
                myCallRegister.success(registerBean);
            }
        });
    }
    public void setMyCallRegister(MyCallRegister myCallRegister) {
        this.myCallRegister = myCallRegister;
    }

    public void setMyCallLogin(MyCallLogin myCallLogin) {
        this.myCallLogin = myCallLogin;
    }

    public interface MyCallLogin{
        public void success(Object obj);
    }
    public interface MyCallRegister{
        public void success(Object obj);
    }
}
