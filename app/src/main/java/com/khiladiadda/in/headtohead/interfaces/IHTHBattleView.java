package com.khiladiadda.in.headtohead.interfaces;

import com.khiladiadda.in.network.model.ApiError;
import com.khiladiadda.in.network.model.response.HTHCancelResponse;
import com.khiladiadda.in.network.model.response.hth.HTHMainResponse;
import com.khiladiadda.in.network.model.response.hth.Result;

public interface IHTHBattleView {
    void onGetHTHMatchListComplete(HTHMainResponse responseModel);

    void onGetHTHMatchListFailure(ApiError error);

    void onCancelBattle(HTHCancelResponse responseModel);

    void onCancelBattleFailure(ApiError error);

    void onGetResultBattle(Result responseModel);

    void onResultBattleFailure(ApiError error);

    void onMatchStatus(HTHMainResponse responseModel);

    void onMatchStatusError(ApiError error);

}
