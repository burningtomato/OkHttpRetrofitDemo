package com.xlkj.okhttpretrofitdemo.base;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.xlkj.network.util.ORCall;
import com.xlkj.network.util.ORUtil;

public class BaseActivity extends AppCompatActivity {
    protected ORCall orCall;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("BaseActivity",getLocalClassName());
        orCall = new ORCall(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
