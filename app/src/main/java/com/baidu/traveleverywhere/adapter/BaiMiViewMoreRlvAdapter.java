package com.baidu.traveleverywhere.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.baidu.traveleverywhere.R;
import com.baidu.traveleverywhere.bean.BaiMiViewMoreBean;
import com.baidu.traveleverywhere.utils.GlideUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BaiMiViewMoreRlvAdapter extends RecyclerView.Adapter<BaiMiViewMoreRlvAdapter.VH> {
    private ArrayList<BaiMiViewMoreBean.ResultBean.BundlesBean> mArr;
    private Context context;

    public BaiMiViewMoreRlvAdapter(ArrayList<BaiMiViewMoreBean.ResultBean.BundlesBean> mArr, Context context) {
        this.mArr = mArr;
        this.context = context;
    }

    public void setmArr(ArrayList<BaiMiViewMoreBean.ResultBean.BundlesBean> mArr) {
        this.mArr = mArr;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_item_list_small, null);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH vh, int i) {
        if (mArr != null && mArr.size() > 0){
            BaiMiViewMoreBean.ResultBean.BundlesBean bean = mArr.get(i);
            GlideUtils.glide(bean.getCardURL(),vh.imgSingle);//设置图片
        }
    }

    @Override
    public int getItemCount() {
        return mArr.size();
    }

    public class VH extends RecyclerView.ViewHolder {
        @BindView(R.id.img_single)
        ImageView imgSingle;
        public VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
