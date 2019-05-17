package com.baidu.traveleverywhere.persenter;

import com.baidu.traveleverywhere.base.BasePresenter;
import com.baidu.traveleverywhere.bean.BaiMiViewMoreBean;
import com.baidu.traveleverywhere.model.HomeModel;
import com.baidu.traveleverywhere.net.ResultCallBack;
import com.baidu.traveleverywhere.view.BaiMiViewMoreView;

public class BaiMiViewMorePresenter extends BasePresenter <BaiMiViewMoreView> implements ResultCallBack<BaiMiViewMoreBean> {

    private HomeModel mHomeModel;

    @Override
    protected void initModel() {
        if (mHomeModel == null){
            mHomeModel = new HomeModel();
        }
        models.add(mHomeModel);
    }

    public void getViewMore(String token) {
            mHomeModel.getBaiMiViewMore(token,this);
    }

    @Override
    public void onSuccess(BaiMiViewMoreBean bean) {
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
