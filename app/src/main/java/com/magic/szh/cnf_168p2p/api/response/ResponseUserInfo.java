package com.magic.szh.cnf_168p2p.api.response;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/**
 * project: CNF_168p2p
 * package: com.magic.szh.cnf_168p2p.api.response
 * file: ResponseUserInfo
 * author: admin
 * date: 2018/3/6
 * description: 用户信息 - 实体类
 */

public class ResponseUserInfo extends BaseResponse {
    public static ResponseUserInfo getInstance(String json) {
        return new Gson().fromJson(json, ResponseUserInfo.class);
    }

    @SerializedName("user_id")
    private String userId;
    /**
     * 用户类型 [1.白名单用户 2.借款人 3.投资人]
     */
    @SerializedName("user_type")
    private int userType;
    private String email;
    private String  username;
    @SerializedName("reg_type")
    private String regType;
    @SerializedName("realname")
    private String realName;
    @SerializedName("card_id")
    private String cardId;
    @SerializedName("realname_status")
    private int realNameStatus;
    /**
     * 是否开户 空位未开户
     */
    private String platcust;
    private String phone;
    @SerializedName("phone_status")
    private int phoneStatus;
    @SerializedName("headimgurl")
    private String headImgUrl;
    @SerializedName("block_status")
    private int blockStatus;
    private int com;
    private int isInvest;
    private int isPhoneReg;
    private String sex;
    private int isTenderTest;
    private int iskey;
    private String key;
    @SerializedName("set_num")
    private int setNum;
    @SerializedName("invite_code")
    private String inviteCode;
    //论坛登入地址
    private String bbsUrl;
    private int isPartner;  //是否是合伙人0没有1有
    private int isRoyalty; //是否有体验金 0没有1有
    private int isMoney;   // 是否可以提现
    private String isMoneymsg; //不能提现的提示语
    private int isTestTender;//是否投资过新手标
    @SerializedName("partner_url")
    private String partnerUrl;//合伙人地址
    @SerializedName("power_url")
    private String powerUrl;//债权授权地址 为空为已经授权
    private int type;//账户类型 0--普通账户,1--企业账户
    @SerializedName("address_status")
    private int addressStatus;////收件地址提交状态  1已提交 0未提交
    private Invite invite;
    private int vip;
    @SerializedName("vipimg")
    private String vipImg;
    @SerializedName("vip_question")
    private String vipQuestion;
    @SerializedName("click_status")
    private int clickStatus;
    private String tip;
    @SerializedName("huifu_cash_url")
    private String huifuCashUrl = "";//这个字段是判断汇付提现入口地址，如果请求无该字段，代表用户汇付无余额，就将汇付提现入口关闭。

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRegType() {
        return regType;
    }

    public void setRegType(String regType) {
        this.regType = regType;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public int getRealNameStatus() {
        return realNameStatus;
    }

    public void setRealNameStatus(int realNameStatus) {
        this.realNameStatus = realNameStatus;
    }

    public String getPlatcust() {
        return platcust;
    }

    public void setPlatcust(String platcust) {
        this.platcust = platcust;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getPhoneStatus() {
        return phoneStatus;
    }

    public void setPhoneStatus(int phoneStatus) {
        this.phoneStatus = phoneStatus;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public int getBlockStatus() {
        return blockStatus;
    }

    public void setBlockStatus(int blockStatus) {
        this.blockStatus = blockStatus;
    }

    public int getCom() {
        return com;
    }

    public void setCom(int com) {
        this.com = com;
    }

    public int getIsInvest() {
        return isInvest;
    }

    public void setIsInvest(int isInvest) {
        this.isInvest = isInvest;
    }

    public int getIsPhoneReg() {
        return isPhoneReg;
    }

    public void setIsPhoneReg(int isPhoneReg) {
        this.isPhoneReg = isPhoneReg;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getIsTenderTest() {
        return isTenderTest;
    }

    public void setIsTenderTest(int isTenderTest) {
        this.isTenderTest = isTenderTest;
    }

    public int getIskey() {
        return iskey;
    }

    public void setIskey(int iskey) {
        this.iskey = iskey;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getSetNum() {
        return setNum;
    }

    public void setSetNum(int setNum) {
        this.setNum = setNum;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }

    public String getBbsUrl() {
        return bbsUrl;
    }

    public void setBbsUrl(String bbsUrl) {
        this.bbsUrl = bbsUrl;
    }

    public int getIsPartner() {
        return isPartner;
    }

    public void setIsPartner(int isPartner) {
        this.isPartner = isPartner;
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

    public String getIsMoneymsg() {
        return isMoneymsg;
    }

    public void setIsMoneymsg(String isMoneymsg) {
        this.isMoneymsg = isMoneymsg;
    }

    public int getIsTestTender() {
        return isTestTender;
    }

    public void setIsTestTender(int isTestTender) {
        this.isTestTender = isTestTender;
    }

    public String getPartnerUrl() {
        return partnerUrl;
    }

    public void setPartnerUrl(String partnerUrl) {
        this.partnerUrl = partnerUrl;
    }

    public String getPowerUrl() {
        return powerUrl;
    }

    public void setPowerUrl(String powerUrl) {
        this.powerUrl = powerUrl;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getAddressStatus() {
        return addressStatus;
    }

    public void setAddressStatus(int addressStatus) {
        this.addressStatus = addressStatus;
    }

    public Invite getInvite() {
        return invite;
    }

    public void setInvite(Invite invite) {
        this.invite = invite;
    }

    public int getVip() {
        return vip;
    }

    public void setVip(int vip) {
        this.vip = vip;
    }

    public String getVipImg() {
        return vipImg;
    }

    public void setVipImg(String vipImg) {
        this.vipImg = vipImg;
    }

    public String getVipQuestion() {
        return vipQuestion;
    }

    public void setVipQuestion(String vipQuestion) {
        this.vipQuestion = vipQuestion;
    }

    public int getClickStatus() {
        return clickStatus;
    }

    public void setClickStatus(int clickStatus) {
        this.clickStatus = clickStatus;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getHuifuCashUrl() {
        return huifuCashUrl;
    }

    public void setHuifuCashUrl(String huifuCashUrl) {
        this.huifuCashUrl = huifuCashUrl;
    }

    public static class Invite {
        private String url;
        @SerializedName("share_id")
        private String shareId;
        private String status;
        private String name;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getShareId() {
            return shareId;
        }

        public void setShareId(String shareId) {
            this.shareId = shareId;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
