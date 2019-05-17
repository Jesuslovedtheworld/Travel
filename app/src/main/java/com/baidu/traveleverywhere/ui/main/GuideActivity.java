package com.baidu.traveleverywhere.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.baidu.traveleverywhere.R;
import com.baidu.traveleverywhere.adapter.GuideVpAdapter;
import com.baidu.traveleverywhere.base.BaseActivity;
import com.baidu.traveleverywhere.persenter.EmptyPresenter;
import com.baidu.traveleverywhere.utils.PreviewIndicator;
import com.baidu.traveleverywhere.utils.SpUtil;
import com.baidu.traveleverywhere.view.EmptyView;
import com.umeng.socialize.media.Base;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/*
 * *  author gme
 *    time
 *      引导界面
 */
public class GuideActivity extends BaseActivity<EmptyView,EmptyPresenter> implements EmptyView,ViewPager.OnPageChangeListener {


    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.pre)
    PreviewIndicator pre;
    @BindView(R.id.btn_immediately)
    Button btnImmediately;
    private View oneView;
    private View twoView;
    private View threeView;
    @Override
    protected EmptyPresenter initPersenter() {
        return new EmptyPresenter();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_guide;
    }

    @Override
    protected void initView() {
        initPager();
        setPreview();
    }

    private void setPreview() {
        pre.setNumbers(3);
        pre.initSize(70,10,5);
    }

    private void initPager() {
        oneView = getLayoutInflater().inflate(R.layout.guile_one_page, null);
        twoView = getLayoutInflater().inflate(R.layout.guile_two_page, null);
        threeView = getLayoutInflater().inflate(R.layout.guile_three_page, null);
        ArrayList<View> views = new ArrayList<>();
        views.add(oneView);
        views.add(twoView);
        views.add(threeView);
        GuideVpAdapter adapter = new GuideVpAdapter(views);
        vp.setAdapter(adapter);
        vp.addOnPageChangeListener(this);
    }

    //选中的下标监听
    @Override
    public void onPageScrolled(int i, float v, int i1) {
        btnImmediately.setVisibility(View.GONE);
        pre.setSelected(i);
        if (i == 2) {
            btnImmediately.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onPageSelected(int i) {

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    @OnClick(R.id.btn_immediately)
    public void onViewClicked() {
        SpUtil.setParam("guide",true);
        startActivity(new Intent(this,LoginActivity.class));
        finish();
    }

    @Override
    public void toastShort(String msg) {

    }
}
