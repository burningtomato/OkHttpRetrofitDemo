package com.xlkj.okhttpretrofitdemo.base;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.xlkj.network.util.ORUtil;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("BaseActivity",getLocalClassName());
        ORUtil.INSTACE.markPageAlive(getLocalClassName());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ORUtil.INSTACE.markPageDestroy(getLocalClassName());
    }
}
