package com.khiladiadda.in.login;

import com.khiladiadda.in.network.ApiManager;
import com.khiladiadda.in.network.ApiService;
import com.khiladiadda.in.network.IApiListener;
import com.khiladiadda.in.network.SubscriberCallback;
import com.khiladiadda.in.network.model.BaseResponse;
import com.khiladiadda.in.network.model.request.FBVerifyRequest;
import com.khiladiadda.in.network.model.request.GmailVerifyRequest;
import com.khiladiadda.in.network.model.request.LoginRequest;
import com.khiladiadda.in.network.model.response.MasterResponse;
import com.khiladiadda.in.network.model.response.SocialResponse;

import rx.Subscription;

public class LoginInteractor {

    public Subscription doLogin(LoginRequest request, IApiListener<BaseResponse> listener) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.login(request)).subscribe(new SubscriberCallback<>(listener));
    }

    public Subscription doGmailLogin(GmailVerifyRequest request, IApiListener<SocialResponse> listener) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.gmailLogin(request)).subscribe(new SubscriberCallback<>(listener));
    }

    public Subscription doFbLogin(FBVerifyRequest request, IApiListener<SocialResponse> listener) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.fbLogin(request)).subscribe(new SubscriberCallback<>(listener));
    }

    public Subscription getMaster(IApiListener<MasterResponse> listener) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.getMaster()).subscribe(new SubscriberCallback<>(listener));
    }

}