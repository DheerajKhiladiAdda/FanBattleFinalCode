package com.khiladiadda.in.socialverify.interfaces;

import com.khiladiadda.in.network.model.ApiError;
import com.khiladiadda.in.network.model.response.MasterResponse;
import com.khiladiadda.in.network.model.response.OtpResponse;
import com.khiladiadda.in.network.model.response.SocialResponse;

public interface ISocialVerifyView {

    String getMobileNumber();

    void onValidationComplete();

    void onValidationFailure(String errorMsg);

    void onGmailLoginComplete(SocialResponse responseModel);

    void onGmailLoginFailure(ApiError error);

    void onFbLoginComplete(SocialResponse responseModel);

    void onFbLoginFailure(ApiError error);

    void onVerifyOtpComplete(OtpResponse responseModel);

    void onVerifyOtpFailure(ApiError error);

    void onResendOtpComplete(OtpResponse responseModel);

    void onResendOtpFailure(ApiError error);

    void onMasterComplete(MasterResponse responseModel);

    void onMasterFailure(ApiError error);

}