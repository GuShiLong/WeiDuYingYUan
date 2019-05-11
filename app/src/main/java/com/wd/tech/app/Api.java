package com.wd.tech.app;

import com.wd.tech.bean.LoginBean;

import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;

/**
 * @Author：谷世龙
 * @E-mail： 15001194794@163.com
 * @Date：2019/5/10 19:57
 * @Description：描述信息
 */
public interface Api {

    @FormUrlEncoded
    @POST
    public Observable<ResponseBody> postLogin(@Url String url, @FieldMap Map<String,String> map);

    @FormUrlEncoded
    @POST
    public Observable<ResponseBody> postRegist(@Url String url, @Field("sex") int sex,@Field("birthday") String birthday,@Field("email") String email,@Field("nickName") String nickName,@Field("phone") String phone,@Field("pwd") String pwd,@Field("pwd2") String pwd2);

    //@POST
    //public  Observable<ResponseBody> post (@Url String url,@Query(""))

//    @POST
//    public Observable<ResponseBody> post(@Url String url, @QueryMap Map<String,String> map);

}
