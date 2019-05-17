package com.baidu.traveleverywhere.model;

import com.baidu.traveleverywhere.base.BaseModel;
import com.baidu.traveleverywhere.bean.LoginInfo;
import com.baidu.traveleverywhere.bean.LoginVerifyCodeBean;
import com.baidu.traveleverywhere.net.BaseObserver;
import com.baidu.traveleverywhere.net.EveryWhereService;
import com.baidu.traveleverywhere.net.HttpUtils;
import com.baidu.traveleverywhere.net.NetApiService;
import com.baidu.traveleverywhere.net.ResultCallBack;
import com.baidu.traveleverywhere.net.RxUtils;
import com.baidu.traveleverywhere.utils.Logger;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class LoginModel extends BaseModel {
    private static final String TAG = "LoginModel";

    public static void loginSina(String uid, final ResultCallBack<LoginInfo> resultCallBack) {
        one(uid, resultCallBack);
    }
    private static void one(String uid, final ResultCallBack<LoginInfo> resultCallBack) {
        EveryWhereService apiserver = HttpUtils.getInstance().getApiserver(EveryWhereService.BASE_URL, EveryWhereService.class);
        apiserver.postWeiboLogin(uid)
                .compose(RxUtils.<LoginInfo>rxObserableSchedulerHelper())
                    .subscribe(new BaseObserver<LoginInfo>() {
                        @Override
                        public void onNext(LoginInfo loginInfo) {
                                if (loginInfo != null){
                                    if (loginInfo.getCode() == EveryWhereService.SUCCESS_CODE){
                                        resultCallBack.onSuccess(loginInfo);
                                    }else {
                                        resultCallBack.onFail(loginInfo.getDesc());
                                    }

                                }
                        }

                        @Override
                        public void error(String msg) {
                            if (msg != null){
                                resultCallBack.onFail(msg);
                            }

                        }

                        @Override
                        protected void subscribe(Disposable d) {
                            //todo 需要将model放入集合中去
                        }
                    });
    }

    public void getVerifyCode(final ResultCallBack<LoginVerifyCodeBean> resultCallBack) {
        Logger.logD(TAG,"网络请求方法走了");
        NetApiService apiserver = HttpUtils.getInstance().getApiserver(NetApiService.verityCodeUrl, NetApiService.class);
        Observable<LoginVerifyCodeBean> verifyCode = apiserver.getVerifyCode();
        verifyCode.compose(RxUtils.<LoginVerifyCodeBean>rxObserableSchedulerHelper())
                .subscribe(new Observer<LoginVerifyCodeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(LoginVerifyCodeBean loginVerifyCodeBean) {
                        Logger.logD(TAG,"回来的验证码"+loginVerifyCodeBean.getData());
                            if (loginVerifyCodeBean != null){
                                resultCallBack.onSuccess(loginVerifyCodeBean);
                            }else {
                                resultCallBack.onFail("请求失败");
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
}
