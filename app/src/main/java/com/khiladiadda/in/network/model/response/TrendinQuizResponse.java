package com.khiladiadda.in.network.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.khiladiadda.in.network.model.BaseResponse;

import java.util.List;

public class TrendinQuizResponse extends BaseResponse {

    @SerializedName("response") @Expose private List<QuizListDetails> response = null;

    public List<QuizListDetails> getResponse() {
        return response;
    }

    public void setResponse(List<QuizListDetails> response) {
        this.response = response;
    }
}