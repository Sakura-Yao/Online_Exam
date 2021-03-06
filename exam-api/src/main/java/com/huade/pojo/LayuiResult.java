package com.huade.pojo;

import java.util.ArrayList;

public class LayuiResult {

    private int code;
    private String msg;
    private int count;
    private ArrayList<?> data;

    @Override
    public String toString() {
        return "LayuiResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", count=" + count +
                ", data=" + data +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ArrayList<?> getData() {
        return data;
    }

    public void setData(ArrayList<?> data) {
        this.data = data;
    }
}
