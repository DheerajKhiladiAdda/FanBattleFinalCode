package com.khiladiadda.in.otp;

import com.khiladiadda.in.network.ApiManager;
import com.khiladiadda.in.network.ApiService;
import com.khiladiadda.in.network.IApiListener;
import com.khiladiadda.in.network.SubscriberCallback;
import com.khiladiadda.in.network.model.request.LoginVerifyOtpRequest;
import com.khiladiadda.in.network.model.request.OtpRequest;
import com.khiladiadda.in.network.model.request.ResendOtpRequest;
import com.khiladiadda.in.network.model.response.LoginResponse;
import com.khiladiadda.in.network.model.response.MasterResponse;
import com.khiladiadda.in.network.model.response.OtpResponse;

import rx.Subscription;

public class OtpInteractor {

    public Subscription doVerifyOtp(OtpRequest request, IApiListener<OtpResponse> listener) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.verifyOtp(request)).subscribe(new SubscriberCallback<>(listener));
    }

    public Subscription resendOtp(ResendOtpRequest request, IApiListener<OtpResponse> listener) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.resendOTP(request)).subscribe(new SubscriberCallback<>(listener));
    }

    public Subscription getMaster(IApiListener<MasterResponse> listener) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.getMaster()).subscribe(new SubscriberCallback<>(listener));
    }

    public Subscription doVerifyLoginOtp(LoginVerifyOtpRequest request, IApiListener<LoginResponse> listener) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.verifyOTPonLogin(request)).subscribe(new SubscriberCallback<>(listener));
    }

}