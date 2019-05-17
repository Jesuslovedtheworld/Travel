package com.baidu.traveleverywhere.ui.home;


import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.traveleverywhere.R;
import com.baidu.traveleverywhere.base.BaseFragment;
import com.baidu.traveleverywhere.base.Constants;
import com.baidu.traveleverywhere.bean.DownBean;
import com.baidu.traveleverywhere.bean.UserMessageBean;
import com.baidu.traveleverywhere.net.EveryApi;
import com.baidu.traveleverywhere.persenter.TwoUpMyFragmentPresenter;
import com.baidu.traveleverywhere.ui.aboutmy.MyCollectionActivity;
import com.baidu.traveleverywhere.ui.aboutmy.MyFollowActivity;
import com.baidu.traveleverywhere.utils.GlideUtils;
import com.baidu.traveleverywhere.utils.InstallUtil;
import com.baidu.traveleverywhere.utils.SpUtil;
import com.baidu.traveleverywhere.view.TwoUpMyFragmentView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class TwoUpMyFragment extends BaseFragment<TwoUpMyFragmentView, TwoUpMyFragmentPresenter> implements TwoUpMyFragmentView {


    @BindView(R.id.img_main)
    ImageView imgMain;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.brief)
    TextView brief;
    @BindView(R.id.edit)
    TextView edit;
    @BindView(R.id.tv_num)
    TextView tvNum;
    private TwoUpMyFragmentPresenter myFragmentPresenter;
    private AlertDialog mDownDialog;
    private File sd;
    private static final String TAG = "TwoUpMyFragment";
    private String mStringVersion;

    @Override
    protected TwoUpMyFragmentPresenter initPresenter() {
        if (myFragmentPresenter == null) {
            myFragmentPresenter = new TwoUpMyFragmentPresenter();
        }
        return myFragmentPresenter;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.homepage;
    }
    @Override
    protected void initData() {
        mStringVersion = (String) SpUtil.getParam(Constants.VERSION, "");
        checkVersion();
        editionUpgrade();//监听按钮  版本升级
        myFragmentPresenter.getUserMessage(Constants.TOKEN_CONTENT);
    }
    private void checkVersion() {
        myFragmentPresenter.getCheckVersion(Constants.TOKEN_CONTENT);
    }

    @Override
    public void toastShort(String msg) {

    }

    @OnClick({R.id.edit, R.id.rl_three, R.id.rl_four, R.id.img_upgrade, R.id.tv_upgrade})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.edit:
                openNa();
                break;
            case R.id.rl_three://我的收藏
                startActivity(new Intent(getContext(), MyCollectionActivity.class));
                break;
            case R.id.rl_four://我的关注
                startActivity(new Intent(getContext(), MyFollowActivity.class));
                break;
            case R.id.img_upgrade:
                editionUpgrade();//监听按钮  版本升级
                break;
            case R.id.tv_upgrade:
                editionUpgrade();
                break;
        }
    }








    @Override
    public void onVersionSuccess(DownBean bean) {//当前版本请求的数据
        if (bean != null){
            //判断版本有现在的版本是否一致  如果不一致弹窗 下载
            String version = bean.getResult().getInfo().getVersion();
            if (!version.equals(mStringVersion)){//当再次请求的时候 与sp判断保存的版本号对比
                mDownDialog.show();
                Log.e(TAG, "onVersionSuccess:SP保存的 当前版本号"+mStringVersion);
                Log.e(TAG, "onVersionSuccess: 网络请求的版本号前版本号"+version);
                SpUtil.setParam(Constants.VERSION,version);//将版本号保存在sp中
            }
        }
    }


    private void openNa() {//打开侧滑菜单
        Intent intent = new Intent(getContext(), MyHomePageActivity.class);
        startActivity(intent);
    }
    private void editionUpgrade() {
        //下载
        mDownDialog = new AlertDialog.Builder(getContext())
                .setTitle(getResources().getString(R.string.have_new_edition))
                .setNegativeButton(getResources().getString(R.string.Not_for_the_time_being), null)
                .setPositiveButton(getResources().getString(R.string.nowStart), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        initSD();
                        retrofit();//下载
                    }
                })
                .create();

    }



    @Override//用户信息请求的数据u
    public void onUserMessageSuccess(UserMessageBean bean) {
        UserMessageBean.ResultBean result = bean.getResult();
        String imageUrl = result.getPhoto();
        String description = result.getDescription();
        String userName = result.getUserName();
        String balance = result.getBalance();
        String gender = result.getGender();
        GlideUtils.glideCorner(imageUrl, imgMain); //获取头像
        brief.setText(description);//获取简介
        name.setText(userName);
        tvNum.setText(balance);
        SpUtil.setParam(Constants.USERNAME, userName);
        SpUtil.setParam(Constants.USERDESCRIPTION, description);
        SpUtil.setParam(Constants.USERBALANCE, balance);
        SpUtil.setParam(Constants.USERGENDER, gender);
        SpUtil.setParam(Constants.USERHEAD, imageUrl);
    }

    @Override
    public void onFile(String msg) {

    }
    @Override
    public void onResume() {//当界面显示的时候  判断sp保存的类型是否为true
        String headImage = (String) SpUtil.getParam(Constants.USERHEAD, "");
        GlideUtils.glideCorner(headImage,imgMain);
        boolean param = (boolean) SpUtil.getParam(Constants.USERUPINDEX, false);
        if (param){
            myFragmentPresenter.getUserMessage(Constants.TOKEN_CONTENT);
        }
        super.onResume();
    }
    private void retrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(EveryApi.downUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        EveryApi api = retrofit.create(EveryApi.class);
        Observable<ResponseBody> responseBodyObservable = api.Grende();
        responseBodyObservable.subscribeOn(Schedulers.io())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        // Log.e(TAG, "onNext: 下载开始走了" );
                        //InputStream inputStream = responseBody.byteStream();
                        //long l = responseBody.contentLength();
                        //saveFile(inputStream,sd+"/"+"everyTravel.apk",l);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }


    private void initSD() {
        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) ==
                PackageManager.PERMISSION_GRANTED) {
            openSD();
        } else {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission
                    .WRITE_EXTERNAL_STORAGE}, 100);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 100 && grantResults.length > 0 && grantResults[0] == PackageManager
                .PERMISSION_GRANTED) {
            openSD();
        }
    }

    private void openSD() {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            sd = Environment.getExternalStorageDirectory();
            Log.e(TAG, "openSD: "+sd);
        }
    }


    private void saveFile(InputStream inputStream, final String string, long max) {

        //读写的进度
        long count = 0;
        try {
            FileOutputStream outputStream = new FileOutputStream(new File(string));

            int length = -1;
            byte[] bys = new byte[1024 * 10];

            while ((length = inputStream.read(bys)) != -1) {
                outputStream.write(bys, 0, length);

                count += length;

                Log.d(TAG, "progress: 下载总长" + count);
                Log.d(TAG,  "下载长度max:" + max);

            }
            Log.e(TAG, "下载完成: ");
            inputStream.close();
            outputStream.close();

            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getContext(), "下载完成", Toast.LENGTH_SHORT).show();
                    InstallUtil.installApk(getContext(), string);
                }
            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
