package com.baidu.traveleverywhere.ui.message;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baidu.traveleverywhere.R;
import com.baidu.traveleverywhere.adapter.MessageInfoRlvAdapter;
import com.baidu.traveleverywhere.base.BaseFragment;
import com.baidu.traveleverywhere.bean.MessageInfoData;
import com.baidu.traveleverywhere.persenter.MessageInfoFragPresenter;
import com.baidu.traveleverywhere.view.MessageInfoFraView;
import com.baidu.traveleverywhere.widget.MessageItemTouchHelperAdapter;
import com.baidu.traveleverywhere.widget.MessageSimpleItemTouchHelperCallback;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class MessageInfoFragment extends BaseFragment<MessageInfoFraView, MessageInfoFragPresenter> implements MessageInfoFraView {

    @BindView(R.id.re)
    RecyclerView re;
    @Override
    protected MessageInfoFragPresenter initPresenter() {
        return new MessageInfoFragPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.message_info_fragment;
    }

    @Override
    protected void initView() {
        re.setLayoutManager(new LinearLayoutManager(getContext()));
        ArrayList<MessageInfoData> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            MessageInfoData data = new MessageInfoData("系统通知", "09/" + i, "添加成功");
            list.add(data);
        }
        MessageInfoRlvAdapter adapter = new MessageInfoRlvAdapter(list, getContext());
        re.setAdapter(adapter);
        re.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
        //先实例化CallBack
        MessageSimpleItemTouchHelperCallback callback = new MessageSimpleItemTouchHelperCallback(adapter);
        //用CallBack构造创建ItemTouchHelper
        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(re);
    }

    @Override
    public void toastShort(String msg) {

    }
}
