package com.baidu.traveleverywhere.model;

import android.util.Log;

import com.baidu.traveleverywhere.base.BaseModel;
import com.baidu.traveleverywhere.bean.CollectionOrClierBean;
import com.baidu.traveleverywhere.bean.HomeInfomation;
import com.baidu.traveleverywhere.net.BaseObserver;
import com.baidu.traveleverywhere.net.EveryApi;
import com.baidu.traveleverywhere.net.HomeInfoCallBack;
import com.baidu.traveleverywhere.net.HttpUtils;
import com.baidu.traveleverywhere.net.ResultCallBack;
import com.baidu.traveleverywhere.net.RxUtils;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeInfoModel extends BaseModel {
    private static final String TAG = "HomeInfoModel";

    public void getHomeInfoData(int id, String token, final HomeInfoCallBack homeInfoCallBack) {
        EveryApi api = HttpUtils.getInstance().getApiserver(EveryApi.baimiUrl, EveryApi.class);
        final Observable<HomeInfomation> homeInfoData = api.getHomeInfoData(id, token);
        homeInfoData.compose(RxUtils.<HomeInfomation>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<HomeInfomation>() {
                    @Override
                    public void onNext(HomeInfomation homeInfomation) {
                        if (homeInfoData != null){
                            Log.e(TAG, "HomeInfoModel: "+homeInfoData);
                            homeInfoCallBack.onSuccess(homeInfomation);
                        }
                    }

                    @Override
                    public void error(String msg) {
                        homeInfoCallBack.onFail(msg);
                    }

                    @Override
                    protected void subscribe(Disposable d) {
                        addDisposable(d);
                    }
                });



            //two(id,token,ResultCallBack);
    }
    private void two(int id, String token, final ResultCallBack<HomeInfomation> ResultCallBack) {
        Log.e(TAG, "two: 方法走了");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(EveryApi.baimiUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        EveryApi api = retrofit.create(EveryApi.class);
        Observable<HomeInfomation> homeInfoData = api.getHomeInfoData(id, token);
        homeInfoData.observeOn(Schedulers.io())
                    .subscribeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<HomeInfomation>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HomeInfomation homeInfomation) {
                        if (homeInfomation != null){
                            Log.e(TAG, "HomeInfoModel: "+homeInfomation);
                            ResultCallBack.onSuccess(homeInfomation);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        ResultCallBack.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void postCollection(int id, String token, final ResultCallBack<CollectionOrClierBean> resultCallBack) {
        EveryApi api = HttpUtils.getInstance().getApiserver(EveryApi.baimiUrl, EveryApi.class);
        final Observable<CollectionOrClierBean> collection = api.postCollection(id, token);
        collection.compose(RxUtils.<CollectionOrClierBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<CollectionOrClierBean>() {
                    @Override
                    public void onNext(CollectionOrClierBean collectionOrClierBean) {
                        if (collectionOrClierBean != null){
                                resultCallBack.onSuccess(collectionOrClierBean);
                        }else {
                            resultCallBack.onFail("收藏失败");
                        }
                    }

                    @Override
                    public void error(String msg) {
                        resultCallBack.onFail("收藏失败");
                    }

                    @Override
                    protected void subscribe(Disposable d) {
                        addDisposable(d);
                    }
                });

    }

    public void postUnCollection(int id, String token, final ResultCallBack<CollectionOrClierBean> resultCallBack) {
        EveryApi api = HttpUtils.getInstance().getApiserver(EveryApi.baimiUrl, EveryApi.class);
        final Observable<CollectionOrClierBean> collection = api.postCollection(id, token);
        collection.compose(RxUtils.<CollectionOrClierBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<CollectionOrClierBean>() {
                    @Override
                    public void onNext(CollectionOrClierBean collectionOrClierBean) {
                        if (collectionOrClierBean != null){
                            resultCallBack.onSuccess(collectionOrClierBean);
                        }else {
                            resultCallBack.onFail("收藏失败");
                        }
                    }

                    @Override
                    public void error(String msg) {
                        resultCallBack.onFail("收藏失败");
                    }

                    @Override
                    protected void subscribe(Disposable d) {
                        addDisposable(d);
                    }
                });
    }
}
