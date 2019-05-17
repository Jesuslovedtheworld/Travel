package com.baidu.traveleverywhere.view;

import com.baidu.traveleverywhere.base.BaseMvpView;
import com.baidu.traveleverywhere.bean.DownBean;
import com.baidu.traveleverywhere.bean.HomeWeiBoBean;
import com.baidu.traveleverywhere.bean.UserMessageBean;

public interface HomeView extends BaseMvpView {
    void onSuccess(HomeWeiBoBean bean);
    void onFile(String msg);
}
