package com.baidu.traveleverywhere.persenter;

import com.baidu.traveleverywhere.base.BasePresenter;
import com.baidu.traveleverywhere.bean.HomeListData;
import com.baidu.traveleverywhere.bean.UserMessageBean;
import com.baidu.traveleverywhere.model.FragHomeModel;
import com.baidu.traveleverywhere.net.ResultCallBack;
import com.baidu.traveleverywhere.view.FragHomeView;

public class FragHomePresenter extends BasePresenter<FragHomeView> implements ResultCallBack<HomeListData> {

    private static final String TAG = "FragHomePresenter";
    private FragHomeModel model;

    @Override
    protected void initModel() {
        model = new FragHomeModel();
        models.add(model);
    }
    public void getData(String token,int page){
            model.getHomeListData(token,page,this);
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
