package com.baidu.traveleverywhere.ui.main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;

import com.baidu.traveleverywhere.R;
import com.baidu.traveleverywhere.base.BaseActivity;
import com.baidu.traveleverywhere.base.Constants;
import com.baidu.traveleverywhere.bean.LoginVerifyCodeBean;
import com.baidu.traveleverywhere.persenter.LoginOrBindPresenter;
import com.baidu.traveleverywhere.view.LoginOrBindView;
import com.umeng.socialize.UMShareAPI;

public class LoginActivityNews extends BaseActivity<LoginOrBindView, LoginOrBindPresenter> implements LoginOrBindView {
    public static final int TYPE_LOGIN = 0;
    public static final int TYPE_BIND = 1;
    private int mType;

    /**
     * 启动当前Activiy
     * @param context
     * @param type 如果是0:代表登录界面;1:代表要绑定手机
     */
    public static void startAct(Context context , int type){
        Intent intent = new Intent(context, LoginActivity.class);
        intent.putExtra(Constants.TYPE,type);
        context.startActivity(intent);
    }


    @Override
    public void onFile(String msg) {//错误信息

    }

    @Override
    public Activity getAct() {
        return null;
    }

    @Override
    public void go2HomeActivity() {

    }
    @Override
    public void toastShort(String msg) {

    }
    @Override
    public void onSuccess(LoginVerifyCodeBean bean) {//回来的验证码

    }

    @Override
    protected LoginOrBindPresenter initPersenter() {
        return new LoginOrBindPresenter();
    }

    @Override
    protected void initData() {
        mPresenter.getVerityCode();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_login_news;
    }

    @Override
    protected void initView() {
       // Tools.addShortcut(this,R.drawable.qq,this);
        getIntentData();
        FragmentManager manager = getSupportFragmentManager();
        LoginOrBindFragment fragment = LoginOrBindFragment.newIntance(mType);
        manager.beginTransaction().add(R.id.fl_container, fragment).commit();
    }

    private void getIntentData() {
        mType = getIntent().getIntExtra(Constants.TYPE, TYPE_LOGIN);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //内存泄漏解决方案
        UMShareAPI.get(this).release();
    }
}
