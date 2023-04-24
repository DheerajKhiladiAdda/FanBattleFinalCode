package com.khiladiadda.in.socialverify;

import com.khiladiadda.in.network.ApiManager;
import com.khiladiadda.in.network.ApiService;
import com.khiladiadda.in.network.IApiListener;
import com.khiladiadda.in.network.SubscriberCallback;
import com.khiladiadda.in.network.model.request.FBRegisterRequest;
import com.khiladiadda.in.network.model.request.GmailRegisterRequest;
import com.khiladiadda.in.network.model.request.OtpRequest;
import com.khiladiadda.in.network.model.request.ResendOtpRequest;
import com.khiladiadda.in.network.model.response.MasterResponse;
import com.khiladiadda.in.network.model.response.OtpResponse;
import com.khiladiadda.in.network.model.response.SocialResponse;

import rx.Subscription;

public class SocialVerifyInteractor {

    public Subscription doGmailRegister(GmailRegisterRequest request, IApiListener<SocialResponse> listener) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.gmailRegister(request)).subscribe(new SubscriberCallback<SocialResponse>(listener));
    }

    public Subscription doFbRegister(FBRegisterRequest request, IApiListener<SocialResponse> listener) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.fbRegister(request)).subscribe(new SubscriberCallback<SocialResponse>(listener));
    }

    public Subscription verifyOtp(OtpRequest request, IApiListener<OtpResponse> listener) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.verifyOtp(request)).subscribe(new SubscriberCallback<OtpResponse>(listener));
    }

    public Subscription resendOtp(ResendOtpRequest request, IApiListener<OtpResponse> listener) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.resendOTP(request)).subscribe(new SubscriberCallback<OtpResponse>(listener));
    }

    public Subscription getMaster(IApiListener<MasterResponse> listener) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.getMaster()).subscribe(new SubscriberCallback<MasterResponse>(listener));
    }

}