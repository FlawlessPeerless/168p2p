package com.magic.szh.cnf_168p2p.api.response;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * project: CNF_168p2p
 * package: com.magic.szh.cnf_168p2p.api.response
 * file: ResponseHomeBanner
 * author: admin
 * date: 2018/2/23
 * description: banner滚动图实体类
 */

public class ResponseHomeBanner extends BaseResponse {
    public static ResponseHomeBanner getInstance(String json) {
        Gson gson = new Gson();
        Type bannerType = new TypeToken<ResponseHomeBanner>(){}.getType();
        return gson.fromJson(json, bannerType);
    }

    public List<BannerItem> list;

    public static class BannerItem {
        public int id;
        public String url;
        public String name;
        public String pic;
        @SerializedName("app_active")
        public int appActive;
        public int flag;
        public int bbs;
    }
}
