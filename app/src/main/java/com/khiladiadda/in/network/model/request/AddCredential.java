package com.khiladiadda.in.network.model.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddCredential {
    @SerializedName("game_username") @Expose public String userName;
    @SerializedName("game_character_id") @Expose public String characterId;
    @SerializedName("team_code") @Expose public String teamCode;
    @SerializedName("team_name") @Expose public String teamName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCharacterId() {
        return characterId;
    }

    public void setCharacterId(String characterId) {
        this.characterId = characterId;
    }

    public String getTeamCode() {
        return teamCode;
    }

    public void setTeamCode(String teamCode) {
        this.teamCode = teamCode;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public AddCredential(String userName, String characterId, String teamCode, String teamName) {
        this.userName = userName;
        this.characterId = characterId;
        this.teamCode = teamCode;
        this.teamName = teamName;
    }
}
