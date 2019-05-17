package com.baidu.traveleverywhere.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.umeng.analytics.MobclickAgent;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity <V extends BaseMvpView,P extends BasePresenter>
        extends AppCompatActivity implements BaseMvpView{

    public P mPresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);
        mPresenter = initPersenter();//抽象方法  负责每个布局中的P层
        if (mPresenter != null){
            mPresenter.bind((V)this);
        }
        initView();//找控件
        initListener();
        initData();
    }

    protected abstract P initPersenter();

    protected void initData() {

    }

    protected void initListener() {

    }

    protected void initView() {

    }

    protected abstract int getLayout();//找布局抽象方

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null){
            mPresenter.onDestroy();//将皮层和绑定的V层销毁
            mPresenter = null;//打断P层
        }
    }
    @Override
    public void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

}
