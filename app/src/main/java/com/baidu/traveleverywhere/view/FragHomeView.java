package com.baidu.traveleverywhere.view;

import com.baidu.traveleverywhere.base.BaseMvpView;
import com.baidu.traveleverywhere.bean.HomeListData;
import com.baidu.traveleverywhere.bean.UserMessageBean;

public interface FragHomeView extends BaseMvpView {
    void onSuccess(HomeListData bean);

    void onFile(String msg);



}
