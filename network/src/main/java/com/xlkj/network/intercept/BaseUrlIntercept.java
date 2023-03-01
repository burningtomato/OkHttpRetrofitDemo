package com.xlkj.network.intercept;

import android.text.TextUtils;
import android.util.Log;

import com.xlkj.network.util.ActivityLiveUtil;
import com.xlkj.network.util.ORUtil;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;


public class BaseUrlIntercept implements Interceptor {
    private static final String TAG = BaseUrlIntercept.class.getSimpleName();
    private static final String DOMAIN_NAME = "Domain-Name";
    private Response response;
    private Request request;
    private String domainName;
    private HttpUrl targetDomain, newUrl;
    private List<String> headers;
    private String headerTmp;
    private Boolean aBooleanTmp;

    @Override
    public Response intercept(Chain chain) throws IOException {
        request = chain.request();

        if (request == null) {
            return null;
        }

        domainName = obtainDomain(request);
        long t1 = System.nanoTime();//请求发起的时间
        if (TextUtils.isEmpty(domainName)) {
            //打印出参
            Log.d("BaseUrlIntercept.intercept", "访问的url =====\n" +
                    request.method() + ": " + request.url());
            response = chain.proceed(request);
        } else {
            targetDomain = DomainManager.getInstance().getDomain(domainName);
            if (targetDomain != null) {
                newUrl = request.url().newBuilder()
                        .scheme(targetDomain.scheme())
                        .host(targetDomain.host())
                        .port(targetDomain.port())
                        .build();
                //打印出参
                Log.d("BaseUrlIntercept.intercept", "访问的url =====\n" +
                        newUrl.url().toString());
                response = chain.proceed(
                        request.newBuilder()
                                .url(newUrl)
                                .build()
                );
            } else {
                //打印出参
                Log.d("BaseUrlIntercept.intercept", "访问的url =====\n" +
                        request.method() + ": " + request.url());
                response = chain.proceed(request);
            }

        }
        long t2 = System.nanoTime();//收到响应的时间
        Log.d("BaseUrlIntercept", String.format(Locale.CHINA, "接收响应:%s%n请求时间:%.1fms%n报文信息:%s",
                response.request().url(),
                (t2 - t1) / 1e6d,
                response.headers()));
//打印出参
        Log.d("BaseUrlIntercept.intercept", "网络返回数据 ====\n" + response.peekBody(1024 * 1024).string());
        return response;

    }

    private String obtainDomain(Request request) {
        headers = request.headers(DOMAIN_NAME);
        if (headers == null || headers.size() == 0) {
            return null;
        }
        if (headers.size() > 1) {
            throw new IllegalArgumentException("each request, max domain size is 1");
        }
        return request.header(DOMAIN_NAME);
    }

//    /**
//     * 管理：取消请求
//     *
//     * @param chain
//     */
//    private Chain isCancle(Chain chain) {
//        headerTmp = chain.request().header(ActivityLiveUtil.HEADER_ACT_NAME);
//        aBooleanTmp = ActivityLiveUtil.getActLiveMap().get(headerTmp);
//        if (aBooleanTmp == null || !aBooleanTmp) {
//            //        取消请求
//            chain.call().cancel();
//            Log.d("BaseUrlIntercept", "取消请求");
//        } else {
//            chain.request().newBuilder().removeHeader(ActivityLiveUtil.HEADER_ACT_NAME).build();
//        }
//
//
//    }

    /**
     * 监听网络访问速度
     */
    public interface OnNetResponseTimeListener {
        /**
         * @param t 询问到返回 总共需要的时间
         */
        void onNetResponseTimeListener(double t);
    }

    public static OnNetResponseTimeListener onNetResponseTimeListener;

}