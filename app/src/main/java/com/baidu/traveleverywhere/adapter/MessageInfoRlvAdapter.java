package com.baidu.traveleverywhere.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.baidu.traveleverywhere.R;
import com.baidu.traveleverywhere.bean.MessageInfoData;
import com.baidu.traveleverywhere.utils.Logger;
import com.baidu.traveleverywhere.widget.MessageItemTouchHelperAdapter;

import java.util.ArrayList;
import java.util.Collections;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MessageInfoRlvAdapter extends RecyclerView.Adapter<MessageInfoRlvAdapter.VH> implements MessageItemTouchHelperAdapter {
    private static final String TAG = "MessageInfoRlvAdapter";
    private ArrayList<MessageInfoData> list;
    private Context context;

    public MessageInfoRlvAdapter(ArrayList<MessageInfoData> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.message_info_item, null);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH vh, int i) {
        MessageInfoData data = list.get(i);
        if (data != null){
            vh.info.setText(data.getInfo());
            vh.time.setText(data.getTime());
            vh.inform.setText(data.getInform());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        //交换位置
        Collections.swap(list,fromPosition,toPosition);
        notifyItemMoved(fromPosition,toPosition);
    }

    @Override
    public void onItemDelete(int position) {
        //删除数据
        Log.d(TAG, "onItemDelete:记录的下标 "+position);
        list.remove(position);
        notifyItemRemoved(position);
    }

    public class VH extends RecyclerView.ViewHolder {
        @BindView(R.id.info)
        TextView info;
        @BindView(R.id.time)
        TextView time;
        @BindView(R.id.inform)
        TextView inform;
        public VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
