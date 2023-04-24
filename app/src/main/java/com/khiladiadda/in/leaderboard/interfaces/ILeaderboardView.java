package com.khiladiadda.in.leaderboard.interfaces;

import com.khiladiadda.in.network.model.response.AllLeaderBoardResponse;
import com.khiladiadda.in.network.model.response.LudoAddaMainResponse;
import com.khiladiadda.in.network.model.response.LudoLeaderboardResponse;
import com.khiladiadda.in.network.model.ApiError;
import com.khiladiadda.in.network.model.response.OverallLeadBoardResponse;
import com.khiladiadda.in.network.model.response.hth.LeaderBoardHthResponse;

public interface ILeaderboardView {

    void onLeaderBoardComplete(AllLeaderBoardResponse responseModel);

    void onLeaderBoardFailure(ApiError error);

    void onLudoLeaderBoardComplete(LudoLeaderboardResponse responseModel);

    void onLudoLeaderBoardFailure(ApiError error);

    void onLeaderFanBattleComplete(OverallLeadBoardResponse responseModel);

    void onLeaderFanBattleFailure(ApiError error);

    void onLeaderHTHBattleComplete(LeaderBoardHthResponse responseModel);

    void onLeaderHTHBattleFailure(ApiError error);

    void onLeaderLudoAddaComplete(LudoAddaMainResponse responseModel);

    void onLeaderLudoAdda(ApiError error);

}