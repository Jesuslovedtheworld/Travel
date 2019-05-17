package com.baidu.traveleverywhere.ui.home;


import android.support.v4.app.Fragment;

import com.baidu.mapapi.map.MapView;
import com.baidu.traveleverywhere.R;
import com.baidu.traveleverywhere.base.BaseFragment;
import com.baidu.traveleverywhere.persenter.EmptyPresenter;
import com.baidu.traveleverywhere.persenter.TwoUpFollowPresenter;
import com.baidu.traveleverywhere.view.EmptyView;
import com.baidu.traveleverywhere.view.TwoUpFollowView;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class TwoUpFollowFragment extends BaseFragment<TwoUpFollowView, TwoUpFollowPresenter> implements EmptyView {


    @BindView(R.id.bmapView)
    MapView mMap;
    private MapView mMapView;
    private TwoUpFollowPresenter twoUpFollowPresenter;

    @Override
    protected TwoUpFollowPresenter initPresenter() {
        if (twoUpFollowPresenter == null){
            twoUpFollowPresenter = new TwoUpFollowPresenter();
        }
        return twoUpFollowPresenter;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_two_up_follow;
    }


    @Override
    protected void initView() {
        mMapView = new MapView(getContext());
        //开启地图的定位图层



    }


    @Override
    public void onResume() {
        super.onResume();
       // 在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mMap.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mMap.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mMap.onDestroy();
    }

    @Override
    public void toastShort(String msg) {

    }


}
