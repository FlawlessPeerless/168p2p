package com.magic.szh.cnf_168p2p.api.response;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * project: CNF_168p2p
 * package: com.magic.szh.cnf_168p2p.api.response
 * file: ResponseHome
 * author: admin
 * date: 2018/2/23
 * description: 主页回调实体类
 */

public class ResponseHome extends BaseResponse {
    public static ResponseHome getInstance(String json) {
        Gson gson = new Gson();
        Type responseHomeType = new TypeToken<ResponseHome>(){}.getType();
        return gson.fromJson(json, responseHomeType);
    }

    @SerializedName("gonggaoList")
    public List<Notice> noticeList;
    public LayoutList layoutList;

    /**
     * 回调-公告实体
     */
    public static class Notice {
        public int id;
        public String name;
        public int isHot;
        public String url;
    }

    /**
     * 回调 - 布局 实体
     */
    public static class LayoutList {
        public List<Data> data;
        public List<Stat> tongji;
    }

    /**
     * 回调 - 布局 - 数据 实体
     */
    public static class Data {
        public String title;
        public String name;
        public String img;
        public String url;
        public String type;
    }

    /**
     * 回调 - 布局 - 统计 实体
     */
    public static class Stat {
        public String number;
        public String name;
    }
}
