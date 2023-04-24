package com.khiladiadda.in.fanbattle.interfaces;

import com.khiladiadda.in.network.model.response.MatchResponse;
import com.khiladiadda.in.network.model.ApiError;

public interface IFanBattleView {

    void onGetMatchListComplete(MatchResponse responseModel);

    void onGetMatchListFailure(ApiError error);

}
