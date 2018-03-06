package com.magic.szh.cnf_168p2p.api.response;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/**
 * project: CNF_168p2p
 * package: com.magic.szh.cnf_168p2p.api.response
 * file: ResponseLoginByPhone
 * author: admin
 * date: 2018/3/6
 * description: 手机登录 实体类
 */

public class ResponseLoginByPhone extends BaseResponse {
    private UserInfo userinfo;
    @SerializedName("session_id")
    private String sessionId;

    public static ResponseLoginByPhone getInstance(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, ResponseLoginByPhone.class);
    }

    public static class UserInfo {
        @SerializedName("user_id")
        private String userId;
        @SerializedName("username")
        private String username;
        @SerializedName("isapp")
        private String isApp;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getIsApp() {
            return isApp;
        }

        public void setIsApp(String isApp) {
            this.isApp = isApp;
        }
    }

    public UserInfo getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(UserInfo userinfo) {
        this.userinfo = userinfo;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
