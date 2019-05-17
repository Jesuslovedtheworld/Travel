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
import com.baidu.traveleverywhere.bean.BaiMiDetailedTreadBean;
import com.baidu.traveleverywhere.bean.BaiMiDetailedbean;
import com.baidu.traveleverywhere.utils.GlideUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BaiMiDetailedAndTabRlvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<BaiMiDetailedbean.ResultBean.ActivitiesBean> mArr;
    private Context context;
    private int type;

    public BaiMiDetailedAndTabRlvAdapter(ArrayList<BaiMiDetailedbean.ResultBean.ActivitiesBean> mArr, Context context) {
        this.mArr = mArr;
        this.context = context;
    }

    public void setmArr(ArrayList<BaiMiDetailedbean.ResultBean.ActivitiesBean> mArr) {
        this.mArr = mArr;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        RecyclerView.ViewHolder holder = null;
        if (i == 0){
            View view = LayoutInflater.from(context).inflate(R.layout.music_lookall, null);
            holder = new MusicVH(view);
        }else {
            View view = LayoutInflater.from(context).inflate(R.layout.baimi_detailed_and_tab_item, null);
             holder = new VH(view);
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof MusicVH){
            Log.e("tag", "onBindViewHolder: 方法走了");

        }
        if (viewHolder instanceof VH){
            VH vh = (VH) viewHolder;
            BaiMiDetailedbean.ResultBean.ActivitiesBean reviewsBean = mArr.get(i);
            final String  img = (String) reviewsBean.getImages().get(0);
            vh.tvBaimiTabTime.setText(reviewsBean.getDate());
            GlideUtils.glide(img, vh.imgBaimiTab);
            vh.tvBaimiTabContent.setText(reviewsBean.getContent());
            vh.imgBaimiTab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (imageToBigItemOnclick != null){
                        imageToBigItemOnclick.imageOnClick(img);
                    }
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return mArr.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0){
            return 0;
        }
        return 1;
    }

    public class VH extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_baimi_tab_title)
        TextView tvBaimiTabTitle;
        @BindView(R.id.tv_baimi_tab_content)
        TextView tvBaimiTabContent;
        @BindView(R.id.img_baimi_tab)
        ImageView imgBaimiTab;
        @BindView(R.id.img_baimi_tab_praise)
        ImageView imgBaimiTabPraise;
        @BindView(R.id.tv_baimi_tab_time)
        TextView tvBaimiTabTime;

        public VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    class MusicVH extends RecyclerView.ViewHolder{

        public MusicVH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


    public interface ImageToBigItemOnclick{
        void imageOnClick(String img);
    }
    private ImageToBigItemOnclick imageToBigItemOnclick;

    public void setImageToBigItemOnclick(ImageToBigItemOnclick imageToBigItemOnclick) {
        this.imageToBigItemOnclick = imageToBigItemOnclick;
    }
}
