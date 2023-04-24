package com.khiladiadda.in.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BaseResponse {

    @SerializedName("status") @Expose private boolean status;
    @SerializedName("message") @Expose private String message;
    @SerializedName("systemInfo") @Expose private int systemInfo;
    @SerializedName("type") @Expose private int type;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getSystemInfo() {
        return systemInfo;
    }

    public void setSystemInfo(int systemInfo) {
        this.systemInfo = systemInfo;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}