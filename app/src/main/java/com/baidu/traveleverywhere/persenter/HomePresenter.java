package com.baidu.traveleverywhere.persenter;

import com.baidu.traveleverywhere.base.BasePresenter;
import com.baidu.traveleverywhere.bean.DownBean;
import com.baidu.traveleverywhere.bean.HomeWeiBoBean;
import com.baidu.traveleverywhere.bean.UserMessageBean;
import com.baidu.traveleverywhere.model.HomeModel;
import com.baidu.traveleverywhere.net.ResultCallBack;
import com.baidu.traveleverywhere.view.HomeView;

public class HomePresenter extends BasePresenter<HomeView> {

    private HomeModel model;

    @Override
    protected void initModel() {
        model = new HomeModel();
        models.add(model);
    }

    public void postData(int uid) {
        if (model != null){
            model.postData(uid, new ResultCallBack<HomeWeiBoBean>() {
                @Override
                public void onSuccess(HomeWeiBoBean bean) {
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
            });
        }
    }
}
