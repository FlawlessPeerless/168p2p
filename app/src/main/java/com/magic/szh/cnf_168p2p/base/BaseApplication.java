package com.magic.szh.cnf_168p2p.base;

import android.app.Application;

import com.magic.szh.Magic;
import com.magic.szh.cnf_168p2p.icon.Iconfont;

/**
 * project: CNF_168p2p
 * package: com.magic.szh.cnf_168p2p.base
 * file: BaseApplication
 * author: admin
 * date: 2018/2/13
 * description: application 基类
 */

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Magic.init(this)
                .withApiHost("https://api.168p2p.com")
                .withIcon(new Iconfont())
                .configure();
    }
}
