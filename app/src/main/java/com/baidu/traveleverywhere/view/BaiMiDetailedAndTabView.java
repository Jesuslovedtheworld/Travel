package com.baidu.traveleverywhere.view;

import com.baidu.traveleverywhere.base.BaseMvpView;
import com.baidu.traveleverywhere.bean.BaiMiDetailedbean;

public interface BaiMiDetailedAndTabView extends BaseMvpView {
    void onSuccess(BaiMiDetailedbean bean);

    void onFail(String msg);
}
