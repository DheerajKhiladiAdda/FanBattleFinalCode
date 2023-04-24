package com.khiladiadda.in.referhistory.interfaces;

import com.khiladiadda.in.network.model.ApiError;
import com.khiladiadda.in.network.model.response.ReferResponse;

public interface IReferView {

    void onReferComplete(ReferResponse responseModel);

    void onReferFailure(ApiError error);

}