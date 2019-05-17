package com.baidu.traveleverywhere.persenter;

import android.util.Log;

import com.baidu.traveleverywhere.base.BasePresenter;
import com.baidu.traveleverywhere.bean.BaiMiDetailedTreadBean;
import com.baidu.traveleverywhere.bean.BaiMiDetailedbean;
import com.baidu.traveleverywhere.model.FrageeryModel;
import com.baidu.traveleverywhere.net.ResultCallBack;
import com.baidu.traveleverywhere.view.BaiMiDetailedTreadView;

public class BaiMiDetailedTreadPreenter extends BasePresenter<BaiMiDetailedTreadView> implements ResultCallBack<BaiMiDetailedTreadBean> {

    private FrageeryModel mFragmodel;

    @Override
    protected void initModel() {
        if (mFragmodel == null){
            mFragmodel = new FrageeryModel();
        }
        models.add(mFragmodel);
    }

   /* public void getBaiMiTreadData(String tokenContent, int mId, int page) {
   todo
        mFragmodel.getBaiMiTread(tokenContent,mId,page,this);
    }*/

    @Override
    public void onSuccess(BaiMiDetailedTreadBean bean) {
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
    public void getBaiMiDetailed(String token, int detailedId) {
        mFragmodel.getBaiMiDetailed(token, detailedId, new ResultCallBack<BaiMiDetailedbean>() {
            @Override
            public void onSuccess(BaiMiDetailedbean bean) {
                    if (bean != null){
                        if (mMvpView != null){
                            mMvpView.onReviews(bean);
                        }
                    }
            }

            @Override
            public void onFail(String msg) {
                if (mMvpView != null){
                    mMvpView.onFail(msg);
                }
            }
        });
    }
}
