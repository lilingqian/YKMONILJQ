package com.example.lenovo.yk_moni_ljq.moder;




import com.example.lenovo.yk_moni_ljq.app.MyApp;
import com.example.lenovo.yk_moni_ljq.bean.BannerBean;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.functions.Consumer;

/**
 * Created by lenovo on 2018/3/6.
 */

public class MyBannerMolder {
    public void get(final MyCallBack callBack) {
        MyApp.inters.getBanner()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<BannerBean>() {
                    @Override
                    public void accept(BannerBean bannerBean) throws Exception {
                        callBack.success(bannerBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        callBack.failuer(String.valueOf(throwable));
                    }
                });
    }
}
