package com.baidu.traveleverywhere.ui.message;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.baidu.traveleverywhere.R;
import com.baidu.traveleverywhere.base.BaseFragment;
import com.baidu.traveleverywhere.persenter.MessageFragPresenter;
import com.baidu.traveleverywhere.view.MessageFragView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends BaseFragment<MessageFragView,MessageFragPresenter>implements MessageFragView {

    @Override
    protected MessageFragPresenter initPresenter() {
        return new MessageFragPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.message_fragment;
    }

    @Override
    public void toastShort(String msg) {

    }
}
