package com.example.lenovo.yk_moni_ljq.moder;


import com.example.lenovo.yk_moni_ljq.bean.BannerBean;

/**
 * Created by lenovo on 2018/3/6.
 */

public interface MyCallBack {

    public void success(BannerBean bean);

    public void failuer(String e);
}
