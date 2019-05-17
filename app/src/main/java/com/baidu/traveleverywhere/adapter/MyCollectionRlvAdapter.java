package com.baidu.traveleverywhere.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.baidu.traveleverywhere.R;
import com.baidu.traveleverywhere.bean.MyFollowCollectionBean;
import com.baidu.traveleverywhere.utils.GlideUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyCollectionRlvAdapter extends RecyclerView.Adapter<MyCollectionRlvAdapter.VH> {

    private ArrayList<MyFollowCollectionBean.ResultBean.CollectedRoutesBean> arr;
    private Context context;
    private int TYPE = 0;

    public void setArr(ArrayList<MyFollowCollectionBean.ResultBean.CollectedRoutesBean> arr) {
        this.arr = arr;
    }

    public MyCollectionRlvAdapter(ArrayList<MyFollowCollectionBean.ResultBean.CollectedRoutesBean> arr, Context context) {
        this.arr = arr;
        this.context = context;

    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.my_collection_item, null);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final VH vh, int i) {
        MyFollowCollectionBean.ResultBean.CollectedRoutesBean bean = arr.get(i);
        GlideUtils.glide(context,bean.getCardURL(),vh.img);
        vh.tvtitle.setText(bean.getTitle());
        vh.tvcontent.setText(bean.getIntro());
    }

    @Override
    public int getItemCount() {
        return arr.size();
    }

    public class VH extends RecyclerView.ViewHolder {
        @BindView(R.id.img)
        ImageView img;
        @BindView(R.id.tvtitle)
        TextView tvtitle;
        @BindView(R.id.tvcontent)
        TextView tvcontent;
        public VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface MyCollectionItemId {
        void onClick(int id, int type);
    }

    private MyCollectionItemId myCollectionItemId;

    public void setMyCollectionItemId(MyCollectionItemId myCollectionItemId) {
        this.myCollectionItemId = myCollectionItemId;
    }
}
