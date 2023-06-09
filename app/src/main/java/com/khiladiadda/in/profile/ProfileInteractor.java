package com.khiladiadda.in.profile;

import com.khiladiadda.in.network.ApiManager;
import com.khiladiadda.in.network.ApiService;
import com.khiladiadda.in.network.IApiListener;
import com.khiladiadda.in.network.SubscriberCallback;
import com.khiladiadda.in.network.model.BaseResponse;
import com.khiladiadda.in.network.model.request.ChangePasswordRequest;
import com.khiladiadda.in.network.model.request.UpdateDOB;
import com.khiladiadda.in.network.model.request.VoucherRequest;
import com.khiladiadda.in.network.model.response.ProfileResponse;
import com.khiladiadda.in.network.model.response.ProfileTransactionResponse;

import rx.Subscription;

public class ProfileInteractor {

    public Subscription updatePassword(ChangePasswordRequest request, IApiListener<BaseResponse> listener) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.changePassword(request)).subscribe(new SubscriberCallback<>(listener));
    }

    public Subscription updateDOB(UpdateDOB request, IApiListener<ProfileResponse> listener) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.updateDOB(request)).subscribe(new SubscriberCallback<>(listener));
    }

    public Subscription getProfile(IApiListener<ProfileTransactionResponse> listener) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.getProfile(false)).subscribe(new SubscriberCallback<>(listener));
    }

    Subscription applyVocher(IApiListener<BaseResponse> listener, VoucherRequest request) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.applyVocher(request)).subscribe(new SubscriberCallback<>(listener));
    }

    Subscription sendOtp(IApiListener<BaseResponse> listener, String email) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.sendOtpEmail(email)).subscribe(new SubscriberCallback<>(listener));
    }

    Subscription verifyEmail(IApiListener<BaseResponse> listener, String email, String otp) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.verifyEmail(email, otp)).subscribe(new SubscriberCallback<>(listener));
    }
}