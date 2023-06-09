package com.khiladiadda.in.network.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.khiladiadda.in.network.model.BaseResponse;

public class BeneficiaryVerifyResponse extends BaseResponse {

    @SerializedName("response") @Expose private String response;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}