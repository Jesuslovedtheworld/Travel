package com.baidu.traveleverywhere.persenter;

import com.baidu.traveleverywhere.base.BasePresenter;
import com.baidu.traveleverywhere.bean.MyFollowCollectionBean;
import com.baidu.traveleverywhere.model.MyCollectionModel;
import com.baidu.traveleverywhere.net.ResultCallBack;
import com.baidu.traveleverywhere.view.MyFollowCollectionView;

public class MyFollowCollectionPresenter extends BasePresenter<MyFollowCollectionView> implements ResultCallBack<MyFollowCollectionBean> {

    private MyCollectionModel model;

    @Override
    protected void initModel() {
        model = new MyCollectionModel();
        models.add(model);
    }

    public void getCollection(String token, int i) {
        model.getCollection(token, i, this);
    }

    @Override
    public void onSuccess(MyFollowCollectionBean bean) {
        if (bean != null) {
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
