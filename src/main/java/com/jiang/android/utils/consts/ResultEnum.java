package com.jiang.android.utils.consts;

/**
 * @description:
 * @author: jiang
 * @create: 2020-11-30 18:26
 */
public enum ResultEnum {

    SUCCESS(0, "success"),
    FAIELD(1, "faield");

    ResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int code;
    public String msg;



}
