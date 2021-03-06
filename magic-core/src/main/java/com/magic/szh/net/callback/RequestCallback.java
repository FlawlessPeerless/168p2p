package com.magic.szh.net.callback;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * project: CNF_168p2p
 * package: com.magic.szh.cnf_168p2p.net.callback
 * file: RequestCallback
 * author: admin
 * date: 2018/2/13
 * description: 请求回调类
 */

public class RequestCallback implements Callback<String> {
    private final IRequest REQUEST;
    private final ISuccess SUCCESS;
    private final IFailure FAILURE;
    private final IError ERROR;

    public RequestCallback(IRequest request, ISuccess success, IFailure failure, IError error) {
        this.REQUEST = request;
        this.SUCCESS = success;
        this.FAILURE = failure;
        this.ERROR = error;
    }

    @Override
    public void onResponse(Call<String> call, Response<String> response) {
        if (response.isSuccessful()) {
            if (call.isExecuted()) {
                if (SUCCESS != null) SUCCESS.onSuccess(response.body());
            }
        } else {
            if (ERROR != null)
                ERROR.onError(response.code(), response.message());
        }

    }

    @Override
    public void onFailure(Call<String> call, Throwable t) {
        if (FAILURE != null)
            FAILURE.onFailure(t);
        if (REQUEST != null)
            REQUEST.onRequestEnd();
    }
}
