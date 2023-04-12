package com.xlkj.okhttpretrofitdemo;

import androidx.annotation.NonNull;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.view.View;

import com.xlkj.network.util.ORUtil;
import com.xlkj.okhttpretrofitdemo.base.BaseActivity;
import com.xlkj.okhttpretrofitdemo.base.UrlDatas;
import com.xlkj.okhttpretrofitdemo.base.WanAndroidApi;
import com.xlkj.network.util.ORHandler;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getDatas(){
        orCall.getCall(
                getWanAndroidApi().getHomeList(getLocalClassName(),0),
                handler,1,2
        );
//        这个注释开启是测试，能否在切换界面的时候，把原来的网络请求停止了；本人测试成功
//        startActivity(new Intent(this,SecondActivity.class));
//        finish();
    }

    private ORHandler handler = new ORHandler(Looper.myLooper(), this){
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what) {
                case 1:

                    System.out.println("成功 msg.obj.toString() = " + msg.obj.toString());
                    break;
                case 2:
                    System.out.println("失败 msg.obj.toString() = " + msg.obj.toString());
                    break;
                default:
            }

        }
    };

    public void getData(View view) {
        getDatas();
    }
}