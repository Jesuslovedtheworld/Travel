package com.baidu.traveleverywhere.view;

import com.baidu.traveleverywhere.base.BaseMvpView;
import com.baidu.traveleverywhere.bean.UpUserMessageBean;

public interface MyHomePageView extends BaseMvpView {
    void onSuccess(UpUserMessageBean bean);

    void onFail(String msg);
}
