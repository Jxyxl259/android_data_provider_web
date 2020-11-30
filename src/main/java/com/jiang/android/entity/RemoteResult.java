//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.jiang.android.entity;

import com.jiang.android.utils.JsonUtil;

import java.io.Serializable;

public class RemoteResult<T> implements Serializable {
    private boolean success;
    private int resultCode;
    private String resultMsg;
    private T t;

    public RemoteResult() {
    }

    public RemoteResult(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return this.resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public T getT() {
        return this.t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            RemoteResult that = (RemoteResult)o;
            if (this.success != that.success) {
                return false;
            } else {
                if (this.resultCode != that.resultCode) {
                    return false;
                }

                if (this.t != null) {
                    if (!this.t.equals(that.t)) {
                        return false;
                    }
                } else if (that.t != null) {
                    return false;
                }

                return true;
            }
        } else {
            return false;
        }
    }

    public int hashCode() {
        int result = this.success ? 1 : 0;
        result = 31 * result + this.resultCode;
        result = 31 * result + (this.t != null ? this.t.hashCode() : 0);
        return result;
    }

    public String toString() {
        return "{\"resCode\":\"" + this.resultCode + '\"' + ", \"resMsg\":\"" + this.resultMsg + "\", \"success\":" + this.success + ", \"t\":\"" + JsonUtil.toJson(this.t) + "\"}";
    }
}
