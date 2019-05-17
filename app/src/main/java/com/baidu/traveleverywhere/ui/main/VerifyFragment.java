package com.baidu.traveleverywhere.ui.main;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.baidu.traveleverywhere.R;
import com.baidu.traveleverywhere.base.BaseFragment;
import com.baidu.traveleverywhere.persenter.EmptyPresenter;
import com.baidu.traveleverywhere.view.EmptyView;

/**
 * A simple {@link Fragment} subclass.
 */
public class VerifyFragment extends BaseFragment<EmptyView, EmptyPresenter> implements EmptyView {
    @Override
    protected EmptyPresenter initPresenter() {
        return new EmptyPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.loginorbind;
    }

    @Override
    public void toastShort(String msg) {

    }
}
