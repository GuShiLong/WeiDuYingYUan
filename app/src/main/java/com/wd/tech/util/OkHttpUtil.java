package com.wd.tech.util;

import com.wd.tech.app.Api;
import com.wd.tech.app.UrlAll;
import com.wd.tech.bean.LoginBean;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @Author：谷世龙
 * @E-mail： 15001194794@163.com
 * @Date：2019/5/10 19:58
 * @Description：描述信息
 */
public class OkHttpUtil {
    static OkHttpUtil util;
    private final Api api;
    OkHttpClient okHttpClient;
    private Retrofit retrofit;
    private OkHttpUtil(){
        okHttpClient=new OkHttpClient.Builder().addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build();
        retrofit=new Retrofit.Builder()
                .baseUrl(UrlAll.URL_ZHU)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .callFactory(okHttpClient)
                .build();
        api=retrofit.create(Api.class);
    }
    public static synchronized OkHttpUtil getInster(){
        if(util==null){
            util=new OkHttpUtil();
        }
        return util;
    }

    public void postData(String url, String phone, String pwd, Observer<LoginBean> observer){
        HashMap<String, String> map = new HashMap<>();
        map.put("phone",phone);
        map.put("pwd",pwd);
        Observable<LoginBean> login = api.postLogin(url, map);
        login.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

    public Observer getRetrofig(final RetrofigIntface retrofigIntface){
        Observer o= new Observer<ResponseBody>() {
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
                    retrofigIntface.success(s);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        return o;
    }
    public interface RetrofigIntface{
        public void success(Object obj);
    }
}
