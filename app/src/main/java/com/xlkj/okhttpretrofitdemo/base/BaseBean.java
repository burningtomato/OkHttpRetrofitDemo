package com.xlkj.okhttpretrofitdemo.base;

/**
 * errorCode如果为负数则认为错误，此时errorMsg会包含错误信息。data为Object，返回数据根据不同的接口而变化。
 *
 * errorCode = 0 代表执行成功，不建议依赖任何非0的 errorCode.
 * errorCode = -1001 代表登录失效，需要重新登录。
 *
 * {
 * "data": ...,
 * "errorCode": 0,
 * "errorMsg": ""
 * }
 */
public class BaseBean<T> {
    private int errCode;
    private String errorMsg;
    private T data;


    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BaseBean{" +
                "errCode=" + errCode +
                ", errorMsg='" + errorMsg + '\'' +
                ", data=" + data +
                '}';
    }
}
