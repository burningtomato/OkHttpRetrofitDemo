package com.xlkj.network.util;

import android.os.Handler;
import android.os.Message;

import com.xlkj.network.error.HandlerException;
import com.xlkj.network.intercept.BaseUrlIntercept;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public enum ORUtil {
    INSTACE;



    private Retrofit retrofit;
    private String baseUrl;

    private void initRetrofit(String mBaseUrl){
        if (!isChangeBaseUrl(mBaseUrl) || retrofit==null  ) {
            OkHttpClient httpClient = new OkHttpClient.Builder()
                    .readTimeout(15, TimeUnit.SECONDS)
                    .connectTimeout(15, TimeUnit.SECONDS)
                    .addInterceptor(new BaseUrlIntercept())
                    .build();
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(httpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
    }

    public  <T> T getApiService(String baseUrl, Class<T> tClass) {
        initRetrofit(baseUrl);
        return retrofit.create(tClass);
    }

    /**
     * 基础Url是否发生变化
     * @param mBaseUrl
     * @return
     */
    private boolean isChangeBaseUrl(String mBaseUrl) {
        if (baseUrl==null) {
            baseUrl = mBaseUrl;
            return false;
        }else{
            if (baseUrl.equals(mBaseUrl)) {
                return true;
            } else{
                baseUrl = mBaseUrl;
                return false;
            }
        }
    }

    /**
     *
     * @param callback
     * @param handler
     * @param successId
     * @param errorid
     * @param <T>
     */
    public <T> void  getCall(Call<T> callback, Handler handler, int successId, int errorid){
        callback.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                handler.obtainMessage(successId, response.body()).sendToTarget();
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                HandlerException.ResponseThrowable throwable = HandlerException.handleException(t);
                handler.obtainMessage(errorid, throwable.getMessage()).sendToTarget();
            }
        });
    }


}
