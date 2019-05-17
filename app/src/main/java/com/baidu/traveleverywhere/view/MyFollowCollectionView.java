package com.baidu.traveleverywhere.view;

import com.baidu.traveleverywhere.base.BaseMvpView;
import com.baidu.traveleverywhere.bean.MyFollowCollectionBean;

public interface MyFollowCollectionView extends BaseMvpView {
    void onSuccess(MyFollowCollectionBean bean);

    void onFail(String msg);
}
