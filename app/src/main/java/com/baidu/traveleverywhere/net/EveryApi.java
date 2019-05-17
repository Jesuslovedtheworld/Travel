package com.baidu.traveleverywhere.net;

import com.baidu.traveleverywhere.bean.BaiMiDetailedbean;
import com.baidu.traveleverywhere.bean.BaiMiViewMoreBean;
import com.baidu.traveleverywhere.bean.CollectionOrClierBean;
import com.baidu.traveleverywhere.bean.DownBean;
import com.baidu.traveleverywhere.bean.HomeBaimiFollow;
import com.baidu.traveleverywhere.bean.HomeEveryBean;
import com.baidu.traveleverywhere.bean.HomeInfomation;
import com.baidu.traveleverywhere.bean.HomeListData;
import com.baidu.traveleverywhere.bean.HomeWeiBoBean;
import com.baidu.traveleverywhere.bean.LookAllBean;
import com.baidu.traveleverywhere.bean.MyFollowBean;
import com.baidu.traveleverywhere.bean.MyFollowCollectionBean;
import com.baidu.traveleverywhere.bean.TwoUpFollowCity;
import com.baidu.traveleverywhere.bean.UpUserMessageBean;
import com.baidu.traveleverywhere.bean.UserMessageBean;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface EveryApi {

    String baimiUrl = "http://api.banmi.com/";

    @POST("api/3.0/account/login/oauth")
    @FormUrlEncoded
    Observable<HomeWeiBoBean> postWeiBoData(@Field("oAuthToken") int uid);


    @GET("api/3.0/content/routesbundles?")
    Observable<HomeListData> getWeiBoList(@Header("banmi-app-token") String tokey,@Query("page") int page);


    @GET("api/3.0/banmi")
    Observable<HomeEveryBean> getBaiMiList(@Header("banmi-app-token") String token, @Query("page") int page);


    @GET("api/3.0/content/routes/{routeId}")
    Observable<HomeInfomation> getHomeInfoData(@Path("routeId") int id,@Header("banmi-app-token") String token);


    @POST("api/3.0/account/updateInfo")
    Observable<Object> postUpdateData(@FieldMap Map<String,String> map);


    @GET("api/3.0/content/routes/{routeId}/like")
    Observable<CollectionOrClierBean> postCollection(@Path("routeId") int id,@Header("banmi-app-token") String token);


    @POST("api/3.0/banmi/{banmiId}/follow")
    Observable<HomeBaimiFollow> postBaimiFollow(@Path("banmiId") int id,@Header("banmi-app-token") String token);


    @POST("api/3.0/banmi/{banmiId}/unfollow")
    Observable<HomeBaimiFollow> postBaimiUnFollow(@Path("banmiId") int id,@Header("banmi-app-token") String token);



    @GET("api/3.0/account/collectedRoutes?")
    Observable<MyFollowCollectionBean> getCollection(@Header("banmi-app-token") String token, @Query("page") int page);

    @GET("api/3.0/account/followedBanmi")
    Observable<MyFollowBean> getFollowBean(@Header("banmi-app-token") String token,@Query("page") int page);


    @GET("api/3.0/banmi/{banmiId}")
    Observable<BaiMiDetailedbean> getBaiMiDetailed(@Header("banmi-app-token") String token,@Path("banmiId") int id);

    @GET("api/3.0/content/routes/{routeId}/reviews")
    Observable<LookAllBean> getBaiMiTread(@Header("banmi-app-token") String token, @Path("routeId") int id, @Query("page") int page);


    @POST("api/3.0/account/updateInfo")
    @FormUrlEncoded
    Observable<UpUserMessageBean> postUpUserMessage(@Header("banmi-app-token") String token, @FieldMap Map<String,String> map);


    @GET("api/3.0/account/info")
    Observable<UserMessageBean> getUserMessage(@Header("banmi-app-token") String token);


    @GET("api/3.0/content/bundles")
    Observable<BaiMiViewMoreBean> getBaiMiViewMore(@Header("banmi-app-token") String token);


    @GET("api/app/common/getVersionInfo?operating_system=android")
    Observable<DownBean> getDown(@Header("banmi-app-token") String token);


    String downUrl = "http://cdn.banmi.com/";//下载链接
    @GET("banmiapp/apk/banmi_333.apk")
    Observable<ResponseBody> Grende();


    //Observable<TwoUpFollowCity>

}
