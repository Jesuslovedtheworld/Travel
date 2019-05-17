package com.baidu.traveleverywhere.view;

import com.baidu.traveleverywhere.base.BaseMvpView;
import com.baidu.traveleverywhere.bean.CollectionOrClierBean;
import com.baidu.traveleverywhere.bean.HomeInfomation;

public interface HomeInfoView extends BaseMvpView {
    void onFail(String msg);

    void onSuccess(HomeInfomation bean);

    void onCollection(CollectionOrClierBean bean);

    void onUnCollection(String msg);
}
