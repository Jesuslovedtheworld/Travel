package com.baidu.traveleverywhere.persenter;

import com.baidu.traveleverywhere.base.BasePresenter;
import com.baidu.traveleverywhere.bean.HomeListData;
import com.baidu.traveleverywhere.model.FragHomeModel;
import com.baidu.traveleverywhere.net.ResultCallBack;
import com.baidu.traveleverywhere.view.BaiMiDetailedLineView;
import com.baidu.traveleverywhere.view.BaiMiDetailedTreadView;

public class BaiMiDetailedLinePresenter extends BasePresenter<BaiMiDetailedLineView> implements ResultCallBack<HomeListData> {
    private FragHomeModel model;
    @Override
    protected void initModel() {
        model = new FragHomeModel();
        models.add(model);
    }

    public void getData(String tokenContent, int page) {
        model.getHomeListData(tokenContent,page,this);
    }

    @Override
    public void onSuccess(HomeListData bean) {
        if (bean != null){
            if (mMvpView != null){
                mMvpView.onSuccess(bean);
            }
        }
    }

    @Override
    public void onFail(String msg) {
        if (mMvpView != null){
            mMvpView.onFile(msg);
        }
    }
}
