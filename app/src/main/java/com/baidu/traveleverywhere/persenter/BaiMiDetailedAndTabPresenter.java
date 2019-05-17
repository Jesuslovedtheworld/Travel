package com.baidu.traveleverywhere.persenter;

import com.baidu.traveleverywhere.base.BasePresenter;
import com.baidu.traveleverywhere.bean.BaiMiDetailedbean;
import com.baidu.traveleverywhere.model.FrageeryModel;
import com.baidu.traveleverywhere.net.ResultCallBack;
import com.baidu.traveleverywhere.view.BaiMiDetailedAndTabView;

public class BaiMiDetailedAndTabPresenter extends BasePresenter<BaiMiDetailedAndTabView> implements ResultCallBack<BaiMiDetailedbean> {
    private FrageeryModel model;

    @Override
    protected void initModel() {
        if (model == null){
            model = new FrageeryModel();
        }
        models.add(model);

    }

    public void getBaiMiDetailed(String token, int detailedId) {
        model.getBaiMiDetailed(token,detailedId,this);
    }

    @Override
    public void onSuccess(BaiMiDetailedbean bean) {
        if (bean != null){
            if (mMvpView != null){
                mMvpView.onSuccess(bean);
            }
        }
    }

    @Override
    public void onFail(String msg) {
        if (mMvpView != null){
            mMvpView.onFail(msg);
        }
    }
}
