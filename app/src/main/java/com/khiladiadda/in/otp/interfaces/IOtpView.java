package com.khiladiadda.in.otp.interfaces;

import com.khiladiadda.in.network.model.ApiError;
import com.khiladiadda.in.network.model.response.LoginResponse;
import com.khiladiadda.in.network.model.response.MasterResponse;
import com.khiladiadda.in.network.model.response.OtpResponse;

public interface IOtpView {

    String getOtp();

    void onValidationComplete();

    void onValidationFailure(String errorMsg);

    void onVerifyOtpComplete(OtpResponse responseModel);

    void onVerifyOtpFailure(ApiError error);

    void onResendOtpComplete(OtpResponse responseModel);

    void onResendOtpFailure(ApiError error);

    void onVerifyLoginOtpComplete(LoginResponse responseModel);

    void onVerifyLoginOtpFailure(ApiError error);

    void onMasterComplete(MasterResponse responseModel);

    void onMasterFailure(ApiError error);

}