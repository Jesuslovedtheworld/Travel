package com.baidu.traveleverywhere.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.baidu.traveleverywhere.R;
import com.baidu.traveleverywhere.base.BaseActivity;
import com.baidu.traveleverywhere.persenter.BaimIDetailedpresenter;
import com.baidu.traveleverywhere.view.BaiMiDetaileView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BaimiDetailedActivity extends BaseActivity<BaiMiDetaileView, BaimIDetailedpresenter> implements BaiMiDetaileView  {
    @BindView(R.id.baimi_detailed_toolbar)
    Toolbar baimiDetailedToolbar;

    private BaimIDetailedpresenter detailedpresenter;
    @Override
    protected BaimIDetailedpresenter initPersenter() {
        if (detailedpresenter == null){
            detailedpresenter = new BaimIDetailedpresenter();
        }
        return detailedpresenter;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_baimi_detailed;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) { //创建选择菜单
        getMenuInflater().inflate(R.menu.baimi_share, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void toastShort(String msg) {

    }

}
