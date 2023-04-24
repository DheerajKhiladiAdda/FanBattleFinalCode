package com.khiladiadda.in.network;

import com.khiladiadda.in.network.model.ApiError;

public interface IApiListener<T> {

    void onSuccess(T response);

    void onError(ApiError error);
}