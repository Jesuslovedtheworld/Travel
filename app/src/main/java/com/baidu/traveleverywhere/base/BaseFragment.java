package com.baidu.traveleverywhere.base;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baidu.traveleverywhere.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;
/*
* *  author gme
*    time 2019年5月3日 11:10:10
*/

public abstract class BaseFragment<V extends BaseMvpView,P extends BasePresenter> extends Fragment implements BaseMvpView{


    private Unbinder unbinder;
    protected P mPresenter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(getLayoutId(), null);
        unbinder = ButterKnife.bind(this, inflate);
        mPresenter = initPresenter();
        if (mPresenter != null){
            mPresenter.bind((V)this);
        }
        initView();
        initListener();
        initData();
        return inflate;

    }

    protected void initData() {
    }

    protected void initListener() {
    }

    protected void initView() {

    }

    protected abstract P initPresenter();

    protected abstract int getLayoutId();

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        mPresenter.onDestroy();
        mPresenter = null;
    }
}
