package com.baidu.traveleverywhere.persenter;

import com.baidu.traveleverywhere.base.BasePresenter;
import com.baidu.traveleverywhere.bean.UpUserMessageBean;
import com.baidu.traveleverywhere.model.FragHomeModel;
import com.baidu.traveleverywhere.net.ResultCallBack;
import com.baidu.traveleverywhere.ui.home.HomeFragment;
import com.baidu.traveleverywhere.view.MyHomePageView;

import java.util.Map;

public class MyhomePagerPresenter extends BasePresenter<MyHomePageView> implements ResultCallBack<UpUserMessageBean> {

    private FragHomeModel mFragModle;

    @Override
    protected void initModel() {
        if (mFragModle == null){
            mFragModle = new FragHomeModel();
        }
        models.add(mFragModle);
    }

    public void postUpUserMessage(String tokenContent, Map map) {
            mFragModle.postUpUserMessage(tokenContent,map,this);
    }

    @Override
    public void onSuccess(UpUserMessageBean bean) {
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
