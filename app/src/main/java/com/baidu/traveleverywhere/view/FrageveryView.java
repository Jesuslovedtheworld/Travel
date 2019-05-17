package com.baidu.traveleverywhere.view;

import com.baidu.traveleverywhere.base.BaseMvpView;
import com.baidu.traveleverywhere.bean.CollectionOrClierBean;
import com.baidu.traveleverywhere.bean.HomeBaimiFollow;
import com.baidu.traveleverywhere.bean.HomeEveryBean;

public interface FrageveryView extends BaseMvpView {
    void onSuccess(HomeEveryBean bean);

    void onFail(String msg);

    void onFollow(HomeBaimiFollow homeBaimiFollow);

    void onFollowFail(String msg);
}
