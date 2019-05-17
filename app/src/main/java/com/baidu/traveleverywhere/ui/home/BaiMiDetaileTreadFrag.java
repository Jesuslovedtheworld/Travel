package com.baidu.traveleverywhere.ui.home;

import android.annotation.SuppressLint;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.baidu.traveleverywhere.R;
import com.baidu.traveleverywhere.adapter.BaiMiDetailedAndTabRlvAdapter;
import com.baidu.traveleverywhere.base.BaseFragment;
import com.baidu.traveleverywhere.base.Constants;
import com.baidu.traveleverywhere.bean.BaiMiDetailedTreadBean;
import com.baidu.traveleverywhere.bean.BaiMiDetailedbean;
import com.baidu.traveleverywhere.persenter.BaiMiDetailedTreadPreenter;
import com.baidu.traveleverywhere.view.BaiMiDetailedTreadView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;

import butterknife.BindView;

@SuppressLint("ValidFragment")
public class BaiMiDetaileTreadFrag extends BaseFragment<BaiMiDetailedTreadView, BaiMiDetailedTreadPreenter>  implements BaiMiDetailedTreadView{
    private static final String TAG = "BaiMiDetaileTreadFrag";
    @BindView(R.id.re_tread)
    RecyclerView reTread;
    @BindView(R.id.smart_line)
    SmartRefreshLayout smartLine;
    private BaiMiDetailedTreadPreenter preenter;
    private ArrayList<BaiMiDetailedbean.ResultBean.ActivitiesBean> mArr;
    private BaiMiDetailedAndTabRlvAdapter mAdapter;
    private int page = 1;
    private final int mId;

    @SuppressLint("ValidFragment")
    public BaiMiDetaileTreadFrag(int detailedId) {
        mId = detailedId;
        Log.e(TAG, "BaiMiDetaileTreadFrag:点击的ID"+mId );
    }

    @Override
    protected BaiMiDetailedTreadPreenter initPresenter() {
        if (preenter == null) {
            preenter = new BaiMiDetailedTreadPreenter();
        }
        return preenter;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_bai_mi_detaile_tread;
    }

    @Override
    protected void initView() {
            reTread.setLayoutManager(new LinearLayoutManager(getContext()));
            mArr = new ArrayList<>();
            mAdapter = new BaiMiDetailedAndTabRlvAdapter(mArr, getContext());
            reTread.setAdapter(mAdapter);
    }

    @Override
    protected void initData() {
         preenter.getBaiMiDetailed(Constants.TOKEN_CONTENT, mId);
    }

    @Override
    public void toastShort(String msg) {

    }

    @Override
    public void onSuccess(BaiMiDetailedTreadBean bean) {

    }

    @Override
    public void onFail(String msg) {

    }

    @Override
    public void onReviews(BaiMiDetailedbean bean) {
            if (bean != null){
                mArr.addAll(bean.getResult().getActivities());
                mAdapter.setmArr(mArr);
                mAdapter.notifyDataSetChanged();
            }
    }
}
