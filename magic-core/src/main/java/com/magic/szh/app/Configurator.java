package com.magic.szh.app;

import com.magic.szh.Magic;
import com.mikepenz.iconics.Iconics;
import com.mikepenz.iconics.typeface.ITypeface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * project: CNF_168p2p
 * package: com.magic.szh.app
 * file: Configurator
 * author: admin
 * date: 2018/2/13
 * description: 框架配置对象
 */

public class Configurator {
    private static final HashMap<Object, Object> MAGIC_CONFIGS = new HashMap<>();
    private static final ArrayList<ITypeface> ICONS = new ArrayList<>();

    private Configurator() {
        MAGIC_CONFIGS.put(ConfigType.CONFIG_READY, false);
    }

    private static class Holder {
        private static final Configurator INSTANCE = new Configurator();
    }

    public static Configurator getInstance() {
        return Holder.INSTANCE;
    }

    public HashMap<Object, Object> getConfigs() {
        return MAGIC_CONFIGS;
    }

    public final void configure() {
        MAGIC_CONFIGS.put(ConfigType.CONFIG_READY, true);
        initIcons();
    }

    /**
     * 配置网络接口host
     * @param host 主机名
     * @return Configurator实例
     */
    public final Configurator withApiHost(String host) {
        MAGIC_CONFIGS.put(ConfigType.API_HOST, host);
        return this;
    }


    /**
     * 初始化自定义字体
     */
    private void initIcons() {
        Iconics.init(getConfiguration(ConfigType.APPLICATION_CONTEXT));
        if (ICONS.size() > 0) {
            Iconics.registerFont(ICONS.get(0));
            for (int i = 1; i < ICONS.size(); i++) {
                Iconics.registerFont(ICONS.get(i));
            }
        }
    }

    /**
     * 添加自定义字体 (基于Android-Iconics)
     * @param typeface 字体库接口
     * @return Configurator对象
     */
    public final Configurator withIcon(ITypeface typeface) {
        ICONS.add(typeface);
        return this;
    }

    /**
     * 检查配置是否完成
     */
    private void checkConfiguration() {
        final boolean isReady = (boolean) MAGIC_CONFIGS.get(ConfigType.CONFIG_READY);
        if (!isReady) {
            throw new RuntimeException("Configuration is not ready, call configure");
        }
    }

    /**
     * 获取配置项
     * @param key 需要获取的配置key
     * @param <T> 需要获取的配置类型
     * @return 获取的配置
     */
    @SuppressWarnings("unchecked")
    final <T> T getConfiguration(Enum<ConfigType> key) {
        checkConfiguration();
        return (T) MAGIC_CONFIGS.get(key);
    }
}
