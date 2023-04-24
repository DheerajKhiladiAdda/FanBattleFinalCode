package com.khiladiadda.in.network.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.khiladiadda.in.network.model.BaseResponse;

import java.util.List;

public class LudoContestResponse extends BaseResponse {

    @SerializedName("response")
    @Expose
    private List<LudoContest> response = null;
    @SerializedName("my_contests")
    @Expose
    private List<LudoContest> myContests = null;
    @SerializedName("banners")
    @Expose
    private List<BannerDetails> banner = null;
    @SerializedName("profile")
    @Expose
    private ProfileDetails profile;
    @SerializedName("is_popular_enabled")
    @Expose
    private boolean is_popular_enabled;
    @SerializedName("isLudoEnabled")
    @Expose
    private boolean isLudoEnabled;

    public List<LudoContest> getResponse() {
        return response;
    }

    public void setResponse(List<LudoContest> response) {
        this.response = response;
    }

    public List<LudoContest> getMyContests() {
        return myContests;
    }

    public void setMyContests(List<LudoContest> myContests) {
        this.myContests = myContests;
    }

    public List<BannerDetails> getBanner() {
        return banner;
    }

    public void setBanner(List<BannerDetails> banner) {
        this.banner = banner;
    }

    public ProfileDetails getProfile() {
        return profile;
    }

    public void setProfile(ProfileDetails profile) {
        this.profile = profile;
    }

    public boolean isIs_popular_enabled() {
        return is_popular_enabled;
    }

    public void setIs_popular_enabled(boolean is_popular_enabled) {
        this.is_popular_enabled = is_popular_enabled;
    }

    public boolean isLudoEnabled() {
        return isLudoEnabled;
    }

    public void setLudoEnabled(boolean ludoEnabled) {
        isLudoEnabled = ludoEnabled;
    }
}