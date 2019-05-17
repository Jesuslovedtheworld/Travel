package com.baidu.traveleverywhere.view;

import com.baidu.traveleverywhere.base.BaseMvpView;
import com.baidu.traveleverywhere.bean.BaiMiDetailedTreadBean;
import com.baidu.traveleverywhere.bean.BaiMiDetailedbean;
import com.baidu.traveleverywhere.bean.HomeListData;

public interface BaiMiDetailedTreadView extends BaseMvpView {
    void onSuccess(BaiMiDetailedTreadBean bean);

    void onFail(String msg);

    void onReviews(BaiMiDetailedbean bean);
}
