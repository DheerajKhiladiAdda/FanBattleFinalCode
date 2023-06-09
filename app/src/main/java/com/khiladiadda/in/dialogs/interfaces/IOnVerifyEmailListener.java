package com.khiladiadda.in.dialogs.interfaces;

public interface IOnVerifyEmailListener {

    void onSendOTP(String email);

    void onVerifyEmail(String email, String otp);

    void onResendOTP(String email);
}