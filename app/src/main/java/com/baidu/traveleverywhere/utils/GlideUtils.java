package com.baidu.traveleverywhere.utils;

import android.content.Context;
import android.widget.ImageView;

import com.baidu.traveleverywhere.base.BaseApp;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class GlideUtils {
    public static void glideCorner(Context context, String imgUrl, ImageView img){
        RequestOptions crop = new RequestOptions().circleCrop();
        Glide.with(context).load(imgUrl).apply(crop).into(img);
    }
    public static void glideCorner(String imgUrl, ImageView img){
        RequestOptions crop = new RequestOptions().circleCrop();
        Glide.with(BaseApp.getInstance()).load(imgUrl).apply(crop).into(img);
    }
    public static void glide(Context context, String imgUrl, ImageView img){
        Glide.with(context).load(imgUrl).into(img);
    }
    public static void glide(String imgUrl, ImageView img){
        Glide.with(BaseApp.getInstance()).load(imgUrl).into(img);
    }
}
