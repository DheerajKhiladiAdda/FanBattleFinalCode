package com.khiladiadda.in.network.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.khiladiadda.in.network.model.BaseResponse;

import java.util.List;

public class VersionResponse extends BaseResponse {

    @SerializedName("response") @Expose private VersionDetails response = null;

    public VersionDetails getVersion() {
        return response;
    }

    public void setVersion(VersionDetails version) {
        this.response = version;
    }

    @SerializedName("topUsers") @Expose private List<TopUsersDetails> topUsers = null;

    public List<TopUsersDetails> getTopUsers() {
        return topUsers;
    }

    public void setTopUsers(List<TopUsersDetails> topUsers) {
        this.topUsers = topUsers;
    }

    @SerializedName("banners") @Expose private List<BannerDetails> banners = null;

    public List<BannerDetails> getBanners() {
        return banners;
    }

    public void setBanners(List<BannerDetails> banners) {
        this.banners = banners;
    }

}