package com.baidu.traveleverywhere.ui.home;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.baidu.traveleverywhere.R;
import com.baidu.traveleverywhere.base.BaseActivity;
import com.baidu.traveleverywhere.base.Constants;
import com.baidu.traveleverywhere.persenter.EmptyPresenter;
import com.baidu.traveleverywhere.view.EmptyView;
import com.umeng.commonsdk.debug.E;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeUpdateNameActivity extends BaseActivity<EmptyView, EmptyPresenter> implements EmptyView, View.OnClickListener {
    @BindView(R.id.specific)
    TextView specific;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.et)
    EditText et;
    private Intent intent;
    private String stringExtra;
    private String TYPE = "type";
    private int intType;
    private int TYPE_NAME = 100;
    private int TYPE_SER = 200;
    @Override
    protected EmptyPresenter initPersenter() {
        return new EmptyPresenter();
    }

    @Override
    protected void initView() {
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.back_white);
        toolbar.setNavigationOnClickListener(this);
        intent = getIntent();
        stringExtra = intent.getStringExtra(Constants.HOME_UP_CONTENT);
        et.setText(stringExtra);
        intType = intent.getIntExtra(TYPE, 100);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_home_update_name;
    }

    @Override
    public void onClick(View v) {
        update();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_update, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void toastShort(String msg) {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.update:
                update();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void update() {
        String s = et.getText().toString();
        intent.putExtra("content",s);
        if (s!= null){
            if (intType == TYPE_NAME){
                setResult(TYPE_NAME,intent);
            }
            if (intType == TYPE_SER){
                setResult(TYPE_SER,intent);
            }
            finish();
        }

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        update();
        return super.onKeyDown(keyCode, event);
    }
}
