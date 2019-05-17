package com.baidu.traveleverywhere.adapter;

import android.content.Context;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.baidu.traveleverywhere.R;
import com.baidu.traveleverywhere.bean.HomeListData;
import com.baidu.traveleverywhere.utils.GlideUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeRlvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int BANNER_TYPE = 0;
    private static final int LIST_TYPE = 1;
    private static final int SMALL_TYPE = 2;
    private ArrayList<HomeListData.ResultBean.BannersBean> banners;
    private ArrayList<HomeListData.ResultBean.RoutesBean> list;
    private Context context;
    private String cardURL;
    private String contentURL;
    private HomeListData.ResultBean.RoutesBean bean;
    private int moreId;

    public HomeRlvAdapter(ArrayList<HomeListData.ResultBean.BannersBean> banners, ArrayList<HomeListData.ResultBean.RoutesBean> list, Context context) {
        this.banners = banners;
        this.list = list;
        this.context = context;
    }

    public void setBanners(ArrayList<HomeListData.ResultBean.BannersBean> banners) {
        this.banners = banners;
    }

    public void setList(ArrayList<HomeListData.ResultBean.RoutesBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        RecyclerView.ViewHolder holder = null;
        if (i == BANNER_TYPE) {
            View view = LayoutInflater.from(context).inflate(R.layout.home_banner, null);
            holder = new BannerVH(view);
        }
        if (i == LIST_TYPE) {
            View view = LayoutInflater.from(context).inflate(R.layout.home_item_list, null);
            holder = new ListVH(view);
        }
        if (i == SMALL_TYPE) {
            View view = LayoutInflater.from(context).inflate(R.layout.home_item_list_small, null);
            holder = new SmallVH(view);
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        int type = viewHolder.getItemViewType();
        bean = list.get(i);
        if (type == BANNER_TYPE) {
            final BannerVH bannerVH = (BannerVH) viewHolder;
            ArrayList<String> bannerList = new ArrayList<>();
            for (HomeListData.ResultBean.BannersBean banner : banners) {
                bannerList.add(banner.getImageURL());
            }
            bannerVH.banner.setImages(bannerList);
            bannerVH.banner.setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    Glide.with(context).load(path).into(imageView);

                }
            });
            bannerVH.banner.start();
        }

        if (type == LIST_TYPE) {
            ListVH listVH = (ListVH) viewHolder;
            if (bean.getType().equals("route")) {
                final int mIdIndex = bean.getId();
                HomeListData.ResultBean.RoutesBean routesBean = list.get(i);
                listVH.tvTitle.setText(routesBean.getTitle());
                Glide.with(context).load(routesBean.getCardURL()).into(listVH.imgBig);
                listVH.tvLocal.setText(routesBean.getCity());
                listVH.tv_time.setText(routesBean.getIntro());
                int priceInCents = routesBean.getPriceInCents();
                listVH.btnPay.setText("￥" + priceInCents + "元");
                listVH.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (itemOnClick != null) {
                            itemOnClick.onClick(mIdIndex);
                        }
                    }
                });
            }

        }
        if (type == SMALL_TYPE) {
            SmallVH smallVH = (SmallVH) viewHolder;
            if (bean.getType().equals("bundle")){
                 cardURL = bean.getCardURL();
                 contentURL = bean.getContentURL();
            }
            //设置图片圆角角度
            RoundedCorners roundedCorners = new RoundedCorners(10);
            //通过RequestOptions扩展功能,override:采样率,因为ImageView就这么大,可以压缩图片,降低内存消耗
            // RequestOptions options = RequestOptions.bitmapTransform(roundedCorners).override(300, 300);
            RequestOptions options = RequestOptions.bitmapTransform(roundedCorners);
            Glide.with(context).load(cardURL).apply(options).into(smallVH.imgSingle);
            smallVH.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (smallOnClick != null) {
                        smallOnClick.smallOncLick(contentURL);
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {//如果有banner 下标0为banner
            return BANNER_TYPE;
        }
        if (list.get(position).getType().equals("bundle")) {
            moreId ++;
            return SMALL_TYPE;//如果集合的类型为bundle  加载图片布局
        }
        return LIST_TYPE;


    }

    class BannerVH extends RecyclerView.ViewHolder {
        @BindView(R.id.banner)
        Banner banner;

        public BannerVH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    class SmallVH extends RecyclerView.ViewHolder {
        @BindView(R.id.img_single)
        ImageView imgSingle;

        public SmallVH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    class ListVH extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_time)
        TextView tv_time;
        @BindView(R.id.tv_local)
        TextView tvLocal;
        @BindView(R.id.btn_pay)
        Button btnPay;
        @BindView(R.id.img_big)
        ImageView imgBig;

        public ListVH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface ItemOnClick {
        void onClick(int id);
    }

    private ItemOnClick itemOnClick;

    public void setItemOnClick(ItemOnClick itemOnClick) {
        this.itemOnClick = itemOnClick;
    }

    public interface smallOnClick {
        void smallOncLick(String url);
    }

    private smallOnClick smallOnClick;

    public void setSmallOnClick(HomeRlvAdapter.smallOnClick smallOnClick) {
        this.smallOnClick = smallOnClick;
    }
}
