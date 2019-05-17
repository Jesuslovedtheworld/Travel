package com.baidu.traveleverywhere.ui.aboutmy;

import com.baidu.traveleverywhere.R;
import com.baidu.traveleverywhere.base.BaseActivity;
import com.baidu.traveleverywhere.persenter.EmptyPresenter;
import com.baidu.traveleverywhere.view.EmptyView;

public class Mywallet extends BaseActivity<EmptyView,EmptyPresenter> implements EmptyView{
    @Override
    protected EmptyPresenter initPersenter() {
        return new EmptyPresenter();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_mywallet;
    }

    @Override
    public void toastShort(String msg) {

    }
}
