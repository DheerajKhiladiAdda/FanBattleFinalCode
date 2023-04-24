package com.khiladiadda.in.splash.interfaces;

import com.khiladiadda.in.network.model.ApiError;
import com.khiladiadda.in.network.model.response.MasterResponse;
import com.khiladiadda.in.network.model.response.VersionResponse;

public interface ISplashView {

    void onMasterComplete(MasterResponse responseModel);

    void onMasterFailure(ApiError error);

    void onVersionSuccess(VersionResponse response);

    void onVersionFailure(ApiError error);

}