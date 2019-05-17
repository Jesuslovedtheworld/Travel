package com.baidu.traveleverywhere.ui.home;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baidu.traveleverywhere.R;
import com.baidu.traveleverywhere.adapter.HomeRlvAdapter;
import com.baidu.traveleverywhere.base.BaseFragment;
import com.baidu.traveleverywhere.base.Constants;
import com.baidu.traveleverywhere.bean.HomeListData;
import com.baidu.traveleverywhere.persenter.BaiMiDetailedLinePresenter;
import com.baidu.traveleverywhere.ui.main.WebViewActivity;
import com.baidu.traveleverywhere.utils.SpUtil;
import com.baidu.traveleverywhere.utils.ToastUtil;
import com.baidu.traveleverywhere.view.BaiMiDetailedLineView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class BaiMiDetailedLineFrag extends BaseFragment<BaiMiDetailedLineView, BaiMiDetailedLinePresenter> implements BaiMiDetailedLineView, HomeRlvAdapter.ItemOnClick, HomeRlvAdapter.smallOnClick {


    @BindView(R.id.re_line)
    RecyclerView reLine;
    private BaiMiDetailedLinePresenter presenter;
    private ArrayList<HomeListData.ResultBean.BannersBean> bannersBeans;
    private ArrayList<HomeListData.ResultBean.RoutesBean> listBeans;
    private HomeRlvAdapter adapter;
    private int page = 1;
    @Override
    protected BaiMiDetailedLinePresenter initPresenter() {
        if (presenter == null) {
            presenter = new BaiMiDetailedLinePresenter();
        }
        return presenter;
    }

    @Override
    protected void initView() {
        reLine.setLayoutManager(new LinearLayoutManager(getContext()));
        bannersBeans = new ArrayList<>();
        listBeans = new ArrayList<>();
        adapter = new HomeRlvAdapter(bannersBeans, listBeans, getContext());
        reLine.setAdapter(adapter);
        adapter.setItemOnClick(this);
        adapter.setSmallOnClick(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_bai_mi_detailed_line;
    }

    @Override
    protected void initData() {
        presenter.getData(Constants.TOKEN_CONTENT,page);//iinitData调用方法
    }

    @Override
    public void toastShort(String msg) {

    }

    @Override
    public void onSuccess(HomeListData bean) {
        if (bean != null) {
            bannersBeans.addAll(bean.getResult().getBanners());
            listBeans.addAll(bean.getResult().getRoutes());
            adapter.setList(listBeans);
            adapter.setBanners(bannersBeans);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onFile(String msg) {
        if (msg != null) {
            ToastUtil.showShort(msg);
        }
    }

    @Override
    public void onClick(int id) {
        Intent intent = new Intent(getContext(), HomeInfoActivity.class);
        intent.putExtra("id",id);
        startActivity(intent);
    }

    @Override
    public void smallOncLick(String url) {
        Intent intent = new Intent(getContext(), WebViewActivity.class);
        intent.putExtra(Constants.WEBURL,url);
        startActivity(intent);
    }
}
