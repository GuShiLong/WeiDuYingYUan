package com.wd.tech.model;

import com.wd.tech.app.UrlAll;
import com.wd.tech.bean.LoginBean;
import com.wd.tech.util.OkHttpUtil;

import rx.Observer;

/**
 * @Author：谷世龙
 * @E-mail： 15001194794@163.com
 * @Date：2019/5/10 20:09
 * @Description：描述信息
 */
public class MyModel {

    MyCallLogin myCallLogin;
    public void postLogin(String phone,String pwd){
        OkHttpUtil util=OkHttpUtil.getInster();
        util.postData(UrlAll.URL_LOGIN, phone, pwd, new Observer<LoginBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(LoginBean loginBean) {
                myCallLogin.success(loginBean);
            }
        });
    }

    public void setMyCallLogin(MyCallLogin myCallLogin) {
        this.myCallLogin = myCallLogin;
    }

    public interface MyCallLogin{
        public void success(Object obj);
    }
}
