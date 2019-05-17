package com.baidu.traveleverywhere.model;

import android.util.Log;

import com.baidu.traveleverywhere.base.BaseModel;
import com.baidu.traveleverywhere.bean.HomeListData;
import com.baidu.traveleverywhere.bean.UpUserMessageBean;
import com.baidu.traveleverywhere.bean.UserMessageBean;
import com.baidu.traveleverywhere.net.BaseObserver;
import com.baidu.traveleverywhere.net.EveryApi;
import com.baidu.traveleverywhere.net.HttpUtils;
import com.baidu.traveleverywhere.net.ResultCallBack;
import com.baidu.traveleverywhere.net.RxUtils;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class FragHomeModel extends BaseModel {
    private static final String TAG = "FragHomeModel";

    public void getHomeListData(String token,int page, final ResultCallBack<HomeListData> resultCallBack) {
        two(token,page,resultCallBack);

    }

    private void two(String token, int page,final ResultCallBack<HomeListData> resultCallBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(EveryApi.baimiUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        EveryApi api = retrofit.create(EveryApi.class);
        Observable<HomeListData> list = api.getWeiBoList(token,page);
        list.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomeListData>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HomeListData homeListData) {
                        Log.e(TAG, "回来的数据"+homeListData );
                        if (homeListData != null){
                            resultCallBack.onSuccess(homeListData);
                        }else {
                            resultCallBack.onFail(homeListData.getDesc());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        resultCallBack.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void postUpUserMessage(String tokenContent, Map map, final ResultCallBack<UpUserMessageBean> resultCallBack) {
        EveryApi api = HttpUtils.getInstance().getApiserver(EveryApi.baimiUrl, EveryApi.class);
        Observable<UpUserMessageBean> observable = api.postUpUserMessage(tokenContent, map);
        observable.compose(RxUtils.<UpUserMessageBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<UpUserMessageBean>() {
                    @Override
                    public void onNext(UpUserMessageBean upUserMessage) {
                            if (upUserMessage != null){
                                    resultCallBack.onSuccess(upUserMessage);
                            }else{
                                resultCallBack.onFail("上传失败");
                            }
                    }

                    @Override
                    public void error(String msg) {
                        resultCallBack.onFail(msg);
                    }

                    @Override
                    protected void subscribe(Disposable d) {
                        addDisposable(d);
                    }
                });


    }


}
