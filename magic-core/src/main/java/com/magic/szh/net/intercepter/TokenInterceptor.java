package com.magic.szh.net.intercepter;

import android.text.TextUtils;

import com.magic.szh.Magic;
import com.magic.szh.util.storage.MagicPreference;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * project: CNF_168p2p
 * package: com.magic.szh.net.intercepter
 * file: TokenInterceptor
 * author: admin
 * date: 2018/2/23
 * description:
 */

public class TokenInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        if (TextUtils.isEmpty(MagicPreference.getCustomAppProfile("session_id"))) {
            return chain.proceed(chain.request());
        }
        Request authorised = chain.request().newBuilder()
                .header("Cookie", "PHPSESSID=" + MagicPreference.getString("session_id", ""))
                .removeHeader("User-Agent")
                .addHeader("User-Agent",System.getProperty("http.agent"))
                .build();
        return chain.proceed(authorised);
    }
}
