package com.khiladiadda.in.base.interfaces;

import com.khiladiadda.in.network.model.ApiError;
import com.khiladiadda.in.network.model.response.VersionResponse;

public interface IBaseView {

    void onVersionSuccess(VersionResponse response);

    void onVersionFailure(ApiError error);

}