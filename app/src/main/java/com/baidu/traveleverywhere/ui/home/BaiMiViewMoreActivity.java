package com.baidu.traveleverywhere.ui.home;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.baidu.traveleverywhere.R;
import com.baidu.traveleverywhere.adapter.BaiMiViewMoreRlvAdapter;
import com.baidu.traveleverywhere.base.BaseActivity;
import com.baidu.traveleverywhere.base.Constants;
import com.baidu.traveleverywhere.bean.BaiMiViewMoreBean;
import com.baidu.traveleverywhere.persenter.BaiMiViewMorePresenter;
import com.baidu.traveleverywhere.utils.ToastUtil;
import com.baidu.traveleverywhere.view.BaiMiViewMoreView;

import java.util.ArrayList;

import butterknife.BindView;

public class BaiMiViewMoreActivity extends BaseActivity<BaiMiViewMoreView, BaiMiViewMorePresenter> implements BaiMiViewMoreView {

    @BindView(R.id.re_more)
    RecyclerView reMore;
    private BaiMiViewMorePresenter miViewMorePresenter;
    private ArrayList<BaiMiViewMoreBean.ResultBean.BundlesBean> miViewMoreBeans;
    private BaiMiViewMoreRlvAdapter miViewMoreRlvAdapter;

    @Override
    protected BaiMiViewMorePresenter initPersenter() {
        if (miViewMorePresenter == null) {
            miViewMorePresenter = new BaiMiViewMorePresenter();
        }
        return miViewMorePresenter;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_bai_mi_view_more;
    }

    @Override
    protected void initView() {
        reMore.setLayoutManager(new LinearLayoutManager(this));
        miViewMoreBeans = new ArrayList<>();
        miViewMoreRlvAdapter = new BaiMiViewMoreRlvAdapter(miViewMoreBeans, this);
        reMore.setAdapter(miViewMoreRlvAdapter);
    }

    @Override
    protected void initData() {
        miViewMorePresenter.getViewMore(Constants.TOKEN_CONTENT);
    }

    @Override
    public void toastShort(String msg) {

    }

    @Override
    public void onSuccess(BaiMiViewMoreBean bean) {
            if (bean != null){
                miViewMoreBeans.addAll(bean.getResult().getBundles());
                miViewMoreRlvAdapter.setmArr(miViewMoreBeans);
                miViewMoreRlvAdapter.notifyDataSetChanged();
            }
    }

    @Override
    public void onFail(String msg) {
        ToastUtil.showShort(msg);
    }
}
