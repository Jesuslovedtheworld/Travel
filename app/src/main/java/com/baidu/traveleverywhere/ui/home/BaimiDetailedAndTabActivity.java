package com.baidu.traveleverywhere.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.baidu.traveleverywhere.R;
import com.baidu.traveleverywhere.adapter.MessageVpAdapter;
import com.baidu.traveleverywhere.base.BaseActivity;
import com.baidu.traveleverywhere.base.BaseFragment;
import com.baidu.traveleverywhere.bean.BaiMiDetailedbean;
import com.baidu.traveleverywhere.persenter.BaiMiDetailedAndTabPresenter;
import com.baidu.traveleverywhere.utils.GlideUtils;
import com.baidu.traveleverywhere.view.BaiMiDetailedAndTabView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BaimiDetailedAndTabActivity extends BaseActivity<BaiMiDetailedAndTabView, BaiMiDetailedAndTabPresenter> implements BaiMiDetailedAndTabView, TabLayout.BaseOnTabSelectedListener {

    @BindView(R.id.baimi_detailed_atab_toolbar)
    Toolbar baimiDetailedToolbar;
    @BindView(R.id.img_baimi_detailed)
    ImageView imgBaimiDetailed;
    @BindView(R.id.tv_baimi_detailed_name)
    TextView tvBaimiDetailedName;
    @BindView(R.id.tv_follows)
    TextView tvFollows;
    @BindView(R.id.tv_baimi_detailed_location)
    TextView tvBaimiDetailedLocation;
    @BindView(R.id.img_detailed_message)
    ImageView imgDetailedMessage;
    @BindView(R.id.tv_baimi_detailed_brief)
    TextView tvBaimiDetailedBrief;
    @BindView(R.id.tv_baimi_detailed_content)
    TextView tvBaimiDetailedContent;
    @BindView(R.id.tab_baimi_detailed)
    TabLayout tabBaimiDetailed;
    @BindView(R.id.img_baimi_follow)
    ImageView imgBaimiFollow;
    @BindView(R.id.card_detailed)
    CardView cardDetailed;
    @BindView(R.id.fl)
    FrameLayout fl;
    private BaiMiDetailedAndTabPresenter presenter;
    private String token;
    private int detailedId;
    private BaiMiDetaileTreadFrag baiMiDetaileTreadFrag;
    private BaiMiDetailedLineFrag baiMiDetailedLineFrag;
    private MessageVpAdapter adapter;
    private FragmentManager supportFragmentManager;

    @Override
    protected int getLayout() {
        return R.layout.activity_baimi_detailed_and_tab;
    }

    @Override
    protected BaiMiDetailedAndTabPresenter initPersenter() {
        if (presenter == null) {
            presenter = new BaiMiDetailedAndTabPresenter();
        }
        return presenter;
    }

    @Override
    protected void initView() {
        baimiDetailedToolbar.setTitle("");
        baimiDetailedToolbar.setSubtitle("");
        setSupportActionBar(baimiDetailedToolbar);
        Intent intent = getIntent();
        detailedId = intent.getIntExtra("detailedid", 122);//获取详情路线的
        token = intent.getStringExtra("token");
        initFragment();
    }

    private void initFragment() {
        baiMiDetaileTreadFrag = new BaiMiDetaileTreadFrag(detailedId);
        baiMiDetailedLineFrag = new BaiMiDetailedLineFrag();
        TabLayout.Tab tabTread = tabBaimiDetailed.newTab();
        tabTread.setText(getResources().getString(R.string.tread));
        tabBaimiDetailed.addTab(tabTread);
        TabLayout.Tab tabLine = tabBaimiDetailed.newTab();
        tabLine.setText(getResources().getString(R.string.lined));
        tabBaimiDetailed.addTab(tabLine);

        tabBaimiDetailed.setOnTabSelectedListener(this);
        //获取管理器
        if (supportFragmentManager == null){
            supportFragmentManager = getSupportFragmentManager();
        }
        supportFragmentManager.beginTransaction().add(R.id.fl,baiMiDetaileTreadFrag)
                .add(R.id.fl,baiMiDetailedLineFrag)
                .commit();
            supportFragmentManager.beginTransaction()
                    .show(baiMiDetaileTreadFrag)
                    .hide(baiMiDetailedLineFrag).commit();
    }

    @Override
    protected void initData() {
        presenter.getBaiMiDetailed(token, detailedId);
    }

    @Override
    public void toastShort(String msg) {

    }

    @Override
    public void onSuccess(BaiMiDetailedbean bean) {
        if (bean != null) {
            setMainUI(bean);
        }
    }

    @Override
    public void onFail(String msg) {

    }

    private void setMainUI(BaiMiDetailedbean bean) {
        if (bean != null) {
            BaiMiDetailedbean.ResultBean.BanmiBean banmiBean = bean.getResult().getBanmi();
            GlideUtils.glide(banmiBean.getPhoto(), imgBaimiDetailed);
            tvBaimiDetailedName.setText(banmiBean.getName());
            tvBaimiDetailedLocation.setText(banmiBean.getLocation());
            tvFollows.setText(banmiBean.getFollowing() + getResources().getString(R.string.follow));
            if (banmiBean.isIsFollowed()) {
                imgBaimiFollow.setImageResource(R.mipmap.follow);
            } else {
                imgBaimiFollow.setImageResource(R.mipmap.follow_unselected);
            }
            tvBaimiDetailedBrief.setText(banmiBean.getOccupation());
            tvBaimiDetailedContent.setText(banmiBean.getIntroduction());
        }
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        int position = tab.getPosition();
        if (position == 0){
            supportFragmentManager.beginTransaction()
                    .show(baiMiDetaileTreadFrag)
                    .hide(baiMiDetailedLineFrag).commit();
        }
        if (position == 1){
            supportFragmentManager.beginTransaction()
                    .show(baiMiDetailedLineFrag)
                    .hide(baiMiDetaileTreadFrag).commit();
        }
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
