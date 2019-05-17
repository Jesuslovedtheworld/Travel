package com.baidu.traveleverywhere.ui.main;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.baidu.traveleverywhere.R;
import com.baidu.traveleverywhere.base.BaseFragment;
import com.baidu.traveleverywhere.base.Constants;
import com.baidu.traveleverywhere.bean.LoginVerifyCodeBean;
import com.baidu.traveleverywhere.persenter.EmptyPresenter;
import com.baidu.traveleverywhere.persenter.LoginOrBindPresenter;
import com.baidu.traveleverywhere.view.EmptyView;
import com.baidu.traveleverywhere.view.LoginOrBindView;
import com.umeng.socialize.bean.SHARE_MEDIA;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginOrBindFragment extends BaseFragment<LoginOrBindView, LoginOrBindPresenter> implements LoginOrBindView {

    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.btn_send_verify_code)
    Button btnSendVerifyCode;
    @BindView(R.id.tv_qq)
    TextView tvQq;
    @BindView(R.id.tv_weibo)
    TextView tvWeibo;
    @BindView(R.id.tv_protocol)
    TextView tvProtocol;
    //因为登录和绑定手机号码是用的一个碎片,所以需要使用type隐藏和显示某一些view
    //如果是0:代表登录界面;1:代表要绑定手机
    private int mType;
    private LoginOrBindPresenter presenter;

    public static LoginOrBindFragment newIntance(int type) {
        LoginOrBindFragment fragment = new LoginOrBindFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(Constants.TYPE, type);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected LoginOrBindPresenter initPresenter() {
        presenter = new LoginOrBindPresenter();
        return presenter;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.loginorbind;
    }

    /**
     * 因为登录和绑定手机号码是用的一个碎片,所以需要使用type隐藏和显示某一些view
     */
    private void showOrHideView() {

       /*
        todo  登录
        if (mType == LoginActivity.TYPE_LOGIN) {
            //登录
            //View.VISIBLE 显示
            //View.INVISIBLE 隐藏,占位置
         *//*   //View.GONE 隐藏 不占位置
            mIvBack.setVisibility(View.INVISIBLE);
            mLlOauthLogin.setVisibility(View.VISIBLE);
            mLlOr.setVisibility(View.VISIBLE);*//*
        } else {
           *//* //绑定
            mIvBack.setVisibility(View.VISIBLE);
            mLlOauthLogin.setVisibility(View.GONE);
            mLlOr.setVisibility(View.GONE);*//*
        }*/
    }

    private void getArgumentsData() {
        Bundle arguments = getArguments();
        mType = arguments.getInt(Constants.TYPE);
    }

    protected void initListener() {

    }
    @OnClick({R.id.et_phone, R.id.btn_send_verify_code, R.id.tv_qq, R.id.tv_weibo, R.id.tv_protocol})
    public void initListener(View view) {
        switch (view.getId()) {
            case R.id.et_phone:
                break;
            case R.id.btn_send_verify_code:
                break;
            case R.id.tv_qq:
                presenter.oauthLogin(SHARE_MEDIA.QQ);
                break;
            case R.id.tv_weibo:
                presenter.oauthLogin(SHARE_MEDIA.SINA);
                break;
            case R.id.tv_protocol:
                break;
        }
    }

    @Override
    public void onSuccess(LoginVerifyCodeBean bean) {

    }

    @Override
    public void onFile(String msg) {

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

}
