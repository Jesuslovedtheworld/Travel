package com.baidu.traveleverywhere.ui.home;

import android.Manifest;
import android.app.Dialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.icu.util.Calendar;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.traveleverywhere.R;
import com.baidu.traveleverywhere.base.BaseActivity;
import com.baidu.traveleverywhere.base.BaseApp;
import com.baidu.traveleverywhere.base.Constants;
import com.baidu.traveleverywhere.bean.UpLoadBean;
import com.baidu.traveleverywhere.bean.UpUserMessageBean;
import com.baidu.traveleverywhere.persenter.EmptyPresenter;
import com.baidu.traveleverywhere.persenter.MyhomePagerPresenter;
import com.baidu.traveleverywhere.ui.main.LoginActivity;
import com.baidu.traveleverywhere.utils.GlideUtils;
import com.baidu.traveleverywhere.utils.SpUtil;
import com.baidu.traveleverywhere.utils.ToastUtil;
import com.baidu.traveleverywhere.view.EmptyView;
import com.baidu.traveleverywhere.view.MyHomePageView;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MyHomePageActivity extends BaseActivity<MyHomePageView, MyhomePagerPresenter> implements MyHomePageView, View.OnClickListener {
    private static final int TAKE_PHOTO = 1000;
    private static final int CAMERA_CODE = 100;
    private static final int ALBUM_CODE = 200;
    @BindView(R.id.toolBar)
    Toolbar toolBar;
    @BindView(R.id.ll_head)
    LinearLayout llHead;
    @BindView(R.id.ll_username)
    LinearLayout llUsername;
    @BindView(R.id.ll_sex)
    LinearLayout llSex;
    @BindView(R.id.ll_specifi)
    LinearLayout llSpecifi;
    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.tv_username)
    TextView tvUsername;
    @BindView(R.id.tv_sex)
    TextView tvSex;
    @BindView(R.id.tv_specifi)
    TextView tvSpecifi;
    @BindView(R.id.btn_back)
    TextView btn_back;
    private int OkCode = 1;
    private String TYPE = "type";
    private int TYPE_NAME = 100;
    private int TYPE_SER = 200;//修改个性签名
    /**
     * 拍照
     */
    private TextView mCamera;
    /**
     * 相册
     */
    private TextView mPic;
    /**
     * 取消
     */
    private TextView mCancel;
    private Dialog dialog;
    private View inflate;
    private Uri mImageUri;
    private File mFile;
    private RadioButton boy;
    private RadioButton girl;
    private PopupWindow window;
    private String username;
    private String specifi;
    private Dialog sexSelectDialog;
    private TextView mTvBoy;
    private TextView mTvGirl;
    private TextView maintain;
    private TextView mTvDis;
    private int TYPE_GIRL = 0;
    private int TYPE_BOY = 1;
    private int TYPE_MAIN = 2;
    private int TYPE_DIS = 3;
    private int USER_UP_INDEX = 0;
    private String upUserName;
    private String upUserDescription;
    private String upAlbum;
    private MyhomePagerPresenter myhomePagerPresenter;
    private String upUserSex;
    private String mGirl;
    private String mBoy;
    private String mMain;
    private Map mUpMap;

    @Override
    protected MyhomePagerPresenter initPersenter() {
        if (myhomePagerPresenter == null){
            myhomePagerPresenter = new MyhomePagerPresenter();
        }
        return myhomePagerPresenter;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_my_home_page;
    }

    @Override
    public void toastShort(String msg) {

    }

    @Override
    protected void initView() {
        toolBar.setTitle("");
        toolBar.setSubtitle("");
        setSupportActionBar(toolBar);
        toolBar.setNavigationIcon(R.mipmap.back_white);
        toolBar.setNavigationOnClickListener(this);
        initUserMessage();//初始化修改用户信息
    }

    private void initUserMessage() {
        //获取本地保存的信息
        if (mUpMap == null){
            mUpMap = new HashMap<String,String>();
        }
        username = (String) SpUtil.getParam(Constants.USERNAME, "name");
        tvUsername.setText(username);
        mUpMap.put("userName",username);

        specifi = (String) SpUtil.getParam("specifi", "个性");
        tvSpecifi.setText(specifi);
        mUpMap.put("description",specifi);

        String user_sEX = (String) SpUtil.getParam(Constants.USER_SEX, "U");
        if (user_sEX.equals("男")){
            mUpMap.put("gender","M");
        }else if (user_sEX.equals("女")){
            mUpMap.put("gender","F");
        }else {
            mUpMap.put("gender","U");
        }
        tvSex.setText(user_sEX);
        String user_head_img = (String) SpUtil.getParam(Constants.USERHEADIMAGE, "http://cdn.banmi.com/banmiapp/rahdna/1522654270428_8f11bbbd503ff42905aea3a58e78e807.png");
        GlideUtils.glideCorner(user_head_img,img);
        mUpMap.put("photo",user_head_img);

    }


    @OnClick({R.id.ll_head, R.id.ll_username, R.id.ll_sex, R.id.ll_specifi,R.id.btn_back})
    protected void initListener(View view) {
        switch (view.getId()) {
            case R.id.ll_head:
                popupCreame();
                break;
            case R.id.ll_username://姓名 个性选择
                updateActivity(tvUsername, TYPE_NAME);
                break;
            case R.id.ll_sex://性别选择
                selectSex();
                break;
            case R.id.ll_specifi://修改个性签名
                updateActivity(tvSpecifi, TYPE_SER);
                break;
            case R.id.btn_back:
                startActivity(new Intent(MyHomePageActivity.this,LoginActivity.class));
                finish();
                break;
        }
    }

    private void selectSex() {//性别选择
        SpUtil.setParam(Constants.USERUPINDEX,true);
        USER_UP_INDEX ++;
        sexSelectDialog = new Dialog(this, R.style.DialogTheme);
        View view = getLayoutInflater().inflate(R.layout.home_sex_select, null);
        //找出控件
        mTvBoy = view.findViewById(R.id.tv_boy);
        mTvGirl = view.findViewById(R.id.tv_girl);
        maintain = view.findViewById(R.id.tv_maintain);
        mTvDis = view.findViewById(R.id.tv_dis);
        mGirl = mTvGirl.getText().toString();
        mBoy = mTvBoy.getText().toString();
        mMain = maintain.getText().toString();
        mTvBoy.setOnClickListener(this);
        mTvGirl.setOnClickListener(this);
        maintain.setOnClickListener(this);
        mTvDis.setOnClickListener(this);
        sexSelectDialog.setContentView(view);//设置要弹出的布局
        Window window = sexSelectDialog.getWindow();//获取窗体
        window.setGravity(Gravity.BOTTOM);//设置dialog从船体底部弹出
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.y = 20;//设置dialog距离底部的距离
        //将属性设置给窗体
        window.setAttributes(attributes);
        sexSelectDialog.show();

    }
    //弹出相机相册
    private void popupCreame() {
        dialog = new Dialog(this, R.style.DialogTheme);
        //填充对话框的布局
        //将布局设置给Dialog
        inflate = getLayoutInflater().inflate(R.layout.home_creame, null);
        mCamera = (TextView) inflate.findViewById(R.id.camera);
        mPic = (TextView) inflate.findViewById(R.id.pic);
        mCancel = (TextView) inflate.findViewById(R.id.cancel);
        mCancel.setOnClickListener(this);
        mCamera.setOnClickListener(this);
        mPic.setOnClickListener(this);
        dialog.setContentView(inflate);
        //获取当前Activity所在的窗体
        Window dialogWindow = dialog.getWindow();
        //设置Dialog从窗体底部弹出
        dialogWindow.setGravity(Gravity.BOTTOM);
        //获得窗体的属性
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.y = 20;//设置Dialog距离底部的距离
//       将属性设置给窗体
        dialogWindow.setAttributes(lp);
        dialog.show();//显示对话框

    }

    //调到修改界面
    private void updateActivity(TextView tvUsername, int type) {
        SpUtil.setParam(Constants.USERUPINDEX,true);
        USER_UP_INDEX ++;
        Intent intent = new Intent(this, HomeUpdateNameActivity.class);
        intent.putExtra(Constants.HOME_UP_CONTENT, tvUsername.getText().toString());
        intent.putExtra(TYPE, type);
        startActivityForResult(intent, OkCode);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default://toolbar点击监听
                UpAndSaveUserMessage();
                break;
            case R.id.camera://相机
                takePhoto();
                dialog.dismiss();
                break;
            case R.id.pic://相册
                takePICK();
                dialog.dismiss();
                break;
            case R.id.cancel://popup点击消失
                dialog.dismiss();
                break;
            case R.id.tv_girl://如果点击女
                saveSex(TYPE_GIRL);
                break;
            case R.id.tv_boy:
                saveSex(TYPE_BOY);
                break;
            case R.id.tv_maintain:
                saveSex(TYPE_MAIN);
                break;
            case R.id.tv_dis://修改性别
                saveSex(TYPE_DIS);
                break;
        }
    }

    private void saveSex(int type) {//保存
        SpUtil.setParam(Constants.USERUPINDEX,true);
        upUserSex = "";
        if (type == TYPE_GIRL){
            tvSex.setText(getResources().getString(R.string.girl));
            upUserSex = "F";
            SpUtil.setParam(Constants.USER_SEX,"女");
        }
        if (type == TYPE_BOY){
            upUserSex = "M";
             tvSex.setText(getResources().getString(R.string.boy));
            SpUtil.setParam(Constants.USER_SEX,"男");
        }
        if (type == TYPE_MAIN){
            upUserSex = "U";
            tvSex.setText(getResources().getString(R.string.u));
            SpUtil.setParam(Constants.USER_SEX,"保密");

        }
        mUpMap.put("gender",upUserSex);
        sexSelectDialog.dismiss();

    }
    // 将修改后的数据发送到服务器
    public void UpAndSaveUserMessage(){
        if (USER_UP_INDEX > 0){
            myhomePagerPresenter.postUpUserMessage(Constants.TOKEN_CONTENT,mUpMap);
        }
        finish();
        String userName = (String) mUpMap.get("userName");
        String description = (String) mUpMap.get("description");
        String gender = (String) mUpMap.get("gender");
        String photo = (String) mUpMap.get("photo");
        Log.e("userName", "UpAndSaveUserMessage: "+ userName);
        Log.e("userName", "UpAndSaveUserMessage: "+ description );
        Log.e("userName", "UpAndSaveUserMessage: "+ gender );
        Log.e("userName", "UpAndSaveUserMessage: "+ photo );
        //finish();
    }
    private void takePICK() {
        SpUtil.setParam(Constants.USERUPINDEX,true);
        if (ContextCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
            openAlbum();
        }else{
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},200);
        }
    }
    private void takePhoto() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            openCamera();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 100);
        }
    }

    //打开相册
    private void openAlbum() {
        USER_UP_INDEX ++;
        //启动相册
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        startActivityForResult(intent, ALBUM_CODE);
    }

    //打开相机
    private void openCamera() {
        //创建文件用于保存图片
         mFile = new File(getExternalCacheDir(), System.currentTimeMillis() + ".jpg");

        if (!mFile.exists()) {
            try {
                mFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //适配7.0,  等到对应的mImageUri路径地址

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
            mImageUri = Uri.fromFile(mFile);
        } else {
            //第二个参数要和清单文件中的配置保持一致
            mImageUri = FileProvider.getUriForFile(this, "com.baidu.upload.provider", mFile);
        }

        //启动相机
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, mImageUri);//将拍照图片存入mImageUri
        startActivityForResult(intent,CAMERA_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String content = data.getStringExtra("content");
        if (requestCode == OkCode ){
            if (resultCode == TYPE_NAME){
                tvUsername.setText(content); //修改后的名字
                mUpMap.put("userName",content);
            }
            if (resultCode == TYPE_SER){
                SpUtil.setParam("specifi",content);
                tvSpecifi.setText(content);// 修改后的个性签名
                mUpMap.put("description",content);
            }
        }
        if (resultCode == RESULT_OK) {//判断回调成功

            if (requestCode == TAKE_PHOTO) {//拍照

                //显示拍照后的图片
                try {
                    Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(mImageUri));
                    img.setImageBitmap(bitmap);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();

                }
                //拍照后的图片上传
                //uploadFile(mFile);
            }
            if (requestCode == ALBUM_CODE) {//相册

                //获取到相册选中后的图片URI路径
                Uri imageUri = data.getData();
                //显示相册选中后的图片
                try {
                    Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri));
                    //选择后的图片
                    upAlbum = bitmap.toString();
                    mUpMap.put("photo",upAlbum);
                    img.setImageBitmap(bitmap);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                //文件上传，将Uri路径转换为File对象
                //处理uri,7.0以后的fileProvider 把URI 以content provider 方式 对外提供的解析方法
                File file = getFileFromUri(imageUri, this);

                if (file.exists()) {
                    //uploadFile(file);
                }
            }
        }
    }

    public File getFileFromUri(Uri uri, Context context) {
        if (uri == null) {
            return null;
        }
        switch (uri.getScheme()) {
            case "content":
                return getFileFromContentUri(uri, context);
            case "file":
                return new File(uri.getPath());
            default:
                return null;
        }
    }

    /**
     * 通过内容解析中查询uri中的文件路径
     */
    private File getFileFromContentUri(Uri contentUri, Context context) {
        if (contentUri == null) {
            return null;
        }
        File file = null;
        String filePath;
        String[] filePathColumn = {MediaStore.MediaColumns.DATA};
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursor = contentResolver.query(contentUri, filePathColumn, null,
                null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            filePath = cursor.getString(cursor.getColumnIndex(filePathColumn[0]));
            cursor.close();

            if (!TextUtils.isEmpty(filePath)) {
                file = new File(filePath);
            }
        }
        return file;
    }

    private void uploadFile(File mFile) {

        String url = "http://yun918.cn/study/public/file_upload.php";

        OkHttpClient client = new OkHttpClient.Builder()
                .build();


        RequestBody requestBody = RequestBody.create(MediaType.parse("image/jpg"), mFile);

        MultipartBody body = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("key", "H1808C")
                .addFormDataPart("file", mFile.getName(), requestBody)
                .build();

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        Call call = client.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Gson gson = new Gson();
                final UpLoadBean upLoadBean = gson.fromJson(string, UpLoadBean.class);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (upLoadBean != null) {
                            if (upLoadBean.getCode() == 200) {
                                Glide.with(MyHomePageActivity.this).load(upLoadBean.getData().getUrl()).into(img);
                            } else {
                                Toast.makeText(MyHomePageActivity.this, upLoadBean.getRes(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
            }
        });
    }

    @Override
    public void onSuccess(UpUserMessageBean bean) {
            if (bean != null){
                ToastUtil.showShort(bean.getDesc()+"修改成功");
            }
    }

    @Override
    public void onFail(String msg) {
        ToastUtil.showShort(msg+"");
    }
}