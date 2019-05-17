package com.baidu.traveleverywhere.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.baidu.traveleverywhere.R;
import com.baidu.traveleverywhere.base.BaseApp;
import com.baidu.traveleverywhere.base.Constants;
import com.baidu.traveleverywhere.bean.HomeEveryBean;
import com.baidu.traveleverywhere.utils.GlideUtils;
import com.baidu.traveleverywhere.utils.SpUtil;
import com.umeng.socialize.media.Base;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeEveryRlvAdapter extends RecyclerView.Adapter<HomeEveryRlvAdapter.VH> {
    private ArrayList<HomeEveryBean.ResultBean.BanmiBean> arr;
    private Context context;
    private int changePosition;
    private int detailedId;

    public int getChangePosition() {
        return changePosition;
    }

    public void setArr(ArrayList<HomeEveryBean.ResultBean.BanmiBean> arr) {
        this.arr = arr;
    }

    public HomeEveryRlvAdapter(ArrayList<HomeEveryBean.ResultBean.BanmiBean> arr, Context context) {
        this.arr = arr;
        this.context = context;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_item, null);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final VH vh, final int i) {
        final HomeEveryBean.ResultBean.BanmiBean bean = arr.get(i);
        GlideUtils.glide(context,bean.getPhoto(),vh.imgPeople);
        vh.homeName.setText(bean.getName());
        vh.tvCare.setText(bean.getFollowing()+BaseApp.getRes().getString(R.string.follow));
        vh.tvLocal.setText(bean.getLocation());
        vh.tvAuthor.setText(bean.getOccupation());
        final boolean b = bean.isIsFollowed();
        if (b){
            vh.imgLove.setImageResource(R.mipmap.follow);
        }else {
            vh.imgLove.setImageResource(R.mipmap.follow_unselected);
        }
        detailedId = bean.getId();
        vh.imgLove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myCollectionItemId != null){
                         myCollectionItemId.onClick(detailedId,vh.imgLove,b);//将id和
                    }
            }
        });
        vh.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (detailedItemOnClick != null){
                    detailedItemOnClick.onclick(bean.getId());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return arr.size();
    }

    public class VH extends RecyclerView.ViewHolder {
        @BindView(R.id.img_people)
        ImageView imgPeople;
        @BindView(R.id.home_name)
        TextView homeName;
        @BindView(R.id.tv_care)
        TextView tvCare;
        @BindView(R.id.tv_local)
        TextView tvLocal;
        @BindView(R.id.tv_author)
        TextView tvAuthor;
        @BindView(R.id.img_love)
        ImageView imgLove;

        public VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    public interface MyCollectionItemId {
        void onClick(int id, ImageView imageView,boolean isFollow);
    }

    private MyCollectionItemId myCollectionItemId;

    public void setMyCollectionItemId(MyCollectionItemId myCollectionItemId) {
        this.myCollectionItemId = myCollectionItemId;
    }
    public interface DetailedItemOnClick{
        void onclick(int id);
    }
    private DetailedItemOnClick detailedItemOnClick;

    public void setDetailedItemOnClick(DetailedItemOnClick detailedItemOnClick) {
        this.detailedItemOnClick = detailedItemOnClick;
    }
}
