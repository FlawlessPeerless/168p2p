package com.magic.szh.cnf_168p2p.api.response;

import com.google.gson.Gson;

/**
 * project: CNF_168p2p
 * package: com.magic.szh.cnf_168p2p.api.response
 * file: BaseResponse
 * author: admin
 * date: 2018/2/23
 * description: 回调数据基类
 */

public class BaseResponse {
    public static BaseResponse getInstance(String json) {
        return new Gson().fromJson(json, BaseResponse.class);
    }

    private int code;
    private String msg;

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
