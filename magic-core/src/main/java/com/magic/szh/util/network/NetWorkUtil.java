package com.magic.szh.util.network;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by 36268 on 2018/2/27.
 * 网络检测工具类
 */

public class NetWorkUtil {
    /**
     * 检测当前是否联网
     * @param context 上下文环境
     * @return boolean是否联网
     */
    @SuppressLint("MissingPermission")
    public static boolean isNetworkConnected(Context context) {
        if (context == null)
            return false;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager == null)
            return false;
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isAvailable();
    }
}
