package com.magic.szh.cnf_168p2p.api.response;

/**
 * project: CNF_168p2p
 * package: com.magic.szh.cnf_168p2p.api.response
 * file: BaseResponse
 * author: admin
 * date: 2018/2/23
 * description: 回调数据基类
 */

public class BaseResponse {
    protected int code;
    protected String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
