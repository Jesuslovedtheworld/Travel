package com.baidu.traveleverywhere.ui.home;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.traveleverywhere.R;
import com.baidu.traveleverywhere.adapter.HomeInfoVpAdapter;
import com.baidu.traveleverywhere.base.BaseActivity;
import com.baidu.traveleverywhere.base.Constants;
import com.baidu.traveleverywhere.bean.CollectionOrClierBean;
import com.baidu.traveleverywhere.bean.HomeInfomation;
import com.baidu.traveleverywhere.persenter.HomeInfoPresenter;
import com.baidu.traveleverywhere.utils.GlideUtils;
import com.baidu.traveleverywhere.utils.ToastUtil;
import com.baidu.traveleverywhere.view.BaiMiDetailedAndTabView;
import com.baidu.traveleverywhere.view.HomeInfoView;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.editorpage.ShareActivity;
import com.umeng.socialize.media.UMImage;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class HomeInfoActivity extends BaseActivity<HomeInfoView, HomeInfoPresenter> implements HomeInfoView {
    private static final String TAG = "HomeInfoActivity";
    @BindView(R.id.tv_local)
    TextView tvLocal;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.img_close)
    ImageView imgClose;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.img_big)
    ImageView imgBig;
    @BindView(R.id.tv_big_content)
    TextView tvBigContent;
    @BindView(R.id.img_two)
    ImageView imgTwo;
    @BindView(R.id.tv_haitui)
    TextView tvHaitui;
    @BindView(R.id.tv_haitui_time)
    TextView tvHaituiTime;
    @BindView(R.id.tv_haitui_content)
    TextView tvHaituiContent;
    @BindView(R.id.img_baimi)
    ImageView imgBaimi;
    @BindView(R.id.tv_baimi_location)
    TextView tvBaimiLocation;
    @BindView(R.id.tv_baimi_count)
    TextView tvBaimiCount;
    @BindView(R.id.tv_baimi_name)
    TextView tvBaimiName;
    @BindView(R.id.tv_baimi_zhiye)
    TextView tvBaimiZhiye;
    @BindView(R.id.tv_three)
    TextView tvThree;
    @BindView(R.id.img_one_four)
    ImageView imgOneFour;
    @BindView(R.id.img_two_four)
    ImageView imgTwoFour;
    @BindView(R.id.img_three_four)
    ImageView imgThreeFour;
    @BindView(R.id.img_four_four)
    ImageView imgFourFour;
    @BindView(R.id.imgthree)
    ImageView imgthree;
    @BindView(R.id.tv_three_name)
    TextView tvThreeName;
    @BindView(R.id.tvthreetime)
    TextView tvthreetime;
    @BindView(R.id.img_three)
    ImageView img_three;
    @BindView(R.id.tv_four_name)
    TextView tvFourName;
    @BindView(R.id.tv_four_time)
    TextView tvFourTime;
    @BindView(R.id.tv_four_count)
    TextView tvFourCount;
    @BindView(R.id.view_line_three)
    View viewLineThree;
    @BindView(R.id.watchall)
    TextView watchall;
    @BindView(R.id.btn_share)
    Button btnShare;
    @BindView(R.id.btn_collection)
    Button btnCollection;
    private HomeInfoPresenter homeInfoPresenter;
    private int id;
    private int collectionId;
    private String token;
    private int collectionType = 0;
    private String shareImageUrlOne;
    private String shareImageUrlTwo;
    private String shareImageUrlThree;

    @Override
    protected HomeInfoPresenter initPersenter() {
        homeInfoPresenter = new HomeInfoPresenter();
        return homeInfoPresenter;
    }

    @Override
    protected int getLayout() {
        return R.layout.home_item_activity;
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        id = intent.getIntExtra("id", 59);
       // token = intent.getStringExtra("token");
        String token = Constants.TOKEN_CONTENT;
        mPresenter.getHomeInfoData(id, token);
    }

    @OnClick({R.id.img_close, R.id.btn_collection, R.id.btn_share,
            R.id.img_one_four, R.id.img_two_four
            , R.id.img_three_four, R.id.img_four_four, R.id.watchall})
    protected void initListener(View view) {
        switch (view.getId()) {
            case R.id.img_close:
                finish();
                break;
            case R.id.btn_collection:
                collection();
                break;
            case R.id.btn_share:
                faceShare();
                break;
            case R.id.img_two_four:
                popupView();
                break;
            case R.id.img_one_four:
                // popupView();
                break;
            case R.id.img_three_four:
                //popupView();
                break;
            case R.id.img_four_four:
                //popupView();
                break;
            case R.id.watchall:
                Intent intent = new Intent(this, LookAllActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);
                break;

        }
    }

    private void popupView() {

    }

    private void faceShare() {
      /*  UMImage image = new UMImage(this, shareImageUrlOne);//网络图片
        new ShareAction(HomeInfoActivity.this)
                .withText("hello")
                .withMedia(image)
                .setDisplayList(SHARE_MEDIA.SINA,SHARE_MEDIA.QQ,SHARE_MEDIA.WEIXIN)
                .setCallback(shareListener).open();*/
      /*  new ShareAction(this)
                .setPlatform(SHARE_MEDIA.QQ)//传入平台
                .withText("hello")//分享内容
                .setCallback(shareListener)//回调监听器
                .share();*/
      /*  new ShareAction(HomeInfoActivity.this).withText("hello").setDisplayList(SHARE_MEDIA.SINA,SHARE_MEDIA.QQ,SHARE_MEDIA.WEIXIN)
                .setCallback(shareListener).open();*/

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "到处旅行");
        intent.putExtra(Intent.EXTRA_TEXT, shareImageUrlOne);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(Intent.createChooser(intent, "分享到"));

    }

    private UMShareListener shareListener = new UMShareListener() {
        /**
         * @descrption 分享开始的回调
         * @param platform 平台类型
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        /**
         * @descrption 分享成功的回调
         * @param platform 平台类型
         */
        @Override
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(HomeInfoActivity.this, "成功了", Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享失败的回调
         * @param platform 平台类型
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(HomeInfoActivity.this, "失败" + t.getMessage(), Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享取消的回调
         * @param platform 平台类型
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(HomeInfoActivity.this, "取消了", Toast.LENGTH_LONG).show();

        }
    };

    private void collection() {
        if (collectionType == 0) {
            Drawable homepressed = getResources().getDrawable(R.mipmap.collect_highlight);
            homepressed.setBounds(0, 0, homepressed.getMinimumWidth(), homepressed.getMinimumHeight());
            btnCollection.setCompoundDrawables(homepressed, null, null, null);
            collectionType = 1;
        }
        if (collectionType == 1) {
            Drawable homepressed = getResources().getDrawable(R.mipmap.collect_default);
            homepressed.setBounds(0, 0, homepressed.getMinimumWidth(), homepressed.getMinimumHeight());
            btnCollection.setCompoundDrawables(homepressed, null, null, null);
            collectionType = 0;
        }



            /*if (collectionType == 0){
                mPresenter.postCollection(collectionId,token);
               btnCollection.setBackgroundResource(R.mipmap.collect_highlight);
                collectionType = 1;
            }
            if (collectionType == 1){
                mPresenter.postUnCollection(collectionId,token);
                btnCollection.setBackgroundResource(R.mipmap.collect_default);
                collectionType = 2;
            }*/
    }

    @Override
    public void toastShort(String msg) {

    }

    @Override
    public void onFail(String msg) {
        ToastUtil.showShort(msg);
    }

    @Override
    public void onSuccess(HomeInfomation bean) {
        if (bean != null) {
            setUi(bean);
        }
    }


    @Override
    public void onCollection(CollectionOrClierBean bean) {
        if (bean != null) {
            ToastUtil.showShort(bean.getDesc());
        }
    }

    @Override
    public void onUnCollection(String msg) {
        ToastUtil.showShort(msg);
    }

    private void setUi(HomeInfomation bean) {
        Log.e(TAG, "setUi: 车工"+bean );
        final ArrayList<View> views = new ArrayList<>();
        HomeInfomation.ResultBean result = bean.getResult();
        HomeInfomation.ResultBean.RouteBean route = result.getRoute();
        collectionId = route.getId();
        if (route != null) {
            tvLocal.setText(route.getCity());
            tvTitle.setText(route.getTitle());
            tvTime.setText(route.getIntro());
            shareImageUrlOne = route.getCardURL();
            GlideUtils.glide(this, shareImageUrlOne, imgBig);

            HomeInfomation.ResultBean.BanmiBean banmi = result.getBanmi();
            shareImageUrlTwo = banmi.getPhoto();
            if (banmi != null) {
                GlideUtils.glideCorner(this, shareImageUrlTwo, imgTwo);
                tvHaitui.setText(banmi.getName());
                tvHaituiTime.setText(banmi.getOccupation());
                tvBaimiLocation.setText(banmi.getLocation());
                tvHaituiContent.setText(banmi.getIntroduction());
            }

            List<HomeInfomation.ResultBean.ReviewsBean> reviews = result.getReviews();
            if (reviews != null && reviews.size() > 0) {
                if (reviews.get(0) != null) {
                    HomeInfomation.ResultBean.ReviewsBean reviewsBean1 = reviews.get(0);
                    shareImageUrlThree = reviewsBean1.getUserPhoto();
                    GlideUtils.glideCorner(this, shareImageUrlThree, imgBaimi);
                    tvBaimiName.setText(reviewsBean1.getUserName());
                    tvBaimiZhiye.setText(reviewsBean1.getCreatedAt());
                    tvThree.setText(reviewsBean1.getContent());

                }
                if (reviews.get(1) != null) {
                    HomeInfomation.ResultBean.ReviewsBean reviewsBean2 = reviews.get(1);
                    GlideUtils.glideCorner(this, reviewsBean2.getUserPhoto(), imgthree);
                    tvThreeName.setText(reviewsBean2.getUserName());
                    tvthreetime.setText(reviewsBean2.getCreatedAt());

                }
                if (reviews.get(2) != null) {
                    HomeInfomation.ResultBean.ReviewsBean reviewsBean3 = reviews.get(2);
                    GlideUtils.glideCorner(this, reviewsBean3.getUserPhoto(), img_three);
                    tvFourName.setText(reviewsBean3.getUserName());
                    tvFourTime.setText(reviewsBean3.getCreatedAt());
                    tvFourCount.setText(reviewsBean3.getContent());

                }

            }
            final List<String> carousel = result.getCarousel();
            Log.e(TAG, "集合的长度: " + carousel.size());
            if (carousel != null) {
                if (carousel.size() >= 0) {
                    if (carousel.get(0) != null) {
                        GlideUtils.glide(this, carousel.get(0), imgOneFour);
                        imgOneFour.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                View view = getLayoutInflater().inflate(R.layout.homeinfo_image, null);
                                ImageView startImage = view.findViewById(R.id.start_Big_img);
                                GlideUtils.glide(HomeInfoActivity.this, carousel.get(0), startImage);
                                views.add(view);
                            }
                        });

                    }
                }
                if (carousel.size() > 1) {
                    if (carousel.get(1) != null) {
                        GlideUtils.glide(this, carousel.get(1), imgTwoFour);
                        imgTwoFour.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                View view = getLayoutInflater().inflate(R.layout.homeinfo_image, null);
                                ImageView startImage = view.findViewById(R.id.start_Big_img);
                                GlideUtils.glide(HomeInfoActivity.this, carousel.get(1), startImage);
                                views.add(view);
                            }
                        });
                    }
                }
                if (carousel.size() > 2) {
                    if (carousel.get(2) != null) {
                        GlideUtils.glide(this, carousel.get(2), imgThreeFour);
                        imgThreeFour.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                View view = getLayoutInflater().inflate(R.layout.homeinfo_image, null);
                                ImageView startImage = view.findViewById(R.id.start_Big_img);
                                GlideUtils.glide(HomeInfoActivity.this, carousel.get(2), startImage);
                                views.add(view);
                            }
                        });
                    }
                }
                if (carousel.size() > 3) {
                    if (carousel.get(3) != null) {
                        GlideUtils.glide(this, carousel.get(3), imgFourFour);
                        imgThreeFour.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                View view = getLayoutInflater().inflate(R.layout.homeinfo_image, null);
                                ImageView startImage = view.findViewById(R.id.start_Big_img);
                                GlideUtils.glide(HomeInfoActivity.this, carousel.get(3), startImage);
                                views.add(view);
                            }
                        });
                    }
                }
                HomeInfoVpAdapter adapter = new HomeInfoVpAdapter(views);


            }
        }
    }
}
