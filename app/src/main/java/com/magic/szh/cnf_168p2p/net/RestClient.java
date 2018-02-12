package com.magic.szh.cnf_168p2p.net;

import com.magic.szh.cnf_168p2p.net.callback.IError;
import com.magic.szh.cnf_168p2p.net.callback.IFailure;
import com.magic.szh.cnf_168p2p.net.callback.IRequest;
import com.magic.szh.cnf_168p2p.net.callback.ISuccess;

import java.util.Map;
import java.util.WeakHashMap;

import okhttp3.RequestBody;

/**
 * project: CNF_168p2p
 * package: com.magic.szh.cnf_168p2p.net
 * file: RestClient
 * author: admin
 * date: 2018/2/12
 * description: 网络客户端（建造者模式）
 */

public class RestClient {
    private final String URL;
    private static final WeakHashMap<String, Object> PARAMS = RestCreator.getParams();
    private final IRequest REQUEST;
    private final ISuccess SUCCESS;
    private final IFailure FAILURE;
    private final IError ERROR;
    private final RequestBody BODY;

    public RestClient(String url,
                             Map<String, Object> params,
                             IRequest request,
                             ISuccess success,
                             IFailure failure,
                             IError error,
                             RequestBody body) {
        this.URL = url;
        PARAMS.putAll(params);
        this.REQUEST = request;
        this.SUCCESS = success;
        this.FAILURE = failure;
        this.ERROR = error;
        this.BODY = body;
    }

    public static RestClientBuilder builder() {
        return new RestClientBuilder();
    }
}
