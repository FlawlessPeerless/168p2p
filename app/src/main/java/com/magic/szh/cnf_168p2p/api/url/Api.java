package com.magic.szh.cnf_168p2p.api.url;

import com.magic.szh.Magic;
import com.magic.szh.app.ConfigType;

/**
 * project: CNF_168p2p
 * package: com.magic.szh.cnf_168p2p.api.url
 * file: Api
 * author: admin
 * date: 2018/2/23
 * description: 请求接口类
 */

public class Api {
    // 接口主机地址
    private static final String BASE_URL = Magic.getConfiguration(ConfigType.API_HOST);
    // 首页 - home - banner
    public static final String GET_MAIN_HOME_BANNER = BASE_URL + "/api/add";
    // 首页 - home
    public static final String GET_MAIN_HOME = BASE_URL + "/api/add/homepage";
    // 首页 - investment - 定期理财列表
    public static final String GET_MAIN_INVESTMENT_REGULAR = BASE_URL + "/borrow/borrow/getBorrowList";
    // 首页 - investment - 债权转让列表
    public static final String GET_MAIN_INVESTMENT_TRANSFER = BASE_URL + "/borrow/borrow/zhaiquanList";
}
