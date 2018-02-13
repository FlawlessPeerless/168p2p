package com.magic.szh;

import android.content.Context;

import com.magic.szh.app.ConfigType;
import com.magic.szh.app.Configurator;

import java.util.HashMap;

/**
 * project: CNF_168p2p
 * package: com.magic.szh
 * file: Magic
 * author: admin
 * date: 2018/2/13
 * description: Magic框架核心配置
 */

public final class Magic {
    public static Configurator init(Context context) {
        getConfigurations().put(ConfigType.APPLICATION_CONTEXT, context.getApplicationContext());
        return Configurator.getInstance();
    }

    private static HashMap<Object, Object> getConfigurations() {
        return Configurator.getInstance().getConfigs();
    }
}
