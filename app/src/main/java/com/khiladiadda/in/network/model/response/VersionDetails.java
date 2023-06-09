package com.khiladiadda.in.network.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VersionDetails {

    @SerializedName("app_version") @Expose private String appVersion;
    @SerializedName("apk_link") @Expose private String apkLink;
    @SerializedName("apk_size") @Expose private long apkSize;
    @SerializedName("update_description") @Expose private String updateDescription;
    @SerializedName("cashfree_enabled") @Expose private boolean cashfreeEnable;
    @SerializedName("paytm_enabled") @Expose private boolean paytmEnable;
    @SerializedName("payu_enabled") @Expose private boolean payuEnable;
    @SerializedName("razorpay_enabled") @Expose private boolean razorpayEnable;
    @SerializedName("paykun_enabled") @Expose private boolean paykunEnable;
    @SerializedName("is_facebook") @Expose private boolean isFB;
    @SerializedName("is_gmail") @Expose private boolean isGmail;
    @SerializedName("support_number")@Expose private String support_number;
    @SerializedName("withdraw_commission") @Expose private List<WithdrawComissionDetails> withdrawCommission = null;
    @SerializedName("easebuzz_enabled") @Expose private boolean easebuzzEnable;
    @SerializedName("upi_enable") @Expose private int upiEnable;
    @SerializedName("rummy_link") @Expose private String rummyLink;

    public String getRummyLink() {
        return rummyLink;
    }

    public void setRummyLink(String rummyLink) {
        this.rummyLink = rummyLink;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getApkLink() {
        return apkLink;
    }

    public void setApkLink(String apkLink) {
        this.apkLink = apkLink;
    }

    public long getApkSize() {
        return apkSize;
    }

    public void setApkSize(long apkSize) {
        this.apkSize = apkSize;
    }

    public String getUpdateDescription() {
        return updateDescription;
    }

    public void setUpdateDescription(String updateDescription) {
        this.updateDescription = updateDescription;
    }

    public boolean isCashfreeEnable() {
        return cashfreeEnable;
    }

    public void setCashfreeEnable(boolean cashfreeEnable) {
        this.cashfreeEnable = cashfreeEnable;
    }

    public boolean isPaytmEnable() {
        return paytmEnable;
    }

    public void setPaytmEnable(boolean paytmEnable) {
        this.paytmEnable = paytmEnable;
    }

    public boolean isPayuEnable() {
        return payuEnable;
    }

    public void setPayuEnable(boolean payuEnable) {
        this.payuEnable = payuEnable;
    }

    public boolean isRazorpayEnable() {
        return razorpayEnable;
    }

    public void setRazorpayEnable(boolean razorpayEnable) {
        this.razorpayEnable = razorpayEnable;
    }

    public boolean isPaykunEnable() {
        return paykunEnable;
    }

    public void setPaykunEnable(boolean paykunEnable) {
        this.paykunEnable = paykunEnable;
    }

    public boolean isFB() {
        return isFB;
    }

    public void setFB(boolean FB) {
        isFB = FB;
    }

    public boolean isGmail() {
        return isGmail;
    }

    public void setGmail(boolean gmail) {
        isGmail = gmail;
    }
    public String getSupport_number() {
        return support_number;
    }

    public void setSupport_number(String support_number) {
        this.support_number = support_number;
    }

    public List<WithdrawComissionDetails> getWithdrawCommission() {
        return withdrawCommission;
    }

    public void setWithdrawCommission(List<WithdrawComissionDetails> withdrawCommission) {
        this.withdrawCommission = withdrawCommission;
    }

    public boolean isEasebuzzEnable() {
        return easebuzzEnable;
    }

    public void setEasebuzzEnable(boolean easebuzzEnable) {
        this.easebuzzEnable = easebuzzEnable;
    }

    public int getUpiEnable() {
        return upiEnable;
    }

    public void setUpiEnable(int upiEnable) {
        this.upiEnable = upiEnable;
    }

}