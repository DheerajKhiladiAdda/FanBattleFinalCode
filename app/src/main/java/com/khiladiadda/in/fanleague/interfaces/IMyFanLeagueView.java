package com.khiladiadda.in.fanleague.interfaces;

import com.khiladiadda.in.network.model.response.CricScorce;
import com.khiladiadda.in.network.model.response.MatchResponse;
import com.khiladiadda.in.network.model.ApiError;
import com.khiladiadda.in.network.model.CricApiError;

public interface IMyFanLeagueView {

    void onMyFanLeagueComplete(MatchResponse responseModel);

    void onMyFanLeagueFailure(ApiError error);

    void onLiveScoreComplete(CricScorce cricScorce);

    void onLiveScoreFailure(CricApiError error);

}