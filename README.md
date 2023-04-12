# Harvest-Game



# okhttpretrofitdemo

网络请求封装
使用：OkHttp+Retrofit

## 导入
[![](https://jitpack.io/v/burningtomato/OkHttpRetrofitDemo.svg)](https://jitpack.io/#burningtomato/OkHttpRetrofitDemo)
```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}

    ...
    
dependencies {
	        implementation 'com.github.burningtomato:OkHttpRetrofitDemo:Tag'
	}
```

## 使用方式
```
在底层Activity
public class BaseActivity extends AppCompatActivity {
    protected ORCall orCall;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("BaseActivity",getLocalClassName());
        orCall = new ORCall(this);
    }

    /**获取WanAndroid的Api*/
    protected WanAndroidApi getWanAndroidApi(){
        return ORUtil.INSTACE.getApiService(UrlDatas.BaseUrl, WanAndroidApi.class);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}

在正常使用的Activity
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

 ``` 
 
