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
import com.baidu.traveleverywhere.bean.UserMessageBean;
import com.baidu.traveleverywhere.persenter.FragHomePresenter;
import com.baidu.traveleverywhere.ui.main.WebViewActivity;
import com.baidu.traveleverywhere.utils.SpUtil;
import com.baidu.traveleverywhere.utils.ToastUtil;
import com.baidu.traveleverywhere.view.FragHomeView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;

import java.net.URL;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;



/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment<FragHomeView, FragHomePresenter> implements FragHomeView, HomeRlvAdapter.ItemOnClick, HomeRlvAdapter.smallOnClick {
    @BindView(R.id.smarl)
    SmartRefreshLayout smarl;
    Unbinder unbinder;
    private String token = "rBeRSXaoT8Y4wRYkQoyLXcWSwyKDuSNZx3WkWJlk1UHMryjUWhtIYeVNyVwQnajTfg9titlPUKpyAcoB3ZuLmfx0v0GS8kauACdv8cL6mIo1ibbimNsjLlY9N55RA7hA3iw";
    private static final String TAG = "HomeFragment";
    @BindView(R.id.re)
    RecyclerView re;
    private FragHomePresenter presenter;
    private ArrayList<HomeListData.ResultBean.BannersBean> bannersBeans;
    private ArrayList<HomeListData.ResultBean.RoutesBean> listBeans;
    private HomeRlvAdapter adapter;
    private int page = 1;
    @Override
    protected FragHomePresenter initPresenter() {
        presenter = new FragHomePresenter();
        return presenter;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        SpUtil.setParam("token", token);
        re.setLayoutManager(new LinearLayoutManager(getContext()));
        bannersBeans = new ArrayList<>();
        listBeans = new ArrayList<>();
        adapter = new HomeRlvAdapter(bannersBeans, listBeans, getContext());
        re.setAdapter(adapter);
        adapter.setItemOnClick(this);
        adapter.setSmallOnClick(this);
    }

    @Override
    protected void initData() {
        presenter.getData(token,page);//iinitData调用方法

    }

    @Override
    protected void initListener() {
        smarl.setOnRefreshLoadmoreListener(new OnRefreshLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                    page ++;
                    presenter.getData(token,page);
            }

            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                    bannersBeans.clear();
                    listBeans.clear();
                    page = 1;
                    presenter.getData(token,page);
            }
        });
    }

    @Override
    public void onSuccess(HomeListData bean) {
        if (bean != null) {
            smarl.finishRefresh();
            smarl.finishLoadmore();
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
    public void toastShort(String msg) {
            ToastUtil.showShort(msg);
    }

    @Override
    public void onClick(int id) {
        Intent intent = new Intent(getContext(), HomeInfoActivity.class);
        intent.putExtra("id", id);
        intent.putExtra("token", token);
        startActivity(intent);

    }

    //html链接  需要加载WebVIew
    @Override
    public void smallOncLick(String url) {
        Intent intent = new Intent(getContext(),AndroidJsWebActivity.class);
        intent.putExtra(Constants.WEBURL,url);
        startActivity(intent);
    }


}
