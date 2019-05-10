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
        public void toRegister(String phone,String pwd);
    }
}
