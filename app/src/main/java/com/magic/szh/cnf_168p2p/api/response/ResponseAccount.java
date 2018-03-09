package com.magic.szh.cnf_168p2p.api.response;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/**
 * project: CNF_168p2p
 * package: com.magic.szh.cnf_168p2p.api.response
 * file: ResponseAccount
 * author: admin
 * date: 2018/3/9
 * description: 用户账户信息 实体类
 */

public class ResponseAccount extends BaseResponse {
    public static ResponseAccount getInstance(String json) {
        return new Gson().fromJson(json, ResponseAccount.class);
    }

    private AccountInfo list;

    public AccountInfo getList() {
        return list;
    }

    public void setList(AccountInfo list) {
        this.list = list;
    }

    public static class AccountInfo {
        /**
         * 当前可提现 投资账户余额
         */
        @SerializedName("balance_tender")
        private String balanceTender;
        /**
         * 当前可提现 融资账户余额
         */
        @SerializedName("balance_borrower")
        private String balanceBorrower;
        /**
         * 再投金额
         */
        private String ztje;
        /**
         * 可用余额
         */
        private String kyye;
        /**
         * 冻结金额
         */
        private String djje;
        /**
         * 我的负债
         */
        private String wdfz;
        /**
         * 资产总额
         */
        private String zcze;
        /**
         * 累计收益
         */
        private String ljsy;
        /**
         * 红包收益
         */
        private String redbag;
        /**
         * 待收益
         */
        private String dsy;
        /**
         * 利息收益
         */
        private String lxsy;
        /**
         * 红包可用余额
         */
        @SerializedName("redbag_total")
        private String redbagTotal;
        /**
         *  提现服务费比例
         */
        private double cashRate;
        /**
         * 最大提现金额
         */
        private double cashTotal;
        /**
         * 现金券数量
         */
        @SerializedName("voucher_num")
        private int voucherNum;
        /**
         * 现金券收益
         */
        private String voucher;
        /**
         * 是否是合伙人 0 true , 1 false
         */
        private int isPartner;
        /**
         * 体验金金额
         */
        @SerializedName("Experience_gold")
        private double experienceGold;
        /**
         * 是否有体验金 0没有 1有
         */
        private int isRoyalty;
        /**
         * 是否可以资金操作 1可用， 2不可用
         */
        private int isMoney;
        /**
         * 是否可以资金操作的说明
         */
        @SerializedName("isMoneymsg")
        private String isMoneyMsg;
        /**
         * 3g体验金地址 android后面追加 ?logtype=andior/&sessid=当前sessid
         */
        @SerializedName("app_tyj")
        private String appTyjUrl;
        @SerializedName("app_active")
        private AppActive appActive;

        public String getBalanceTender() {
            return balanceTender;
        }

        public void setBalanceTender(String balanceTender) {
            this.balanceTender = balanceTender;
        }

        public String getBalanceBorrower() {
            return balanceBorrower;
        }

        public void setBalanceBorrower(String balanceBorrower) {
            this.balanceBorrower = balanceBorrower;
        }

        public String getZtje() {
            return ztje;
        }

        public void setZtje(String ztje) {
            this.ztje = ztje;
        }

        public String getKyye() {
            return kyye;
        }

        public void setKyye(String kyye) {
            this.kyye = kyye;
        }

        public String getDjje() {
            return djje;
        }

        public void setDjje(String djje) {
            this.djje = djje;
        }

        public String getWdfz() {
            return wdfz;
        }

        public void setWdfz(String wdfz) {
            this.wdfz = wdfz;
        }

        public String getZcze() {
            return zcze;
        }

        public void setZcze(String zcze) {
            this.zcze = zcze;
        }

        public String getLjsy() {
            return ljsy;
        }

        public void setLjsy(String ljsy) {
            this.ljsy = ljsy;
        }

        public String getRedbag() {
            return redbag;
        }

        public void setRedbag(String redbag) {
            this.redbag = redbag;
        }

        public String getDsy() {
            return dsy;
        }

        public void setDsy(String dsy) {
            this.dsy = dsy;
        }

        public String getLxsy() {
            return lxsy;
        }

        public void setLxsy(String lxsy) {
            this.lxsy = lxsy;
        }

        public String getRedbagTotal() {
            return redbagTotal;
        }

        public void setRedbagTotal(String redbagTotal) {
            this.redbagTotal = redbagTotal;
        }

        public double getCashRate() {
            return cashRate;
        }

        public void setCashRate(double cashRate) {
            this.cashRate = cashRate;
        }

        public double getCashTotal() {
            return cashTotal;
        }

        public void setCashTotal(double cashTotal) {
            this.cashTotal = cashTotal;
        }

        public int getVoucherNum() {
            return voucherNum;
        }

        public void setVoucherNum(int voucherNum) {
            this.voucherNum = voucherNum;
        }

        public String getVoucher() {
            return voucher;
        }

        public void setVoucher(String voucher) {
            this.voucher = voucher;
        }

        public int getIsPartner() {
            return isPartner;
        }

        public void setIsPartner(int isPartner) {
            this.isPartner = isPartner;
        }

        public double getExperienceGold() {
            return experienceGold;
        }

        public void setExperienceGold(double experienceGold) {
            this.experienceGold = experienceGold;
        }

        public int getIsRoyalty() {
            return isRoyalty;
        }

        public void setIsRoyalty(int isRoyalty) {
            this.isRoyalty = isRoyalty;
        }

        public int getIsMoney() {
            return isMoney;
        }

        public void setIsMoney(int isMoney) {
            this.isMoney = isMoney;
        }

        public String getIsMoneyMsg() {
            return isMoneyMsg;
        }

        public void setIsMoneyMsg(String isMoneyMsg) {
            this.isMoneyMsg = isMoneyMsg;
        }

        public String getAppTyjUrl() {
            return appTyjUrl;
        }

        public void setAppTyjUrl(String appTyjUrl) {
            this.appTyjUrl = appTyjUrl;
        }

        public AppActive getAppActive() {
            return appActive;
        }

        public void setAppActive(AppActive appActive) {
            this.appActive = appActive;
        }
    }

    public static class AppActive {
        private int id;
        private String url;
        private String name;
        private String pic;
        /**
         * 是否与3g交互 1 = 交互
         */
        @SerializedName("app_active")
        private int appActive;
        private String  flag;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public int getAppActive() {
            return appActive;
        }

        public void setAppActive(int appActive) {
            this.appActive = appActive;
        }

        public String getFlag() {
            return flag;
        }

        public void setFlag(String flag) {
            this.flag = flag;
        }
    }
}
