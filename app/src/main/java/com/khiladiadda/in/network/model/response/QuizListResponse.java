package com.khiladiadda.in.network.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.khiladiadda.in.network.model.BaseResponse;

public class QuizListResponse extends BaseResponse {

    @SerializedName("response") @Expose private QuizResponse response = null;

    public QuizResponse getResponse() {
        return response;
    }

    public void setResponse(QuizResponse response) {
        this.response = response;
    }
}
