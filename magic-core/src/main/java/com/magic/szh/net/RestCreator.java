package com.magic.szh.net;

import com.magic.szh.Magic;
import com.magic.szh.app.ConfigType;
import com.magic.szh.app.Configurator;
import com.magic.szh.net.https.HttpsUtil;
import com.magic.szh.net.intercepter.TokenInterceptor;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * project: CNF_168p2p
 * package: com.magic.szh.cnf_168p2p.net
 * file: RestCreator
 * author: admin
 * date: 2018/2/12
 * description: retrofit 构造类 (单例)
 */

class RestCreator {
    private static final class ParamsHolder {
        static final WeakHashMap<String, Object> PARAMS = new WeakHashMap<>();
    }

    /**
     * 获取请求参数map
     * @return map
     */
    static WeakHashMap<String, Object> getParams() {
        return ParamsHolder.PARAMS;
    }

    static RestService getRestService() {
        return RestServiceHolder.REST_SERVICE;
    }

    private static final class RetrofitHolder {
        private static final String BASE_URL = Magic.getConfiguration(ConfigType.API_HOST);
        private static final Retrofit RETROFIT_CLIENT = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(OkHttpHolder.OK_HTTP_CLIENT)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
    }

    private static final class OkHttpHolder {
        private static final int TIME_OUT = 60;
        private static final OkHttpClient OK_HTTP_CLIENT = new OkHttpClient.Builder()
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .addNetworkInterceptor(new TokenInterceptor())
                .build();
    }

    private static final class RestServiceHolder {
        private static final RestService REST_SERVICE = RetrofitHolder.RETROFIT_CLIENT.create(RestService.class);
    }
}
