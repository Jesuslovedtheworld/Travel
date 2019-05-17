package com.baidu.traveleverywhere.model;

import com.baidu.traveleverywhere.base.BaseModel;
import com.baidu.traveleverywhere.bean.BaiMiViewMoreBean;
import com.baidu.traveleverywhere.bean.DownBean;
import com.baidu.traveleverywhere.bean.HomeWeiBoBean;
import com.baidu.traveleverywhere.bean.UserMessageBean;
import com.baidu.traveleverywhere.net.BaseObserver;
import com.baidu.traveleverywhere.net.EveryApi;
import com.baidu.traveleverywhere.net.HttpUtils;
import com.baidu.traveleverywhere.net.ResultCallBack;
import com.baidu.traveleverywhere.net.RxUtils;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class HomeModel extends BaseModel {

    public void postData(int uid, final ResultCallBack<HomeWeiBoBean> resultCallBack) {

        EveryApi api = HttpUtils.getInstance().getApiserver(EveryApi.baimiUrl, EveryApi.class);
        Observable<HomeWeiBoBean> data = api.postWeiBoData(uid);
        data.subscribe(new BaseObserver<HomeWeiBoBean>() {
            @Override
            public void onNext(HomeWeiBoBean homeWeiBoBean) {
                    if (homeWeiBoBean != null){
                            resultCallBack.onSuccess(homeWeiBoBean);
                    }else {
                        resultCallBack.onFail(homeWeiBoBean.getDesc());
                    }
            }

            @Override
            public void error(String msg) {
                    resultCallBack.onFail("错误信息"+msg);
            }

            @Override
            protected void subscribe(Disposable d) {
                    addDisposable(d);
            }
        });
    }
    public void getUserMessage(String tokenContent, final ResultCallBack<UserMessageBean> resultCallBack) {
        EveryApi api = HttpUtils.getInstance().getApiserver(EveryApi.baimiUrl, EveryApi.class);
        final Observable<UserMessageBean> userMessage = api.getUserMessage(tokenContent);
        userMessage.compose(RxUtils.<UserMessageBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<UserMessageBean>() {
                    @Override
                    public void onNext(UserMessageBean userMessageBean) {
                        if (userMessage != null){
                            resultCallBack.onSuccess(userMessageBean);
                        }else {
                            resultCallBack.onFail(userMessageBean.getDesc());
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

    public void getBaiMiViewMore(String token, final ResultCallBack<BaiMiViewMoreBean> resultCallBack) {
        EveryApi api = HttpUtils.getInstance().getApiserver(EveryApi.baimiUrl, EveryApi.class);
        final Observable<BaiMiViewMoreBean> baiMiViewMore = api.getBaiMiViewMore(token);
        baiMiViewMore.compose(RxUtils.<BaiMiViewMoreBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<BaiMiViewMoreBean>() {
                    @Override
                    public void onNext(BaiMiViewMoreBean baiMiViewMoreBean) {
                            if (baiMiViewMoreBean != null){
                                resultCallBack.onSuccess(baiMiViewMoreBean);
                            }else {
                                resultCallBack.onFail(baiMiViewMoreBean.getDesc()+"");
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

    public void getVersion(String tokenContent, final ResultCallBack<DownBean> resultCallBack) {
        EveryApi api = HttpUtils.getInstance().getApiserver(EveryApi.baimiUrl, EveryApi.class);
        final Observable<DownBean> down = api.getDown(tokenContent);
        down.compose(RxUtils.<DownBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<DownBean>() {
                    @Override
                    public void onNext(DownBean downBean) {
                        if (downBean != null){
                            resultCallBack.onSuccess(downBean);
                        }else {
                            resultCallBack.onFail(downBean.getDesc());
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
