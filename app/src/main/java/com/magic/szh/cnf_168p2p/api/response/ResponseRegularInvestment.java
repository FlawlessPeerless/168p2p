package com.magic.szh.cnf_168p2p.api.response;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * project: CNF_168p2p
 * package: com.magic.szh.cnf_168p2p.api.response
 * file: ResponseRegularInvestment
 * author: admin
 * date: 2018/2/27
 * description: 理财 - 定期理财 数据列表 实体类
 */

public class ResponseRegularInvestment extends BaseResponse {
    public static ResponseRegularInvestment getInstance(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, ResponseRegularInvestment.class);
    }

    private ListWarpper list;

    public ListWarpper getList() {
        return list;
    }

    public void setList(ListWarpper list) {
        this.list = list;
    }

    /**
     * 分页信息
     */
    public class PageInformation {
        private int total;
        @SerializedName("total_page")
        private int totalPage;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getTotalPage() {
            return totalPage;
        }

        public void setTotalPage(int totalPage) {
            this.totalPage = totalPage;
        }
    }

    /**
     *  标的列表
     */
    public class SubjectPojo {
        private int id;
        @SerializedName("borrow_nid")
        private String borrowNid;
        private String name;
        private float account;
        @SerializedName("borrow_period")
        private int borrowPeriod;
        @SerializedName("borrow_apr")
        private float borrowApr;
        @SerializedName("extend_rate")
        private float extendRate;
        @SerializedName("redbag_rate")
        private float redbagRate;
        @SerializedName("group_redbag")
        private float groupRedbag;
        @SerializedName("group_redbagrate")
        private float groupRedbagRate;
        @SerializedName("borrow_account_scale")
        private float borrowAccountScale;
        private int status;
        @SerializedName("borrow_type")
        private String borrowType;
        @SerializedName("preset_time")
        private int presetTime;
        @SerializedName("borrow_account_wait")
        private float borrowAccountWait;
        private int biaozhong;
        @SerializedName("redbag_status")
        private int redbagStatus;
        @SerializedName("repay_full_status")
        private int repayFullStatus;
        @SerializedName("repay_account_wait")
        private float repayAccountWait;
        @SerializedName("tender_account_min")
        private int tenderAccountMin;
        @SerializedName("tender_account_max")
        private int tenderAccountMax;
        @SerializedName("verify_time")
        private int verifyTime;
        @SerializedName("borrow_time_type")
        private int borrowTimeType;
        @SerializedName("voucher_status")
        private int voucherStatus;
        @SerializedName("borrow_style")
        private int borrowStyle;
        @SerializedName("borrow_flag")
        private int borrowFlag;
        @SerializedName("style_name")
        private String styleName;
        @SerializedName("status_name")
        private String statusName;
        private int reward;

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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public float getAccount() {
            return account;
        }

        public void setAccount(int account) {
            this.account = account;
        }

        public int getBorrowPeriod() {
            return borrowPeriod;
        }

        public void setBorrowPeriod(int borrowPeriod) {
            this.borrowPeriod = borrowPeriod;
        }

        public float getBorrowApr() {
            return borrowApr;
        }

        public void setBorrowApr(float borrowApr) {
            this.borrowApr = borrowApr;
        }

        public float getExtendRate() {
            return extendRate;
        }

        public void setExtendRate(float extendRate) {
            this.extendRate = extendRate;
        }

        public float getRedbagRate() {
            return redbagRate;
        }

        public void setRedbagRate(float redbagRate) {
            this.redbagRate = redbagRate;
        }

        public float getGroupRedbag() {
            return groupRedbag;
        }

        public void setGroupRedbag(float groupRedbag) {
            this.groupRedbag = groupRedbag;
        }

        public float getGroupRedbagRate() {
            return groupRedbagRate;
        }

        public void setGroupRedbagRate(float groupRedbagRate) {
            this.groupRedbagRate = groupRedbagRate;
        }

        public float getBorrowAccountScale() {
            return borrowAccountScale;
        }

        public void setBorrowAccountScale(float borrowAccountScale) {
            this.borrowAccountScale = borrowAccountScale;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getBorrowType() {
            return borrowType;
        }

        public void setBorrowType(String borrowType) {
            this.borrowType = borrowType;
        }

        public double getPresetTime() {
            return presetTime;
        }

        public void setPresetTime(int presetTime) {
            this.presetTime = presetTime;
        }

        public float getBorrowAccountWait() {
            return borrowAccountWait;
        }

        public void setBorrowAccountWait(float borrowAccountWait) {
            this.borrowAccountWait = borrowAccountWait;
        }

        public int getBiaozhong() {
            return biaozhong;
        }

        public void setBiaozhong(int biaozhong) {
            this.biaozhong = biaozhong;
        }

        public int getRedbagStatus() {
            return redbagStatus;
        }

        public void setRedbagStatus(int redbagStatus) {
            this.redbagStatus = redbagStatus;
        }

        public int getRepayFullStatus() {
            return repayFullStatus;
        }

        public void setRepayFullStatus(int repayFullStatus) {
            this.repayFullStatus = repayFullStatus;
        }

        public float getRepayAccountWait() {
            return repayAccountWait;
        }

        public void setRepayAccountWait(float repayAccountWait) {
            this.repayAccountWait = repayAccountWait;
        }

        public int getTenderAccountMin() {
            return tenderAccountMin;
        }

        public void setTenderAccountMin(int tenderAccountMin) {
            this.tenderAccountMin = tenderAccountMin;
        }

        public int getTenderAccountMax() {
            return tenderAccountMax;
        }

        public void setTenderAccountMax(int tenderAccountMax) {
            this.tenderAccountMax = tenderAccountMax;
        }

        public int getVerifyTime() {
            return verifyTime;
        }

        public void setVerifyTime(int verifyTime) {
            this.verifyTime = verifyTime;
        }

        public int getBorrowTimeType() {
            return borrowTimeType;
        }

        public void setBorrowTimeType(int borrowTimeType) {
            this.borrowTimeType = borrowTimeType;
        }

        public int getVoucherStatus() {
            return voucherStatus;
        }

        public void setVoucherStatus(int voucherStatus) {
            this.voucherStatus = voucherStatus;
        }

        public int getBorrowStyle() {
            return borrowStyle;
        }

        public void setBorrowStyle(int borrowStyle) {
            this.borrowStyle = borrowStyle;
        }

        public int getBorrowFlag() {
            return borrowFlag;
        }

        public void setBorrowFlag(int borrowFlag) {
            this.borrowFlag = borrowFlag;
        }

        public String getStyleName() {
            return styleName;
        }

        public void setStyleName(String styleName) {
            this.styleName = styleName;
        }

        public String getStatusName() {
            return statusName;
        }

        public void setStatusName(String statusName) {
            this.statusName = statusName;
        }

        public int getReward() {
            return reward;
        }

        public void setReward(int reward) {
            this.reward = reward;
        }
    }

    /**
     * 标的 包裹层
     */
    public class ListWarpper {
        private PageInformation page;
        private List<SubjectPojo> list;
        @SerializedName("product_msg")
        private String productMsg;
        @SerializedName("product_img")
        private String productImg;
        @SerializedName("product_img_url")
        private String productImgUrl;
        @SerializedName("product_msg_url")
        private String productMsgUrl;

        public PageInformation getPage() {
            return page;
        }

        public void setPage(PageInformation page) {
            this.page = page;
        }

        public List<SubjectPojo> getList() {
            return list;
        }

        public void setList(List<SubjectPojo> list) {
            this.list = list;
        }

        public String getProductMsg() {
            return productMsg;
        }

        public void setProductMsg(String productMsg) {
            this.productMsg = productMsg;
        }

        public String getProductImg() {
            return productImg;
        }

        public void setProductImg(String productImg) {
            this.productImg = productImg;
        }

        public String getProductImgUrl() {
            return productImgUrl;
        }

        public void setProductImgUrl(String productImgUrl) {
            this.productImgUrl = productImgUrl;
        }

        public String getProductMsgUrl() {
            return productMsgUrl;
        }

        public void setProductMsgUrl(String productMsgUrl) {
            this.productMsgUrl = productMsgUrl;
        }
    }
}
