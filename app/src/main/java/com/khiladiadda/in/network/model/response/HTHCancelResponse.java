package com.khiladiadda.in.network.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.khiladiadda.in.network.model.BaseResponse;

public class HTHCancelResponse extends BaseResponse {

    @SerializedName("profile") @Expose private ProfileDetails profile;

    public ProfileDetails getProfile() {
        return profile;
    }

    public void setProfile(ProfileDetails profile) {
        this.profile = profile;
    }

}