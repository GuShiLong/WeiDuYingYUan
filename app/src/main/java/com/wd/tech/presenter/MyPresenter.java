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
        myModel.postLogin1(phone,pwd);
    }

    @Override
    public void toRegister(int sex,String birthday,String email,String nickName,String phone,String pwd,String pwd2) {
        myModel.setMyCallRegister(new MyModel.MyCallRegister() {
            @Override
            public void success(Object obj) {
                ContractIntface.RegisterIntface registerIntface= (ContractIntface.RegisterIntface) view;
                registerIntface.showRegister(obj);
            }
        });
        myModel.postZhuce(sex, birthday, email, nickName, phone, pwd, pwd2);
    }
}
