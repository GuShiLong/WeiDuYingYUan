package com.wd.tech.presenter;

import com.wd.tech.contract.ContractIntface;
import com.wd.tech.model.MyModel;

/**
 * @Author：谷世龙
 * @E-mail： 15001194794@163.com
 * @Date：2019/5/10 20:11
 * @Description：描述信息
 */
public class MyPresenter<T> implements ContractIntface.PresenterIntface {

    MyModel myModel;
    T view;

    public MyPresenter(T view) {
        this.view = view;
        myModel=new MyModel();
    }

    @Override
    public void toLogin(String phone, String pwd) {
        myModel.setMyCallLogin(new MyModel.MyCallLogin() {
            @Override
            public void success(Object obj) {
                ContractIntface.UserIntface userIntface= (ContractIntface.UserIntface) view;
                userIntface.showLogin(obj);
            }
        });
        myModel.postLogin(phone,pwd);
    }

    @Override
    public void toRegister(String phone, String pwd) {

    }
}
