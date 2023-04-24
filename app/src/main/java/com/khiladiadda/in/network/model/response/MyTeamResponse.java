package com.khiladiadda.in.network.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.khiladiadda.in.network.model.BaseResponse;

public class MyTeamResponse extends BaseResponse {

    @SerializedName("response") @Expose private MyTeamDetails response;

    public MyTeamDetails getResponse() {
        return response;
    }

    public void setResponse(MyTeamDetails response) {
        this.response = response;
    }

}