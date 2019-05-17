package com.baidu.traveleverywhere.ui.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baidu.traveleverywhere.R;
import com.baidu.traveleverywhere.base.BaseActivity;
import com.baidu.traveleverywhere.base.BaseApp;
import com.baidu.traveleverywhere.base.BaseMvpView;
import com.baidu.traveleverywhere.base.BasePresenter;
import com.baidu.traveleverywhere.bean.LoginVerifyCodeBean;
import com.baidu.traveleverywhere.bean.SaveUserName;
import com.baidu.traveleverywhere.persenter.LoginOrBindPresenter;
import com.baidu.traveleverywhere.ui.home.HomeActivity;
import com.baidu.traveleverywhere.utils.Logger;
import com.baidu.traveleverywhere.utils.SpUtil;
import com.baidu.traveleverywhere.utils.ToastUtil;
import com.baidu.traveleverywhere.view.LoginOrBindView;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

/*
 * *  author gme
 *    time 2019年5月2日15:05:47
 *    key 5cca96b64ca357b3330003cf
 */
//
public class LoginActivity extends BaseActivity<BaseMvpView, BasePresenter> implements LoginOrBindView {
    private static final String TAG = "LoginActivity";
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.btn_send_verify_code)
    Button btnSendVerifyCode;
    @BindView(R.id.wechat_login)
    ImageView wechatLogin;
    @BindView(R.id.login_layout)
    RelativeLayout loginLayout;
    @BindView(R.id.et_one_box)
    EditText etOne;
    @BindView(R.id.et_two_box)
    EditText etTwo;
    @BindView(R.id.et_three_box)
    EditText etThree;
    /* @BindView(R.id.et_four_box)
     EditText etFour;*/
    @BindView(R.id.get_verify_layout)
    LinearLayout getVerifyLayout;
    @BindView(R.id.tv_loading)
    TextView tvLoading;
    @BindView(R.id.tv_qq)
    TextView tvQq;
    @BindView(R.id.tv_weibo)
    TextView tvWeibo;
    @BindView(R.id.tv_send_verify_code_again)
    TextView tv_send_verify_code_again;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_protocol)
    TextView tvProtocol;
    @BindView(R.id.ll_bind)
    LinearLayout llBind;
    @BindView(R.id.et_phone_bind)
    EditText etPhoneBind;
    @BindView(R.id.img_back_bind)
    ImageView imgBackBind;
    @BindView(R.id.getVerify)
    TextView getVerify;
    @BindView(R.id.hello)
    TextView hello;
    @BindView(R.id.tv_login)
    TextView tvLogin;
    @BindView(R.id.phone)
    ImageView phone;
    @BindView(R.id.addnum)
    TextView addnum;
    @BindView(R.id.line)
    View line;
    @BindView(R.id.or)
    TextView or;
    @BindView(R.id.tv_verify)
    TextView tvVerify;
    @BindView(R.id.layout_num)
    LinearLayout layoutNum;
    @BindView(R.id.tv_loginOrRegister)
    TextView tvLoginOrRegister;
    @BindView(R.id.btn_send_verify_code_bind)
    Button btnSendVerifyCodeBind;
    private String etPhoneString;
    private String etOneString;
    private String etTwoString;
    private String etThreeString;
    private String etFourString;
    private static final int MSG_CODE = 0;
    private int COUNTDOWNTIME = 5;
    private String etBindPhoneString;
    private LoginOrBindPresenter presenter;
    private String verifyData;
    private String okVerify = "";
    int type = 0;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 100) {
                if (COUNTDOWNTIME > 0) {
                    tv_send_verify_code_again.setText("剩余" + COUNTDOWNTIME + "秒");
                    COUNTDOWNTIME--;
                    handler.sendEmptyMessageDelayed(100, 1000);
                } else {
                    tv_send_verify_code_again.setText("重新发送");
                    tv_send_verify_code_again.setTextColor(getResources().getColor(R.color.gFA6A13));
                }
            }

        }
    };
    private EditText etFour;

    @Override
    protected BasePresenter initPersenter() {
        presenter = new LoginOrBindPresenter();
        return presenter;
    }

    @Override
    protected int getLayout() {
        return R.layout.login_main;
    }

    @Override
    protected void initView() {
        etFour = findViewById(R.id.et_four_box);
        etPhone.addTextChangedListener(new PhoneLengthWatcher());
        etOne.addTextChangedListener(new OneNumTextWatcher());
        etTwo.addTextChangedListener(new TwoNumTextWatcher());
        etThree.addTextChangedListener(new ThreeNumTextWatcher());
        etFour.addTextChangedListener(new FourNumTextWatcher());
        etPhoneBind.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.e(TAG, "onTextChanged: " + s);
            }

            @Override
            public void afterTextChanged(Editable s) {
                etBindPhoneString = s.toString();
                if (!TextUtils.isEmpty(etBindPhoneString)) {
                    btnSendVerifyCodeBind.setBackgroundResource(R.mipmap.button_highlight);
                } else {
                    btnSendVerifyCodeBind.setBackgroundResource(R.mipmap.button_unavailable);
                }

            }
        });
        //设置字体颜色
        SpannableString mStyleText = new SpannableString(getResources().getString(R.string.Login_or_registration));
        //点击事件
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                WebViewActivity.startWebAct(LoginActivity.this);
            }
        };
        //设置监听
        mStyleText.setSpan(clickableSpan, 12, 16, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //下划线
        UnderlineSpan span = new UnderlineSpan();
        mStyleText.setSpan(span, 12, 16, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(getResources().getColor(R.color.gFA6A13));
        mStyleText.setSpan(colorSpan, 12, 16, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //需要设置ClickableSpan才有效果
        tvProtocol.setMovementMethod(LinkMovementMethod.getInstance());
        tvProtocol.setText(mStyleText);
        tvLoginOrRegister.setMovementMethod(LinkMovementMethod.getInstance());
        tvLoginOrRegister.setText(mStyleText);

    }

    @OnClick({R.id.btn_send_verify_code, R.id.wechat_login, R.id.et_phone,
            R.id.tv_qq, R.id.tv_weibo, R.id.iv_back, R.id.img_back_bind,
            R.id.tv_loginOrRegister, R.id.btn_send_verify_code_bind, R.id.tv_send_verify_code_again})
    protected void initListener(View view) {
        switch (view.getId()) {
            case R.id.btn_send_verify_code:
                etPhone();
                break;
            case R.id.tv_qq:
                presenter.oauthLogin(SHARE_MEDIA.QQ);
                break;
            case R.id.tv_weibo:
                presenter.oauthLogin(SHARE_MEDIA.SINA);
                break;
            case R.id.iv_back:
                showInputLayout();//显示输入手机号布局
                break;
            case R.id.wechat_login:
                SpUtil.setParam("wechat",true);
                startActivity(new Intent(this,HomeActivity.class));
                finish();
                //showBindLayout();//显示输入手机号布局
                break;
            case R.id.tv_sendVerify_bind://发送验证码
                tvSendVerfity();
                break;
            case R.id.img_back_bind:
                showLoginLayout();
                break;
            case R.id.btn_send_verify_code_bind:
                tvSendVerfity();
                break;
        }
    }

    private void showLoginLayout() {
        llBind.setVisibility(View.GONE);//隐藏
        getVerifyLayout.setVisibility(View.GONE);//获取验证码界面显隐藏
        loginLayout.setVisibility(View.VISIBLE);//登录界面显示
        type = 1;

    }

    private void tvSendVerfity() {
        if (!TextUtils.isEmpty(etBindPhoneString)) {
            btnSendRerifyCode();
        } else {
            toastShort(getResources().getString(R.string.phoneNumber_NotNull));
            btnSendVerifyCode.setBackgroundResource(R.mipmap.button_unavailable);
        }
    }

    private void btnSendRerifyCode() {
        if (type == 0) {
            presenter.getVerityCode();
            COUNTDOWNTIME = 10;
            handler.sendEmptyMessageDelayed(100, 1000);
            toastShort("重新发送成功!");
            llBind.setVisibility(View.GONE);//隐藏
            getVerifyLayout.setVisibility(View.VISIBLE);//获取验证码界面显示
            loginLayout.setVisibility(View.GONE);//登录界面隐藏
            btnSendVerifyCode.setBackgroundResource(R.mipmap.button_highlight);
        }
        if (type == 1){
            getVerifyLayout.setVisibility(View.VISIBLE);//获取验证码界面显示
            loginLayout.setVisibility(View.GONE);//登录界面隐藏
            btnSendVerifyCode.setBackgroundResource(R.mipmap.button_highlight);
        }
    }

    //显示输入手机号布局
    private void showBindLayout() {
        llBind.setVisibility(View.VISIBLE);
        getVerifyLayout.setVisibility(View.GONE);
        loginLayout.setVisibility(View.GONE);
    }


    private void showInputLayout() {
        loginLayout.setVisibility(View.VISIBLE);
        getVerifyLayout.setVisibility(View.GONE);
        llBind.setVisibility(View.GONE);
    }

    //注册手机号之后登录方法
    private void etPhone() {
        if (etPhoneString != null) {
            btnSendRerifyCode();//发送验证码 倒计时
        } else {
            ToastUtil.showShort("手机号不能为空");
        }

    }

    @Override
    public void onSuccess(LoginVerifyCodeBean bean) {
        if (bean != null) {
            getVerify.setVisibility(View.VISIBLE);
            verifyData = bean.getData();
            getVerify.setText(getResources().getString(R.string.your_verify) + verifyData);
        }
    }

    @Override
    public void onFile(String msg) {
        Logger.logD(TAG, "回来的错误信息" + msg);
    }

    @Override
    public Activity getAct() {
        return LoginActivity.this;
    }

    @Override
    public void go2HomeActivity() {
        SpUtil.setParam("hava",true);
        ToastUtil.showShort((BaseApp.getRes().getString(R.string.login_success)));
        startActivity(new Intent(this, HomeActivity.class));
        finish();
    }

    @Override
    public void toastShort(String msg) {

    }


    //监听电话输入框的变化
    class PhoneLengthWatcher implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) { //判断按钮是否显示亮色
            etPhoneString = s.toString();
            if (!TextUtils.isEmpty(etPhoneString)){
                btnSendVerifyCode.setBackgroundResource(R.mipmap.button_highlight);
            }else {
                btnSendVerifyCode.setBackgroundResource(R.mipmap.button_unavailable);
            }
        }
    }

    class OneNumTextWatcher implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            etOneString = s.toString();
            okVerify += etOneString;
        }
    }

    class TwoNumTextWatcher implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            etTwoString = s.toString();
            okVerify += etTwoString;
        }
    }

    class ThreeNumTextWatcher implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            etThreeString = s.toString();
            okVerify += etThreeString;
        }
    }

    class FourNumTextWatcher implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {


        }

        @Override
        public void afterTextChanged(Editable s) {
            etFourString = s.toString();
            okVerify += etFourString;
            Log.e(TAG, "afterTextChanged: " + okVerify);
            if (etFourString != null & okVerify.equals(verifyData)) {
                etFour.setBackgroundResource(R.drawable.verify_code_checked_box);
                getVerify.setVisibility(View.GONE);//验证码消失etFour.setBackgroundResource(R.drawable.verify_code_checked_box);
                tvLoading.setVisibility(View.VISIBLE);
                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
            } else {
                ToastUtil.showShort(getResources().getString(R.string.verifyFail));
                okVerify = "";
                etOne.getText().clear();
                etTwo.getText().clear();
                etThree.getText().clear();
                etFour.getText().clear();
            }

        }
    }

    //QQ与新浪不需要添加Activity，但需要在使用QQ分享或者授权的Activity中
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

    private void logMap(Map<String, String> data) {
        SaveUserName userName = new SaveUserName();
        for (Map.Entry<String, String> entry : data.entrySet()) {
            String key = entry.getKey();
            Log.e("taggg", "健值: " + key + "values值" + entry.getValue());
            if (key == "name") {
                userName.setUserName(entry.getValue());
            }
            if (key == "uid") {
                userName.setUserId(entry.getValue());
            }
            if (key == "profile_image_url") {
                userName.setIconurl(entry.getValue());
            }
        }
    }

   /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }*/


}

