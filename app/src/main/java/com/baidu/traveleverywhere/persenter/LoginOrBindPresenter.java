package com.baidu.traveleverywhere.persenter;

import android.support.v7.widget.CardView;
import android.util.Log;

import com.baidu.traveleverywhere.R;
import com.baidu.traveleverywhere.base.BaseApp;
import com.baidu.traveleverywhere.base.BasePresenter;
import com.baidu.traveleverywhere.base.Constants;
import com.baidu.traveleverywhere.bean.LoginInfo;
import com.baidu.traveleverywhere.bean.LoginVerifyCodeBean;
import com.baidu.traveleverywhere.model.LoginModel;
import com.baidu.traveleverywhere.net.ResultCallBack;
import com.baidu.traveleverywhere.ui.home.HomeActivity;
import com.baidu.traveleverywhere.ui.main.LoginActivity;
import com.baidu.traveleverywhere.utils.SpUtil;
import com.baidu.traveleverywhere.utils.ToastUtil;
import com.baidu.traveleverywhere.view.LoginOrBindView;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.nio.file.Path;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//token rBeRSXaoT8Y4wRYkQoyLXcWSwyKDuSNZx3WkWJlk1UHMryjUWhtIYeVNyVwQnajTfg9titlPUKpyAcoB3ZuLmfx0v0GS8kauACdv8cL6mIo1ibbimNsjLlY9N55RA7hA3iw
public class LoginOrBindPresenter extends BasePresenter<LoginOrBindView> implements ResultCallBack<LoginVerifyCodeBean>{

    private LoginModel model;
    private static final String TAG = "LoginOrBindPresenter";

    @Override
    protected void initModel() {
        if (model == null){
            model = new LoginModel();
        }
        models.add(model);
    }
    public void getVerityCode(){
        model.getVerifyCode(this);
    }
    @Override
    public void onSuccess(LoginVerifyCodeBean bean) {
            if (bean != null){
                if (mMvpView != null){
                    mMvpView.onSuccess(bean);
                }
            }
    }

    @Override
    public void onFail(String msg) {
            if (mMvpView != null){
                 mMvpView.onFile(msg);
            }
    }

    public void oauthLogin(SHARE_MEDIA type) {
        UMShareAPI umShareAPI = UMShareAPI.get(mMvpView.getAct());
        //media,三方平台
        //authListener,登录回调
        umShareAPI.getPlatformInfo(mMvpView.getAct(), type, authListener);
    }
    UMAuthListener authListener = new UMAuthListener() {
        /**
         * @desc 授权开始的回调
         * @param platform 平台名称
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        /**
         * @desc 授权成功的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param data 用户资料返回
         */
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            SpUtil.setParam("wechat",true);
            //logMap(data);
            if (platform == SHARE_MEDIA.SINA){
                getImageUrl(data);
                String uid = data.get("uid");
                loginSina(uid);
                mMvpView.go2HomeActivity();
            }
            if (platform == SHARE_MEDIA.QQ){
                getImageUrl(data);
                mMvpView.go2HomeActivity();

            }
        }

        /**
         * @desc 授权失败的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {

        }

        /**
         * @desc 授权取消的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         */
        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            mMvpView.go2HomeActivity();
        }
    };

    private void getImageUrl(Map<String, String> data) {
        Collection<String> values = data.values();
        Set<String> keySet = data.keySet();
        for (String s : keySet) {
            Log.e(TAG, "getImageUrl: 键"+s);
        }
        for (String value : values) {
            Log.e(TAG, "getImageUrl: 键"+value);
        }
    }

    /**
     * 新浪微博登录
     * @param uid
     */
    private void loginSina(String uid) {
        Log.e(TAG, "我的uid: "+uid );
        model.loginSina(uid, new ResultCallBack<LoginInfo>() {
            @Override
            public void onSuccess(LoginInfo bean) {
                //登录成功了,需要做什么
                //1.跳转主页面
                //2.保存用户信息
                if (bean.getResult() != null) {
                    saveUserInfo(bean.getResult());
                    if (mMvpView != null){
                        mMvpView.go2HomeActivity();
                    }
                }else {
                    if (mMvpView != null){
                       mMvpView.toastShort(BaseApp.getRes().getString(R.string.login_fail));
                    }
                }
            }

            @Override
            public void onFail(String msg) {
                if (mMvpView != null){
                    mMvpView.toastShort(msg);
                }
            }
        });
    }

    /**
     * 保存用户信息
     * @param result
     */
    private void saveUserInfo(LoginInfo.ResultBean result) {
        SpUtil.setParam(Constants.TOKEN,result.getToken());
        SpUtil.setParam(Constants.DESC,result.getDescription());
        SpUtil.setParam(Constants.USERNAME,result.getUserName());
        SpUtil.setParam(Constants.GENDER,result.getGender());
        SpUtil.setParam(Constants.EMAIL,result.getEmail());
        SpUtil.setParam(Constants.PHOTO,result.getPhoto());
        SpUtil.setParam(Constants.PHONE,result.getPhone());
    }

}
