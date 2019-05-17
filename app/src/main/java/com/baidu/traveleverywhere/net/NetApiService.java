package com.baidu.traveleverywhere.net;

/*
* *  author gme
*    time 2019年5月4日16:48:51
*/

import com.baidu.traveleverywhere.bean.LoginVerifyCodeBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface NetApiService {

    /*
    * 获取验证码接口
    * */
    String verityCodeUrl = "http://yun918.cn/study/public/index.php/";

    @GET("verify")
    Observable<LoginVerifyCodeBean> getVerifyCode();

}
