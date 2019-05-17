package com.baidu.traveleverywhere.persenter;

import android.util.Log;

import com.baidu.traveleverywhere.base.BasePresenter;
import com.baidu.traveleverywhere.bean.CollectionOrClierBean;
import com.baidu.traveleverywhere.bean.HomeInfomation;
import com.baidu.traveleverywhere.model.HomeInfoModel;
import com.baidu.traveleverywhere.net.HomeInfoCallBack;
import com.baidu.traveleverywhere.net.ResultCallBack;
import com.baidu.traveleverywhere.view.HomeInfoView;

public class HomeInfoPresenter extends BasePresenter <HomeInfoView> implements HomeInfoCallBack {
    private static final String TAG = "HomeInfoPresenter";
    private HomeInfoModel homeInfoModel;

    @Override
    protected void initModel() {
        homeInfoModel = new HomeInfoModel();
        models.add(homeInfoModel);
    }

    public void getHomeInfoData(int id, String token) {
        homeInfoModel.getHomeInfoData(id,token,this);
    }
    /*public void collection(int id,String token){
        model.collection(id, token, new ResultCallBack<CollectionOrClierBean>() {
            @Override
            public void onSuccess(CollectionOrClierBean bean) {
                if (bean != null){
                    if (mMvpView != null){
                        mMvpView.onCollection(bean);
                    }

                }
            }

            @Override
            public void onFail(String msg) {
                if (mMvpView != null){
                    mMvpView.onCollectionFail(msg);
                }
            }
        });
    }*/
    @Override
    public void onSuccess(HomeInfomation bean) {
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

    public void postCollection(int id, String token) {
        homeInfoModel.postCollection(id, token, new ResultCallBack<CollectionOrClierBean>() {
            @Override
            public void onSuccess(CollectionOrClierBean bean) {
                    if (bean != null){
                        if (mMvpView != null){
                            mMvpView.onCollection(bean);
                        }

                    }
            }

            @Override
            public void onFail(String msg) {
                if (mMvpView != null){
                    mMvpView.onUnCollection(msg);
                }
            }
        });
    }

    public void postUnCollection(int id, String token) {
        homeInfoModel.postUnCollection(id, token, new ResultCallBack<CollectionOrClierBean>() {
            @Override
            public void onSuccess(CollectionOrClierBean bean) {
                if (bean != null){
                    if (mMvpView != null){
                        mMvpView.onCollection(bean);
                    }

                }
            }

            @Override
            public void onFail(String msg) {
                if (mMvpView != null){
                    mMvpView.onUnCollection(msg);
                }
            }
        });
    }
}
