package com.xlkj.network.util;

import androidx.lifecycle.DefaultLifecycleObserver;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 保存活动状态
 */
public class ActivityLiveUtil implements DefaultLifecycleObserver {


    public ActivityLiveUtil() {
    }

    public static final String HEADER_ACT_NAME = "HEADER_ACT_NAME";

    private static ConcurrentHashMap<String, Boolean> actLiveMap = new ConcurrentHashMap<>(); // 标记Activity是否存活

    public  static void markPageAlive(String actName) {
        actLiveMap.put(actName, true);
    }

    public static void markPageDestroy(String actName) {
        actLiveMap.put(actName, false);
    }

    public static ConcurrentHashMap<String, Boolean> getActLiveMap() {
        return actLiveMap;
    }
}
