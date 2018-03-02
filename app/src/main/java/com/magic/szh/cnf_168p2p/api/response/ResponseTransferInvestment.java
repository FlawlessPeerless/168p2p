package com.magic.szh.cnf_168p2p.api.response;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * project: CNF_168p2p
 * package: com.magic.szh.cnf_168p2p.api.response
 * file: ResponseTransferInvestment
 * author: admin
 * date: 2018/3/2
 * description: 债权转让 实体类
 */

public class ResponseTransferInvestment extends BaseResponse {
    public static ResponseTransferInvestment getInstance(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, ResponseTransferInvestment.class);
    }

    private String total;
    @SerializedName("total_page")
    private int totalPage;
    private List<SubjectPojo> list;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<SubjectPojo> getList() {
        return list;
    }

    public void setList(List<SubjectPojo> list) {
        this.list = list;
    }

    public static class SubjectPojo {
        private int id;
        @SerializedName("borrow_nid")
        private String borrowNid;
        @SerializedName("tender_id")
        private String tenderId;
        @SerializedName("user_id")
        private String userId;
        private String zrbfb;
        @SerializedName("tender_account")
        private String tenderAccount;
        @SerializedName("claims_nid")
        private String claimsNid;
        @SerializedName("end_time")
        private String endTime;
        private String addtime;
        private int status;
        private String name;
        @SerializedName("borrow_apr")
        private String borrowApr;
        @SerializedName("borrow_account_scale")
        private float borrowAccountScale;
        @SerializedName("borrow_account_wait")
        private String borrowAccountWait;
        @SerializedName("borrow_status")
        private int borrowStatus;
        @SerializedName("reverify_time")
        private int reverifyTime;
        @SerializedName("zhaiquan_account")
        private String zhaiquanAccount;
        private int month;
        private int day;
        @SerializedName("status_name")
        private String statusName;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getBorrowNid() {
            return borrowNid;
        }

        public void setBorrowNid(String borrowNid) {
            this.borrowNid = borrowNid;
        }

        public String getTenderId() {
            return tenderId;
        }

        public void setTenderId(String tenderId) {
            this.tenderId = tenderId;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getZrbfb() {
            return zrbfb;
        }

        public void setZrbfb(String zrbfb) {
            this.zrbfb = zrbfb;
        }

        public String getTenderAccount() {
            return tenderAccount;
        }

        public void setTenderAccount(String tenderAccount) {
            this.tenderAccount = tenderAccount;
        }

        public String getClaimsNid() {
            return claimsNid;
        }

        public void setClaimsNid(String claimsNid) {
            this.claimsNid = claimsNid;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public String getAddtime() {
            return addtime;
        }

        public void setAddtime(String addtime) {
            this.addtime = addtime;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getBorrowApr() {
            return borrowApr;
        }

        public void setBorrowApr(String borrowApr) {
            this.borrowApr = borrowApr;
        }

        public float getBorrowAccountScale() {
            return borrowAccountScale;
        }

        public void setBorrowAccountScale(float borrowAccountScale) {
            this.borrowAccountScale = borrowAccountScale;
        }

        public String getBorrowAccountWait() {
            return borrowAccountWait;
        }

        public void setBorrowAccountWait(String borrowAccountWait) {
            this.borrowAccountWait = borrowAccountWait;
        }

        public int getBorrowStatus() {
            return borrowStatus;
        }

        public void setBorrowStatus(int borrowStatus) {
            this.borrowStatus = borrowStatus;
        }

        public int getReverifyTime() {
            return reverifyTime;
        }

        public void setReverifyTime(int reverifyTime) {
            this.reverifyTime = reverifyTime;
        }

        public String getZhaiquanAccount() {
            return zhaiquanAccount;
        }

        public void setZhaiquanAccount(String zhaiquanAccount) {
            this.zhaiquanAccount = zhaiquanAccount;
        }

        public int getMonth() {
            return month;
        }

        public void setMonth(int month) {
            this.month = month;
        }

        public int getDay() {
            return day;
        }

        public void setDay(int day) {
            this.day = day;
        }

        public String getStatusName() {
            return statusName;
        }

        public void setStatusName(String statusName) {
            this.statusName = statusName;
        }
    }
}
