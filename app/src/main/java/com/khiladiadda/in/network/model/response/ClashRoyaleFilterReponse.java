package com.khiladiadda.in.network.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.khiladiadda.in.network.model.BaseResponse;

public class ClashRoyaleFilterReponse extends BaseResponse {

    @SerializedName("response") @Expose public Active response = null;

    public Active getResponse() {
        return response;
    }

    public void setResponse(Active response) {
        this.response = response;
    }
}