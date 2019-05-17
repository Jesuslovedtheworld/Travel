package com.baidu.traveleverywhere.view;

import com.baidu.traveleverywhere.base.BaseMvpView;
import com.baidu.traveleverywhere.bean.MyFollowBean;

public interface MyFollowView extends BaseMvpView {
    void onSuccess(MyFollowBean bean);

    void onFail(String msg);
}
