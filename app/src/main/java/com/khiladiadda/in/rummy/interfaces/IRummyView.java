package com.khiladiadda.in.rummy.interfaces;

import com.khiladiadda.in.network.model.ApiError;
import com.khiladiadda.in.network.model.response.RummyCheckGameResponse;
import com.khiladiadda.in.network.model.response.RummyRefreshTokenMainResponse;
import com.khiladiadda.in.network.model.response.RummyResponse;

public interface IRummyView {

    void onGetContestSuccess(RummyResponse responseModel);

    void onGetContestFailure(ApiError error);

    void onGetContestRefreshTokenSuccess(RummyRefreshTokenMainResponse responseModel);

    void onGetContestRefreshTokenFailure(ApiError error);

    void onGetContestCheckGameSuccess(RummyCheckGameResponse responseModel);

    void onGetContestCheckGameFailure(ApiError error);

}