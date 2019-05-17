package com.baidu.traveleverywhere.widget;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.webkit.JavascriptInterface;

import com.baidu.traveleverywhere.ui.home.AndroidJsWebActivity;
import com.baidu.traveleverywhere.ui.home.HomeInfoActivity;

public class AndroidJs extends Object{
    private static final String TAG = "AndroidJs";
    private Context context;

    public AndroidJs(Context context) {
        this.context = context;
    }

    //定义JS需要调用的方法
    //被JS调用的方法必须加入@JavasrciptInterface注解
    @JavascriptInterface
    public void callAndroid(String type,int id){
        if (type.equals("route_details")){
            Intent intent = new Intent(context,HomeInfoActivity.class);
            intent.putExtra("id",id);
            context.startActivity(intent);
        }
    }

    @JavascriptInterface
    public void callAndroid(String type){
        if (type.equals("subject_list")){
            Intent intent = new Intent(context, AndroidJsWebActivity.class);
            context.startActivity(intent);
        }
    }
}
