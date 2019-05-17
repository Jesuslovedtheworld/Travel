package com.baidu.traveleverywhere.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.baidu.traveleverywhere.R;
import com.baidu.traveleverywhere.base.BaseActivity;
import com.baidu.traveleverywhere.base.Constants;
import com.baidu.traveleverywhere.persenter.EmptyPresenter;
import com.baidu.traveleverywhere.view.EmptyView;
import com.baidu.traveleverywhere.widget.AndroidJs;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AndroidJsWebActivity extends BaseActivity<EmptyView, EmptyPresenter> implements EmptyView {

    @BindView(R.id.baimi_wv)
    WebView baimiWv;

    @Override
    protected EmptyPresenter initPersenter() {
        return new EmptyPresenter();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_android_js_web;
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        String url = intent.getStringExtra(Constants.WEBURL);
        WebSettings settings = baimiWv.getSettings();
        settings.setJavaScriptEnabled(true);//支持js
        baimiWv.setWebViewClient(new WebViewClient());


        baimiWv.loadUrl(url+"?os=android");
        AndroidJs androidJs = new AndroidJs(this);
        baimiWv.addJavascriptInterface(androidJs,"android");
    }

    @Override
    public void toastShort(String msg) {

    }

}
