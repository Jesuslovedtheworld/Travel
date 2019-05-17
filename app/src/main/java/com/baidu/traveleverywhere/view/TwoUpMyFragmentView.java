package com.baidu.traveleverywhere.view;

import com.baidu.traveleverywhere.base.BaseMvpView;
import com.baidu.traveleverywhere.bean.DownBean;
import com.baidu.traveleverywhere.bean.UserMessageBean;

public interface TwoUpMyFragmentView extends BaseMvpView {
    void onUserMessageSuccess(UserMessageBean bean);

    void onFile(String msg);

    void onVersionSuccess(DownBean bean);
}
