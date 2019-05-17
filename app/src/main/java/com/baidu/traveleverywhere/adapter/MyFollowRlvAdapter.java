package com.baidu.traveleverywhere.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.baidu.traveleverywhere.R;
import com.baidu.traveleverywhere.bean.MyFollowBean;
import com.baidu.traveleverywhere.utils.GlideUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyFollowRlvAdapter extends RecyclerView.Adapter<MyFollowRlvAdapter.VH> {

    private ArrayList<MyFollowBean.ResultBean.BanmiBean> arrayList;
    private Context context;

    public MyFollowRlvAdapter(ArrayList<MyFollowBean.ResultBean.BanmiBean> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    public void setArrayList(ArrayList<MyFollowBean.ResultBean.BanmiBean> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.my_follow_item, null);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH vh, int i) {
        if (arrayList != null && arrayList.size() > 0){
            MyFollowBean.ResultBean.BanmiBean bean = arrayList.get(i);
            Log.e("tag", "onBindViewHolder: "+bean.toString() );
            GlideUtils.glide(context,bean.getPhoto(),vh.imgFollow);
            vh.tvFollowName.setText(bean.getName());
            vh.tvFollowContent.setText(bean.getOccupation());
            vh.tvFollowTime.setText(bean.getLocation());
        }

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class VH extends RecyclerView.ViewHolder {
        @BindView(R.id.img_follow)
        ImageView imgFollow;
        @BindView(R.id.tv_follow_name)
        TextView tvFollowName;
        @BindView(R.id.tv_follow_content)
        TextView tvFollowContent;
        @BindView(R.id.img_follow_show)
        ImageView imgFollowShow;
        @BindView(R.id.tv_follow_time)
        TextView tvFollowTime;
        public VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
