package com.baidu.traveleverywhere.model;

import com.baidu.traveleverywhere.base.BaseModel;
import com.baidu.traveleverywhere.bean.MyFollowBean;
import com.baidu.traveleverywhere.bean.MyFollowCollectionBean;
import com.baidu.traveleverywhere.net.BaseObserver;
import com.baidu.traveleverywhere.net.EveryApi;
import com.baidu.traveleverywhere.net.HttpUtils;
import com.baidu.traveleverywhere.net.ResultCallBack;
import com.baidu.traveleverywhere.net.RxUtils;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class MyCollectionModel extends BaseModel {
    private static final String TAG = "MyCollectionModel";
    public void getCollection(String token, int i, final ResultCallBack<MyFollowCollectionBean> resultCallBack) {
        EveryApi api = HttpUtils.getInstance().getApiserver(EveryApi.baimiUrl, EveryApi.class);
        Observable<MyFollowCollectionBean> observable = api.getCollection(token, i);
        observable.compose(RxUtils.<MyFollowCollectionBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<MyFollowCollectionBean>() {
                    @Override
                    public void onNext(MyFollowCollectionBean myCollectionBean) {
                        if (myCollectionBean != null){
                            resultCallBack.onSuccess(myCollectionBean);
                        }else{
                            resultCallBack.onFail(myCollectionBean.getDesc());
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

    public void getFollow(String token, int page, final ResultCallBack<MyFollowBean> resultCallBack) {
        EveryApi api = HttpUtils.getInstance().getApiserver(EveryApi.baimiUrl, EveryApi.class);
        Observable<MyFollowBean> followBean = api.getFollowBean(token, page);
        followBean.compose(RxUtils.<MyFollowBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<MyFollowBean>() {
                    @Override
                    public void onNext(MyFollowBean myFollowBean) {
                        if (myFollowBean != null){
                            resultCallBack.onSuccess(myFollowBean);
                        }else {
                            resultCallBack.onFail(myFollowBean.getDesc());
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
