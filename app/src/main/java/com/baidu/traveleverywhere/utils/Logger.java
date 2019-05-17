package com.baidu.traveleverywhere.utils;
import android.util.Log;

import com.baidu.traveleverywhere.base.Constants;
/**
 * Created by gme on 2019年4月30日14:08:37
 */

public class Logger {
    public static void logD(String tag,String msg){
        if (Constants.isDebug){
            Log.d(tag, "logD: "+msg);
        }
    }
}
