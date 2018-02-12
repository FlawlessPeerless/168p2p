package com.magic.szh.cnf_168p2p.net.callback;

/**
 * project: CNF_168p2p
 * package: com.magic.szh.cnf_168p2p.net.callback
 * file: IError
 * author: admin
 * date: 2018/2/12
 * description: 请求接口 - 错误
 */

public interface IError {
    void onError(int code, String msg);
}
