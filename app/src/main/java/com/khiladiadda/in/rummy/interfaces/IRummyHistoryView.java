package com.khiladiadda.in.rummy.interfaces;
import com.khiladiadda.in.network.model.ApiError;
import com.khiladiadda.in.network.model.response.RummyHistoryMainResponse;
public interface IRummyHistoryView {
    void onGetRummyHistorySuccess(RummyHistoryMainResponse responseModel);
    void onGetRummyHistoryFailure(ApiError error);
}
