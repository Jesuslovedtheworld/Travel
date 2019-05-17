package com.baidu.traveleverywhere.ui.home;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.baidu.traveleverywhere.R;
import com.baidu.traveleverywhere.adapter.HomeMainVpAdapter;
import com.baidu.traveleverywhere.base.BaseActivity;
import com.baidu.traveleverywhere.bean.HomeWeiBoBean;
import com.baidu.traveleverywhere.persenter.HomePresenter;
import com.baidu.traveleverywhere.view.HomeView;
import com.jaeger.library.StatusBarUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

//
public class HomeActivity extends BaseActivity<HomeView, HomePresenter> implements HomeView {
    private static final String TAG = "HomeActivity";
    @BindView(R.id.img_head)
    ImageView imgHead;
    @BindView(R.id.img_message)
    ImageView imgMessage;
    @BindView(R.id.toolBar)
    Toolbar toolBar;
    @BindView(R.id.na)
    NavigationView na;
    @BindView(R.id.dl)
    DrawerLayout dl;
    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.tab)
    TabLayout tab;
    private int HOME_TYPE = 0;
    private int EVERY_TYPE = 1;
    private HomeFragment homeFragment;
    private EveryFragment everyFragment;
    private HomeMainVpAdapter adapter;
    private TabLayout.Tab mTabOne;
    private TabLayout.Tab mTabTwo;
    private HomePresenter mHomePresenter;
    private TwoUpMyFragment mTwoMyFragment;
    private TwoUpFollowFragment myTwoUpFollow;
    private TabLayout.Tab mTabThree;
    private TabLayout.Tab mTabFour;

    @Override
    protected HomePresenter initPersenter() {
        if (mHomePresenter == null){
            mHomePresenter = new HomePresenter();
        }
        return mHomePresenter;
    }

    @Override
    protected int getLayout() {
        return R.layout.home_layout;
    }
    @Override
    protected void initView() {
        setSupportActionBar(toolBar);
        StatusBarUtil.setLightMode(this);
        ArrayList<Fragment> baseFragments = new ArrayList<>();
        homeFragment = new HomeFragment();
        everyFragment = new EveryFragment();
        mTwoMyFragment = new TwoUpMyFragment();
        myTwoUpFollow = new TwoUpFollowFragment();
        baseFragments.add(homeFragment);//怎么玩
        baseFragments.add(everyFragment);///发现
        baseFragments.add(myTwoUpFollow);//关注
        baseFragments.add(mTwoMyFragment);//我的
        //怎么玩  发现   关注  我的
        mTabOne = tab.newTab().setText(getResources().getString(R.string.howeplay));//怎么玩
        mTabOne.setIcon(R.mipmap.banmi_highlight);
        tab.addTab(mTabOne);

        mTabTwo = tab.newTab().setText(getResources().getString(R.string.find));///发现
        mTabTwo.setIcon(R.mipmap.icon_discover_u_hdpi);
        tab.addTab(mTabTwo);


        //关注
        mTabThree = tab.newTab().setText(getResources().getString(R.string.follow));
        mTabThree.setIcon(R.mipmap.banmi_unselected);
        tab.addTab(mTabThree);

        //关注
        mTabFour = tab.newTab().setText(getResources().getString(R.string.mine));
        mTabFour.setIcon(R.mipmap.banmi_unselected);
        tab.addTab(mTabFour);

        adapter = new HomeMainVpAdapter(getSupportFragmentManager(),baseFragments);
        vp.setAdapter(adapter);
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                tab.getTabAt(0);

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        tab.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                vp.setCurrentItem(position);
                if (position == 0){
                    mTabOne.setIcon(R.mipmap.banmi_highlight);
                    mTabTwo.setIcon(R.mipmap.icon_discover_u_xxxhdpi);
                    mTabThree.setIcon(R.mipmap.banmi_unselected);
                    mTabFour.setIcon(R.mipmap.banmi_unselected);
                }
                if (position == 1){
                    mTabOne.setIcon(R.mipmap.banmi_unselected);
                    mTabTwo.setIcon(R.mipmap.icon_discover_s_xhdpi);
                    mTabThree.setIcon(R.mipmap.banmi_unselected);
                    mTabFour.setIcon(R.mipmap.banmi_unselected);
                }
                if (position == 2){
                    mTabOne.setIcon(R.mipmap.banmi_unselected);
                    mTabTwo.setIcon(R.mipmap.icon_discover_u_hdpi);
                    mTabThree.setIcon(R.mipmap.banmi_highlight);
                    mTabFour.setIcon(R.mipmap.banmi_unselected);
                }

                if (position == 3){
                    mTabOne.setIcon(R.mipmap.home_unselected);
                    mTabTwo.setIcon(R.mipmap.icon_discover_u_hdpi);
                    mTabThree.setIcon(R.mipmap.home_unselected);
                    mTabFour.setIcon(R.mipmap.banmi_highlight);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    public void onSuccess(HomeWeiBoBean bean) {

    }



    @Override
    public void onFile(String msg) {

    }



    @Override
    public void toastShort(String msg) {

    }
    @OnClick({R.id.img_head,R.id.img_message})
    public void onListener(View v) {
        switch (v.getId()) {
            case R.id.img_message:
                startActivity(new Intent(this,BaiMiViewMoreActivity.class));
                break;
        }
    }

}
