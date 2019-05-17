package com.baidu.traveleverywhere.view;

import com.baidu.traveleverywhere.base.BaseMvpView;
import com.baidu.traveleverywhere.bean.HomeListData;

public interface BaiMiDetailedLineView extends BaseMvpView {
    void onSuccess(HomeListData bean);

    void onFile(String msg);
}
