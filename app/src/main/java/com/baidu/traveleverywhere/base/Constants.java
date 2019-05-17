package com.baidu.traveleverywhere.base;

import android.os.Environment;

import java.io.File;

/**
 * Created by gme on 2019年4月30日14:08:37
 */

public interface Constants {
    //是否为debug状态,正式上线版本需要改为false
    boolean isDebug = true;
    //判断手机号
    String telRegex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17([1-3]|[5-9]))|(18[0-9]))\\d{8}$";
    String PATH_SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath() +
            File.separator + "codeest" + File.separator + "GeekNews";

    String FILE_PROVIDER_AUTHORITY="com.baidu.geek.fileprovider";

    //网络缓存的地址
    String PATH_DATA = BaseApp.getInstance().getCacheDir().getAbsolutePath() +
            File.separator + "data";

    String PATH_CACHE = PATH_DATA + "/NetCache";
    String DATA = "data";
    //夜间模式
    String MODE = "mode";
    String NIGHT_CURRENT_FRAG_POS = "fragment_pos";
    String TOKEN = "token";
    String DESC = "desc";
    String USERNAME = "username";
    String EMAIL = "email";
    String GENDER = "gender";
    String PHOTO = "photo";
    String PHONE = "phone";
    String NAME = "name";
    String ICONURL = "iconurl";
    String UID = "uid";
    String TYPE = "type";
    String HOME_UP_CONTENT = "home_up_content";
    String WEBURL = "weburl";
    String FOLLOWED = "followed";
    String FOLLOWID = "followId";
    String USER_SEX = "user_sex";
    String TOKEN_CONTENT = "rBeRSXaoT8Y4wRYkQoyLXcWSwyKDuSNZx3WkWJlk1UHMryjUWhtIYeVNyVwQnajTfg9titlPUKpyAcoB3ZuLmfx0v0GS8kauACdv8cL6mIo1ibbimNsjLlY9N55RA7hA3iw";
    String USERDESCRIPTION = "userdescription";
    String USERBALANCE = "userbalance";
    String USERGENDER = "usergender";
    String USERHEAD = "userhead";
    String USERHEADIMAGE = "userheadimage";
    String USERUPINDEX = "userupindex";
    String VERSION = "version";
}
