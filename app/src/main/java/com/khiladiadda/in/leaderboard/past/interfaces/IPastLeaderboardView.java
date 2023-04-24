package com.khiladiadda.in.leaderboard.past.interfaces;

import com.khiladiadda.in.network.model.response.SquadLeaderbordResponse;
import com.khiladiadda.in.network.model.ApiError;

public interface IPastLeaderboardView {

    void onPastLeaderBoardComplete(SquadLeaderbordResponse responseModel);

    void onPastLeaderBoardFailure(ApiError error);

}
