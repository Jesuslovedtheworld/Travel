package com.baidu.traveleverywhere.ui.home;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;

import com.baidu.traveleverywhere.R;
import com.baidu.traveleverywhere.adapter.BaiMiDetailedAndTabRlvAdapter;
import com.baidu.traveleverywhere.adapter.GuideVpAdapter;
import com.baidu.traveleverywhere.adapter.LookAllRlvAdapter;
import com.baidu.traveleverywhere.base.Constants;
import com.baidu.traveleverywhere.bean.BaiMiDetailedTreadBean;
import com.baidu.traveleverywhere.bean.LookAllBean;
import com.baidu.traveleverywhere.net.BaseObserver;
import com.baidu.traveleverywhere.net.EveryApi;
import com.baidu.traveleverywhere.net.HttpUtils;
import com.baidu.traveleverywhere.net.RxUtils;
import com.baidu.traveleverywhere.utils.GlideUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class LookAllActivity extends AppCompatActivity implements BaiMiDetailedAndTabRlvAdapter.ImageToBigItemOnclick, LookAllRlvAdapter.ImageToBigItemOnclick {

    @BindView(R.id.re_tread)
    RecyclerView reTread;
    @BindView(R.id.smart_line)
    SmartRefreshLayout smartLine;
    @BindView(R.id.toolbar_look)
    Toolbar toolbarLook;
    private ArrayList<LookAllBean.ResultBean.ReviewsBean> mArr;
    private LookAllRlvAdapter mAdapter;
    private int page = 1;
    private int mId;
    private ArrayList<View> views;
    private PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_look_all);
        ButterKnife.bind(this);
        initview();
        initData();

    }

    private void initData() {
        new Thread() {
            @Override
            public void run() {
                getBaiMiTread(Constants.TOKEN_CONTENT, mId, page);
                super.run();
            }
        }.start();
    }

    private void initview() {
        Intent intent = getIntent();
        mId = intent.getIntExtra("id", 0);
        Log.e("uid", "initview: " + mId);
        reTread.setLayoutManager(new LinearLayoutManager(this));
        mArr = new ArrayList<>();
        mAdapter = new LookAllRlvAdapter(mArr, this);
        reTread.setAdapter(mAdapter);
        mAdapter.setImageToBigItemOnclick(this);
    }

    public void getBaiMiTread(String tokenContent, int mId, int page) {
        EveryApi api = HttpUtils.getInstance().getApiserver(EveryApi.baimiUrl, EveryApi.class);
        Observable<LookAllBean> baiMiTread = api.getBaiMiTread(tokenContent, mId, page);
        baiMiTread.compose(RxUtils.<LookAllBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<LookAllBean>() {
                    @Override
                    public void onNext(final LookAllBean lookAllBean) {
                        if (lookAllBean != null) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    mArr.addAll(lookAllBean.getResult().getReviews());
                                    mAdapter.notifyDataSetChanged();
                                }
                            });

                        }
                    }

                    @Override
                    public void error(String msg) {

                    }

                    @Override
                    protected void subscribe(Disposable d) {

                    }
                });
    }

    @Override
    public void imageOnClick(String s) {//找出控件产品
        View inflate = getLayoutInflater().inflate(R.layout.big_image_popupwindow, null);
        ViewPager vp = inflate.findViewById(R.id.img_vp);
        popupWindow = new PopupWindow(inflate, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
        popupWindow.setTouchable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        // 设置好参数之后再show
        popupWindow.showAtLocation(toolbarLook,Gravity.CENTER, 0, 0);
        if (views == null) {
            views = new ArrayList<>();
        }
        View bigInflate = getLayoutInflater().inflate(R.layout.big_img, null);
        ImageView img_big = bigInflate.findViewById(R.id.img_big_vp);
        GlideUtils.glide(s, img_big);
        views.add(img_big);
        GuideVpAdapter adapter = new GuideVpAdapter(views);
        vp.setAdapter(adapter);
        img_big.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
                views.clear();
            }
        });
    }

}
