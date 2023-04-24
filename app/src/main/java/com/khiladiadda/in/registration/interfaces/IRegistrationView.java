package com.khiladiadda.in.registration.interfaces;

import com.khiladiadda.in.network.model.ApiError;
import com.khiladiadda.in.network.model.BaseResponse;

public interface IRegistrationView {

    String getName();

    String getMobileNumber();

    String getReferenceNo();

    void onValidationComplete();

    void onValidationFailure(String errorMsg);

    void onRegisterComplete(BaseResponse responseModel);

    void onRegisterFailure(ApiError error);

}