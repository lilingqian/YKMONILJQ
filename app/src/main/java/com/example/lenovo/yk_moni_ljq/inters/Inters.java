package com.example.lenovo.yk_moni_ljq.inters;


import com.example.lenovo.yk_moni_ljq.bean.BannerBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by lenovo on 2018/3/6.
 */

public interface Inters {
    //https://www.zhaoapi.cn/ad/getAd
    @GET("ad/getAd")
    Observable<BannerBean> getBanner();

    //@GET()

}
