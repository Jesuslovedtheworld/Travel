package com.baidu.traveleverywhere.persenter;

import com.baidu.traveleverywhere.base.BasePresenter;
import com.baidu.traveleverywhere.bean.CollectionOrClierBean;
import com.baidu.traveleverywhere.bean.HomeBaimiFollow;
import com.baidu.traveleverywhere.bean.HomeEveryBean;
import com.baidu.traveleverywhere.model.FrageeryModel;
import com.baidu.traveleverywhere.net.ResultCallBack;
import com.baidu.traveleverywhere.view.FrageveryView;

public class FragEveryPresenter extends BasePresenter<FrageveryView> implements ResultCallBack<HomeEveryBean> {

    private FrageeryModel model;

    @Override
    protected void initModel() {
        model = new FrageeryModel();
        models.add(model);
    }

    public void getBaiMiData(String token, int page) {
        model.getBaiMiList(token, page, this);
    }

    public void postFollow(int id,String token){
        model.homeFollow(id, token, new ResultCallBack<HomeBaimiFollow>() {
            @Override
            public void onSuccess(HomeBaimiFollow bean) {
                if (bean != null){
                    if (mMvpView != null){
                        mMvpView.onFollow(bean);
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
    public void postUnFollow(int id,String token){
        model.homeUnFollow(id, token, new ResultCallBack<HomeBaimiFollow>() {
            @Override
            public void onSuccess(HomeBaimiFollow bean) {
                if (bean != null){
                    if (mMvpView != null){
                        mMvpView.onFollow(bean);
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
    @Override
    public void onSuccess(HomeEveryBean bean) {
        if (bean != null) {
            if (mMvpView != null) {
                    mMvpView.onSuccess(bean);
            }
        }
    }

    @Override
    public void onFail(String msg) {
        if (mMvpView != null) {
            mMvpView.onFail(msg);
        }
    }
}
