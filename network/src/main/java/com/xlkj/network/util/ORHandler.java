package com.xlkj.network.util;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;

/**
 * 使用DefaultLifecycleObserver
 * 界面销毁时能触发{@link #onDestroy(LifecycleOwner)}
 */
public class ORHandler extends Handler implements DefaultLifecycleObserver {

    public ORHandler(@NonNull Looper looper, LifecycleOwner context) {
        super(looper);
//        绑定生命周期
        context.getLifecycle().addObserver(this);
    }

    @Override
    public void onDestroy(@NonNull LifecycleOwner owner) {
        DefaultLifecycleObserver.super.onDestroy(owner);
//        界面销毁时，清空Handler内的消息队列；防止内存泄漏
        removeCallbacksAndMessages(null);
    }
}
