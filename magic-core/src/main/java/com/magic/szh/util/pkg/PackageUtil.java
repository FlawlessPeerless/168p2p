package com.magic.szh.util.pkg;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

/**
 * project: CNF_168p2p
 * package: com.magic.szh.util.pkg
 * file: PackageUtil
 * author: admin
 * date: 2018/3/2
 * description: 包工具
 */

public class PackageUtil {
    /**
     * 获取当前包的版本号
     * @param context
     * @return
     */
    public static String getAppVersion(Context context) {
        String version = "";
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo info = packageManager.getPackageInfo(context.getPackageName(), 0);
            version = info.versionName;
            if (TextUtils.isEmpty(version)) return "";
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return version;
    }
}
