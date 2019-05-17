package com.baidu.traveleverywhere.persenter;

import com.baidu.traveleverywhere.base.BasePresenter;
import com.baidu.traveleverywhere.bean.DownBean;
import com.baidu.traveleverywhere.bean.UserMessageBean;
import com.baidu.traveleverywhere.model.HomeModel;
import com.baidu.traveleverywhere.net.ResultCallBack;
import com.baidu.traveleverywhere.view.TwoUpMyFragmentView;

public class TwoUpMyFragmentPresenter extends BasePresenter<TwoUpMyFragmentView> {

    private HomeModel model;
    @Override
    protected void initModel() {
        model = new HomeModel();
        models.add(model);
    }
    public void getUserMessage(String tokenContent) {
        model.getUserMessage(tokenContent, new ResultCallBack<UserMessageBean>() {
            @Override
            public void onSuccess(UserMessageBean bean) {
                if (bean != null){
                    if (mMvpView != null){
                        mMvpView.onUserMessageSuccess(bean);
                    }
                }
            }

            @Override
            public void onFail(String msg) {
                if (mMvpView != null){
                    mMvpView.onFile(msg);
                }
            }
        });
    }
    public void getCheckVersion(String tokenContent) {
        if (model != null){
            model.getVersion(tokenContent, new ResultCallBack<DownBean>() {
                @Override
                public void onSuccess(DownBean bean) {
                    if (bean != null){
                        if (mMvpView != null){
                            mMvpView.onVersionSuccess(bean);
                        }
                    }
                }

                @Override
                public void onFail(String msg) {
                    if (mMvpView != null){
                        mMvpView.onFile(msg);
                    }
                }
            });
        }
    }
}
