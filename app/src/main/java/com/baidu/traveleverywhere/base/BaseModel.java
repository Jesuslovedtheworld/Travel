package com.baidu.traveleverywhere.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BaseModel {
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();
    protected void addDisposable(Disposable d){
        mCompositeDisposable.add(d);
    }
    protected void onDestroy(){
        //切换所有的Dissable对象
        if (mCompositeDisposable != null){
            mCompositeDisposable.clear();
        }
    }
}
