package com.khiladiadda.in.main.interfaces;

import com.khiladiadda.in.network.model.ApiError;
import com.khiladiadda.in.network.model.BaseResponse;
import com.khiladiadda.in.network.model.response.DashboardResponse;

public interface IMainView {

    void onTrendingQuizComplete(DashboardResponse responseModel);

    void onTrendingQuizFailure(ApiError error);

    void onUpdateFavouriteComplete(BaseResponse responseModel);

    void onUpdateFavouriteFailure(ApiError error);

}