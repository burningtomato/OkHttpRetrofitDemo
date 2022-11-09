package com.xlkj.okhttpretrofitdemo.base;


import androidx.annotation.Nullable;

import com.xlkj.network.util.ORUtil;
import com.xlkj.okhttpretrofitdemo.bean.HomeBean;
import com.xlkj.okhttpretrofitdemo.bean.HomeDataBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface WanAndroidApi extends BaseApi {

    @GET(UrlDatas.HomeList)
    Call<BaseBean<HomeDataBean>> getHomeList(
            @Header(ORUtil.HEADER_ACT_NAME) @Nullable String actName,
            @Path("page") int page);
}
