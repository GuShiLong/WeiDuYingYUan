package com.wd.tech.contract;

/**
 * @Author：谷世龙
 * @E-mail： 15001194794@163.com
 * @Date：2019/5/10 19:55
 * @Description：描述信息
 */
public interface ContractIntface {

    public interface UserIntface{
        public void showLogin(Object obj);

    }
    public interface RegisterIntface{
        public void showRegister (Object obj);
    }
    public interface PresenterIntface{
        public void toLogin(String phone,String pwd);
        public void toRegister(int sex,String birthday,String email,String nickName,String phone,String pwd,String pwd2);
        public void toShowHot(String url);
        public void toshowHotshowing(String url);
        public void toshowShangying(String url);
    }
    public interface FilmIntface{
        public void showHot(Object obj);
        public void showHotshowing(Object obj);
        public void showShangying(Object obj);
    }
}
