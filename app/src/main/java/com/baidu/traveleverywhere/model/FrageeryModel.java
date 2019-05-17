package com.baidu.traveleverywhere.model;

import android.util.Log;

import com.baidu.traveleverywhere.base.BaseModel;
import com.baidu.traveleverywhere.bean.BaiMiDetailedTreadBean;
import com.baidu.traveleverywhere.bean.BaiMiDetailedbean;
import com.baidu.traveleverywhere.bean.HomeBaimiFollow;
import com.baidu.traveleverywhere.bean.HomeEveryBean;
import com.baidu.traveleverywhere.bean.LookAllBean;
import com.baidu.traveleverywhere.net.BaseObserver;
import com.baidu.traveleverywhere.net.EveryApi;
import com.baidu.traveleverywhere.net.HttpUtils;
import com.baidu.traveleverywhere.net.ResultCallBack;
import com.baidu.traveleverywhere.net.RxUtils;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class FrageeryModel extends BaseModel {

    public void getBaiMiList(String token, int page, final ResultCallBack<HomeEveryBean> resultCallBack) {
         EveryApi api = HttpUtils.getInstance().getApiserver(EveryApi.baimiUrl, EveryApi.class);
         Observable<HomeEveryBean> baiMiList = api.getBaiMiList(token, page);
         baiMiList.compose(RxUtils.<HomeEveryBean>rxObserableSchedulerHelper())
                 .subscribe(new BaseObserver<HomeEveryBean>() {
                     @Override
                     public void onNext(HomeEveryBean homeEveryBean) {
                            if (homeEveryBean != null){
                                resultCallBack.onSuccess(homeEveryBean);
                            }else {
                                resultCallBack.onFail(homeEveryBean.getDesc());
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

    //收藏
    public void homeFollow(int id, String token, final ResultCallBack<HomeBaimiFollow> resultCallBack) {
        EveryApi api = HttpUtils.getInstance().getApiserver(EveryApi.baimiUrl, EveryApi.class);
        Observable<HomeBaimiFollow> follow = api.postBaimiFollow(id, token);
        follow.compose(RxUtils.<HomeBaimiFollow>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<HomeBaimiFollow>() {
                    @Override
                    public void onNext(HomeBaimiFollow homeBaimiFollow) {
                        if (homeBaimiFollow != null){
                            resultCallBack.onSuccess(homeBaimiFollow);
                        }else {
                            resultCallBack.onFail(homeBaimiFollow.getDesc());
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
    //取消收藏
    public void homeUnFollow(int id, String token, final ResultCallBack<HomeBaimiFollow> resultCallBack) {
        EveryApi api = HttpUtils.getInstance().getApiserver(EveryApi.baimiUrl, EveryApi.class);
        Observable<HomeBaimiFollow> follow = api.postBaimiUnFollow(id, token);
        follow.compose(RxUtils.<HomeBaimiFollow>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<HomeBaimiFollow>() {
                    @Override
                    public void onNext(HomeBaimiFollow homeBaimiFollow) {
                        if (homeBaimiFollow != null){
                            resultCallBack.onSuccess(homeBaimiFollow);
                        }else {
                            resultCallBack.onFail(homeBaimiFollow.getDesc());
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

    //获取伴米详情界面数据
    public void getBaiMiDetailed(String token, int detailedId,final ResultCallBack<BaiMiDetailedbean> resultCallBack) {
        EveryApi api = HttpUtils.getInstance().getApiserver(EveryApi.baimiUrl, EveryApi.class);
        Observable<BaiMiDetailedbean> baiMiDetailed = api.getBaiMiDetailed(token, detailedId);
        baiMiDetailed.compose(RxUtils.<BaiMiDetailedbean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<BaiMiDetailedbean>() {
                    @Override
                    public void onNext(BaiMiDetailedbean baiMiDetailedbean) {
                        if (baiMiDetailedbean != null){
                            resultCallBack.onSuccess(baiMiDetailedbean);
                        }else {
                            resultCallBack.onFail(baiMiDetailedbean.getDesc());
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

    public void getLookAll(String tokenContent, int mId, int page, final ResultCallBack<LookAllBean> resultCallBack) {
        EveryApi api = HttpUtils.getInstance().getApiserver(EveryApi.baimiUrl, EveryApi.class);
        Observable<LookAllBean> baiMiTread = api.getBaiMiTread(tokenContent, mId, page);
        baiMiTread.compose(RxUtils.<LookAllBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<LookAllBean>() {
                    @Override
                    public void onNext(LookAllBean lookAllBean) {
                            if (lookAllBean != null){
                                    resultCallBack.onSuccess(lookAllBean);
                            }else {
                                resultCallBack.onFail(lookAllBean.getDesc());
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
