package com.baidu.traveleverywhere.ui.main;

import android.content.Intent;
import android.os.CountDownTimer;
import android.util.Log;

import com.baidu.traveleverywhere.R;
import com.baidu.traveleverywhere.base.BaseActivity;
import com.baidu.traveleverywhere.persenter.EmptyPresenter;
import com.baidu.traveleverywhere.ui.home.HomeActivity;
import com.baidu.traveleverywhere.utils.SpUtil;
import com.baidu.traveleverywhere.view.EmptyView;

public class PlashActivity extends BaseActivity<EmptyView,EmptyPresenter> implements EmptyView {
    private int timeCount = 3;

    @Override
    protected EmptyPresenter initPersenter() {
        return new EmptyPresenter();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_plash;
    }

    @Override
    protected void initView() {
        contDown();
    }

    private void contDown() {
        new CountDownTimer(2000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                startAct();
            }
        }.start();
    }

    private void startAct() {
        boolean guide = (boolean) SpUtil.getParam("guide", false);
        boolean wechat = (boolean) SpUtil.getParam("wechat", false);
        Log.e("guide", "guide: "+guide );
        Log.e("wechat", "wechat: "+wechat);
        if (wechat){
            startActivity(new Intent(this, HomeActivity.class));//跳转到主界面
            finish();
        }else{
            if (guide){
                startActivity(new Intent(this, LoginActivity.class));//跳转登录界面
                finish();
            }else {
                startActivity(new Intent(this, GuideActivity.class));//跳转登录界面
                finish();
            }
        }

    }

    @Override
    public void toastShort(String msg) {

    }
}
