package com.baidu.traveleverywhere.ui.message;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.baidu.traveleverywhere.R;
import com.baidu.traveleverywhere.adapter.MessageVpAdapter;
import com.baidu.traveleverywhere.base.BaseActivity;
import com.baidu.traveleverywhere.base.BaseFragment;
import com.baidu.traveleverywhere.persenter.MessagePresenter;
import com.baidu.traveleverywhere.view.MessageView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MessageActivity extends BaseActivity<MessageView, MessagePresenter> implements MessageView {

    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.toolBar)
    Toolbar toolBar;
    @BindView(R.id.vp)
    ViewPager vp;

    @Override
    protected MessagePresenter initPersenter() {
        return new MessagePresenter();
    }

    @Override
    protected int getLayout() {
        return R.layout.message_layout;
    }

    @Override
    protected void initView() {
        setSupportActionBar(toolBar);
        toolBar.setNavigationIcon(R.mipmap.back_white);
        toolBar.setTitle("");
        ArrayList<BaseFragment> fragments = new ArrayList<>();
        ArrayList<String> titles = new ArrayList<>();
        fragments.add(new MessageFragment());
        fragments.add(new MessageInfoFragment());
        titles.add(getResources().getString(R.string.infrom));
        titles.add(getResources().getString(R.string.news));
        MessageVpAdapter adapter = new MessageVpAdapter(getSupportFragmentManager(), fragments, titles);
        vp.setAdapter(adapter);
        tab.setupWithViewPager(vp);
    }

    @Override
    public void toastShort(String msg) {

    }
}
