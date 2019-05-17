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
import android.widget.ImageView;

import com.baidu.traveleverywhere.R;
import com.baidu.traveleverywhere.adapter.HomeEveryRlvAdapter;
import com.baidu.traveleverywhere.base.BaseFragment;
import com.baidu.traveleverywhere.base.Constants;
import com.baidu.traveleverywhere.bean.CollectionOrClierBean;
import com.baidu.traveleverywhere.bean.HomeBaimiFollow;
import com.baidu.traveleverywhere.bean.HomeEveryBean;
import com.baidu.traveleverywhere.persenter.FragEveryPresenter;
import com.baidu.traveleverywhere.utils.SpUtil;
import com.baidu.traveleverywhere.utils.ToastUtil;
import com.baidu.traveleverywhere.view.FrageveryView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class EveryFragment extends BaseFragment<FrageveryView, FragEveryPresenter> implements FrageveryView, HomeEveryRlvAdapter.MyCollectionItemId, HomeEveryRlvAdapter.DetailedItemOnClick {

    @BindView(R.id.re)
    RecyclerView re;
    private FragEveryPresenter presenter;
    private ArrayList<HomeEveryBean.ResultBean.BanmiBean> arrayList;
    private HomeEveryRlvAdapter adapter;
    private int page = 1;
    private String token = "rBeRSXaoT8Y4wRYkQoyLXcWSwyKDuSNZx3WkWJlk1UHMryjUWhtIYeVNyVwQnajTfg9titlPUKpyAcoB3ZuLmfx0v0GS8kauACdv8cL6mIo1ibbimNsjLlY9N55RA7hA3iw";

    @Override
    protected FragEveryPresenter initPresenter() {
        presenter = new FragEveryPresenter();
        return presenter;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_every;
    }

    @Override
    protected void initView() {
        re.setLayoutManager(new LinearLayoutManager(getContext()));
        arrayList = new ArrayList<>();
        adapter = new HomeEveryRlvAdapter(arrayList, getContext());
        re.setAdapter(adapter);
        adapter.setMyCollectionItemId(this);
        adapter.setDetailedItemOnClick(this);

    }

    @Override
    protected void initData() {
        presenter.getBaiMiData(token, page);
    }

    @Override
    public void toastShort(String msg) {

    }

    @Override
    public void onSuccess(HomeEveryBean bean) {
        if (bean != null) {
            arrayList.addAll(bean.getResult().getBanmi());
            adapter.setArr(arrayList);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onFail(String msg) {

    }

    @Override
    public void onFollow(HomeBaimiFollow homeBaimiFollow) {
        if (homeBaimiFollow != null) {//收藏成功
            ToastUtil.showShort(homeBaimiFollow.getResult().getMessage());
        }
    }

    @Override
    public void onFollowFail(String msg) {
        if (msg != null) {
            ToastUtil.showShort(getResources().getString(R.string.collection_fail));
        }
    }

    @Override
    public void onClick(int id, ImageView imageView, boolean followed) {//获取关注状态
        if (followed) {//如果已经关注
            presenter.postUnFollow(id, token);
            imageView.setImageResource(R.mipmap.follow_unselected);
        } else {
            presenter.postFollow(id, token);
            imageView.setImageResource(R.mipmap.follow);
        }
    }
    //条目监听
    @Override
    public void onclick(int id) {
        Log.e("music", "音乐的九点: "+id );
        Intent intent = new Intent(getContext(), BaimiDetailedAndTabActivity.class);
        intent.putExtra("detailedid",id);
        intent.putExtra("token",token);
        startActivity(intent);
    }
}
