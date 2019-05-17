package com.baidu.traveleverywhere.ui.aboutmy;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.baidu.traveleverywhere.R;
import com.baidu.traveleverywhere.adapter.MyFollowRlvAdapter;
import com.baidu.traveleverywhere.base.BaseActivity;
import com.baidu.traveleverywhere.bean.MyFollowBean;
import com.baidu.traveleverywhere.persenter.MyFollowPresenter;
import com.baidu.traveleverywhere.utils.SpUtil;
import com.baidu.traveleverywhere.utils.ToastUtil;
import com.baidu.traveleverywhere.view.MyFollowView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;

import java.util.ArrayList;

import butterknife.BindView;

public class MyFollowActivity extends BaseActivity<MyFollowView, MyFollowPresenter> implements MyFollowView {
    @BindView(R.id.re)
    RecyclerView re;
    @BindView(R.id.smart)
    SmartRefreshLayout smart;
    private ArrayList<MyFollowBean.ResultBean.BanmiBean> mArr;
    private MyFollowRlvAdapter adapter;
    private MyFollowPresenter presenter;
    private int page = 1;
    private String token;

    @Override
    protected MyFollowPresenter initPersenter() {
        if (presenter == null){
            presenter = new MyFollowPresenter();
        }
        return presenter;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_my_follow;
    }

    @Override
    protected void initView() {
        re.setLayoutManager(new LinearLayoutManager(this));
        mArr = new ArrayList<>();
        adapter = new MyFollowRlvAdapter(mArr, this);
        re.setAdapter(adapter);
        smart.setOnRefreshLoadmoreListener(new OnRefreshLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                page ++;
                presenter.getFollowData(token,page);
            }

            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                mArr.clear();
                page = 1;
                presenter.getFollowData(token,page);
            }
        });
    }

    @Override
    protected void initData() {
        token = (String) SpUtil.getParam("token", "rBeRSXaoT8Y4wRYkQoyLXcWSwyKDuSNZx3WkWJlk1UHMryjUWhtIYeVNyVwQnajTfg9titlPUKpyAcoB3ZuLmfx0v0GS8kauACdv8cL6mIo1ibbimNsjLlY9N55RA7hA3iw");
        presenter.getFollowData(token,page);
    }

    @Override
    public void onResume() {
        if (token != null){
            presenter.getFollowData(token,page);
        }
        super.onResume();
    }

    @Override
    public void toastShort(String msg) {

    }

    @Override
    public void onSuccess(MyFollowBean bean) {
            if (bean != null){
                smart.finishLoadmore();
                smart.finishRefresh();
                mArr.addAll(bean.getResult().getBanmi());
                adapter.setArrayList(mArr);
                adapter.notifyDataSetChanged();
            }
    }

    @Override
    public void onFail(String msg) {
        ToastUtil.showShort(msg);
    }
}
