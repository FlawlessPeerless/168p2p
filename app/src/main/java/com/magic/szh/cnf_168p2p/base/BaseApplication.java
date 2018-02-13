package com.magic.szh.cnf_168p2p.base;

import android.app.Application;

import com.magic.szh.Magic;
import com.magic.szh.cnf_168p2p.icon.Iconfont;
import com.mikepenz.iconics.typeface.GenericFont;

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

        GenericFont gf2 = new GenericFont("IccFont", "SampleGenericFont", "icc", "fonts/iconfont.ttf");
        gf2.registerIcon("alipay", '\ue702');


        Magic.init(this)
                .withApiHost("https://api.168p2p.com")
                .withIcon(gf2)
                .configure();
    }
}
