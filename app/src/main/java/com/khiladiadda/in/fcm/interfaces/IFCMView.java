package com.khiladiadda.in.fcm.interfaces;

import com.khiladiadda.in.network.model.ApiError;
import com.khiladiadda.in.network.model.BaseResponse;

public interface IFCMView {

    void onFcmUpdateComplete(BaseResponse responseModel);

    void onFcmUpdateFailure(ApiError error);

}