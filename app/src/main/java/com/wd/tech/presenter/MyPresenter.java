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

    @Override
    public void toShowHot(String url) {
        myModel.setMyCallBack1(new MyModel.MyCallBack1() {
            @Override
            public void success(Object obj) {
                ContractIntface.FilmIntface filmIntface= (ContractIntface.FilmIntface) view;
                filmIntface.showHot(obj);
            }
        });
        myModel.getRemen(url);
    }

    @Override
    public void toshowHotshowing(String url) {
        myModel.setMyCallBack2(new MyModel.MyCallBack2() {
            @Override
            public void success(Object obj) {
                ContractIntface.FilmIntface filmIntface= (ContractIntface.FilmIntface) view;
                filmIntface.showHotshowing(obj);
            }
        });
        myModel.getReYing(url);
    }

    @Override
    public void toshowShangying(String url) {
        myModel.setMyCallBack3(new MyModel.MyCallBack3() {
            @Override
            public void success(Object obj) {
                ContractIntface.FilmIntface filmIntface= (ContractIntface.FilmIntface) view;
                filmIntface.showShangying(obj);
            }
        });
        myModel.getJiJiang(url);
    }
}
