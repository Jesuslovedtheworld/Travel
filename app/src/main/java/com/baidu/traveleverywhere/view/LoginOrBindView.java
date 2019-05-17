package com.baidu.traveleverywhere.view;

import android.app.Activity;
import android.content.Context;

import com.baidu.traveleverywhere.base.BaseMvpView;
import com.baidu.traveleverywhere.bean.LoginVerifyCodeBean;

public interface LoginOrBindView extends BaseMvpView {
    void onSuccess(LoginVerifyCodeBean bean);

    void onFile(String msg);
    Activity getAct();

    void go2HomeActivity();
}
