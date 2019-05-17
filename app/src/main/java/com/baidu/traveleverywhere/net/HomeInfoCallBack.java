package com.baidu.traveleverywhere.net;

import com.baidu.traveleverywhere.bean.HomeInfomation;

public interface HomeInfoCallBack {
    void onSuccess(HomeInfomation homeInfomation);
    void onFail(String s);
}
