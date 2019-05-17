package com.baidu.traveleverywhere.ui.aboutmy;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.baidu.traveleverywhere.R;
import com.baidu.traveleverywhere.adapter.MyCollectionRlvAdapter;
import com.baidu.traveleverywhere.base.BaseActivity;
import com.baidu.traveleverywhere.bean.MyFollowCollectionBean;
import com.baidu.traveleverywhere.persenter.MyFollowCollectionPresenter;
import com.baidu.traveleverywhere.utils.SpUtil;
import com.baidu.traveleverywhere.utils.ToastUtil;
import com.baidu.traveleverywhere.view.MyFollowCollectionView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;

import java.util.ArrayList;

import butterknife.BindView;

public class MyCollectionActivity extends BaseActivity<MyFollowCollectionView, MyFollowCollectionPresenter> implements MyFollowCollectionView {
    @BindView(R.id.re)
    RecyclerView re;
    @BindView(R.id.sr)
    SmartRefreshLayout sr;
    private ArrayList<MyFollowCollectionBean.ResultBean.CollectedRoutesBean> arrayList;
    private MyCollectionRlvAdapter adapter;
    private String token;
    private MyFollowCollectionPresenter presenter;
    private static final String TAG = "MyCollectionActivity";
    private int page = 1;
    @Override
    protected MyFollowCollectionPresenter initPersenter() {
        presenter = new MyFollowCollectionPresenter();
        return presenter;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_my_collection;
    }

    @Override
    protected void initView() {
        token = (String) SpUtil.getParam("token", "rBeRSXaoT8Y4wRYkQoyLXcWSwyKDuSNZx3WkWJlk1UHMryjUWhtIYeVNyVwQnajTfg9titlPUKpyAcoB3ZuLmfx0v0GS8kauACdv8cL6mIo1ibbimNsjLlY9N55RA7hA3iw");
        re.setLayoutManager(new LinearLayoutManager(this));
        arrayList = new ArrayList<>();
        adapter = new MyCollectionRlvAdapter(arrayList,this);
        re.setAdapter(adapter);
        sr.setOnRefreshLoadmoreListener(new OnRefreshLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {//加赞更多
                page ++;
                presenter.getCollection(token,page);
            }

            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                arrayList.clear();
                page = 1;
                presenter.getCollection(token,page);

            }
        });
    }

    @Override
    protected void initData() {
        presenter.getCollection(token,page);
    }

    @Override
    public void toastShort(String msg) {

    }

    @Override
    public void onSuccess(MyFollowCollectionBean bean) {
            if (bean != null){
                sr.finishLoadmore();
                sr.finishRefresh();
                arrayList.addAll(bean.getResult().getCollectedRoutes());
                adapter.notifyDataSetChanged();

            }
    }

    @Override
    public void onFail(String msg) {
        ToastUtil.showShort(msg);
    }
}
