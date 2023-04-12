package com.xlkj.network.util;

import android.os.Handler;

import androidx.annotation.NonNull;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;

import com.xlkj.network.error.HandlerException;

import java.util.concurrent.ConcurrentHashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 控制Retrofit的生命周期
 * 说白了就是 主动去取消网络请求
 */
public class ORCall implements DefaultLifecycleObserver {
    private ConcurrentHashMap<Integer, Object> callbackMap = new ConcurrentHashMap<Integer, Object>();

    public ORCall(LifecycleOwner lifecycleOwner) {
        lifecycleOwner.getLifecycle().addObserver(this);
    }

    /**
     * @param callback
     * @param handler
     * @param successId
     * @param errorid
     * @param <T>
     */
    public <T> void getCall(Call<T> callback, Handler handler, int successId, int errorid) {
        callbackMap.put(successId, callback);
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

    @Override
    public void onDestroy(@NonNull LifecycleOwner owner) {
        DefaultLifecycleObserver.super.onDestroy(owner);
//        取消当前活动下的所有网络请求
        callbackMap.forEach((k, v) -> {
            if (v != null ) {
                ((Call) v).cancel();
            }
        });
    }


}
