package com.khiladiadda.in.battle.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.khiladiadda.in.network.model.BaseResponse;

import java.util.List;

public class BattleResponse extends BaseResponse {

    @SerializedName("response") @Expose private List<BattleDetails> response = null;

    public List<BattleDetails> getResponse() {
        return response;
    }

    public void setResponse(List<BattleDetails> response) {
        this.response = response;
    }

}