package com.baidu.traveleverywhere.persenter;

import com.baidu.traveleverywhere.base.BasePresenter;
import com.baidu.traveleverywhere.bean.MyFollowBean;
import com.baidu.traveleverywhere.model.MyCollectionModel;
import com.baidu.traveleverywhere.net.ResultCallBack;
import com.baidu.traveleverywhere.view.MyFollowView;

public class MyFollowPresenter extends BasePresenter<MyFollowView> implements ResultCallBack<MyFollowBean> {

    private MyCollectionModel collectionModel;

    @Override
    protected void initModel() {
        if (collectionModel == null){
            collectionModel = new MyCollectionModel();
        }
        models.add(collectionModel);
    }

    public void getFollowData(String token, int page) {
        if (collectionModel == null){
                collectionModel = new MyCollectionModel();
        }
        collectionModel.getFollow(token,page,this);
    }

    @Override
    public void onSuccess(MyFollowBean bean) {
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
