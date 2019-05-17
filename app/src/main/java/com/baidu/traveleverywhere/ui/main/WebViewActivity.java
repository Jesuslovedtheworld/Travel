package com.baidu.traveleverywhere.ui.main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baidu.traveleverywhere.R;
import com.baidu.traveleverywhere.base.BaseActivity;
import com.baidu.traveleverywhere.base.Constants;
import com.baidu.traveleverywhere.persenter.EmptyPresenter;
import com.baidu.traveleverywhere.view.EmptyView;
import com.jaeger.library.StatusBarUtil;
import com.just.agentweb.AgentWeb;
import com.just.agentweb.IAgentWebSettings;
import com.just.agentweb.IUrlLoader;
import com.just.agentweb.LogUtils;
import com.just.agentweb.WebChromeClient;

import butterknife.BindView;

public class WebViewActivity extends BaseActivity<EmptyView, EmptyPresenter> implements EmptyView {

    //"https://api.banmi.com/app2017/agreement.html"
    @BindView(R.id.tv_head)
    TextView tvHead;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.ll)
    LinearLayout linearLayout;
    private AgentWeb mAgentWeb;
    private static final String TAG = "WebViewActivity";
    @Override
    protected EmptyPresenter initPersenter() {
        return new EmptyPresenter();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_web_view;
    }

    @Override
    protected void initView() {
        //亮色的模式,会讲状态栏文字修改为黑色的
        //StatusBarUtil.setLightMode(this);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.back_white);
         Intent intent = getIntent();
        String webUrl = intent.getStringExtra(Constants.WEBURL);
        mAgentWeb = AgentWeb.with(this)
                .setAgentWebParent(linearLayout, new LinearLayout.LayoutParams(-1, -1))
                .closeIndicator()
                .createAgentWeb()
                .ready()
                .go(webUrl);

        mAgentWeb.getWebCreator().getWebView().setWebChromeClient(new WebChromeClient(){
            @Override
            public void onReceivedTitle(WebView view, String title) {
                if (!TextUtils.isEmpty(title)){
                    tvHead.setText(title);
                }
                super.onReceivedTitle(view, title);
            }
        });

    }

    @Override
    protected void initListener() {
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onPause() {
        mAgentWeb.getWebLifeCycle().onPause();
        super.onPause();
    }

    @Override
    public void onResume() {
        mAgentWeb.getWebLifeCycle().onResume();
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        mAgentWeb.getWebLifeCycle().onDestroy();
        super.onDestroy();

    }
    public static void startWebAct(Context context){
        Intent intent = new Intent(context, WebViewActivity.class);
        intent.putExtra(Constants.WEBURL,"https://api.banmi.com/app2017/agreement.html");
        context.startActivity(intent);
    }

    @Override
    public void toastShort(String msg) {

    }
}
