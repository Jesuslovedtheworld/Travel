package com.baidu.traveleverywhere.utils;

import android.widget.Toast;

import com.baidu.traveleverywhere.base.BaseApp;
/**
 * Created by gme on 2019年4月30日14:08:37
 */

public class ToastUtil {
    public static void showShort(String msg){
        //避免内存泄漏的一个方法,用到上下文的地方,能用application的就application
        Toast.makeText(BaseApp.getInstance(),msg,Toast.LENGTH_SHORT).show();
    }
    public static void showLong(String msg){
        //避免内存泄漏的一个方法,用到上下文的地方,能用application的就application
        Toast.makeText(BaseApp.getInstance(),msg,Toast.LENGTH_LONG).show();
    }
}
