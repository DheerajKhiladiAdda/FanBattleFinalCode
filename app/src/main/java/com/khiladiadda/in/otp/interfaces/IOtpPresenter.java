package com.khiladiadda.in.otp.interfaces;

import com.khiladiadda.in.base.interfaces.IBasePresenter;

public interface IOtpPresenter extends IBasePresenter {

    void validateData();

    void doVerifyOtp(String mobile, String otp);

    void resendOtp(String mobile);

    void doVerifyLoginOtp(String mobile, String password, String otp);

    void getMasterData();

}