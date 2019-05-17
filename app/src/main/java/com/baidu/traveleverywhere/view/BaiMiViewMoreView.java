package com.baidu.traveleverywhere.view;

import com.baidu.traveleverywhere.base.BaseMvpView;
import com.baidu.traveleverywhere.bean.BaiMiViewMoreBean;

public interface BaiMiViewMoreView extends BaseMvpView {
    void onSuccess(BaiMiViewMoreBean bean);

    void onFail(String msg);
}
