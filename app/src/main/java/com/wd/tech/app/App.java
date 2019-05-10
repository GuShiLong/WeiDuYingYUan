package com.wd.tech.app;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * @Author：谷世龙
 * @E-mail： 15001194794@163.com
 * @Date：2019/5/10 19:58
 * @Description：描述信息
 */
public class App extends Application {
    public static   Context context;
    public static String NickName;
    public static String HeadPic;
    public static int Sex;
    public static String Phone;
    public static String Pwd;
    public static Long LastLoginTime;
    public static int UserId;
    public static String SessionId;
    public static Long Birthday;
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
