package com.khiladiadda.in.network.model.response.hth;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.khiladiadda.in.network.model.BaseResponse;

public class Result extends BaseResponse {
    @SerializedName("response")
    @Expose
    private ResultList response;

    public ResultList getResponse() {
        return response;
    }

    public void setResponse(ResultList response) {
        this.response = response;
    }
}
