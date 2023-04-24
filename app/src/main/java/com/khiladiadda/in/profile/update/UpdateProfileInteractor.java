package com.khiladiadda.in.profile.update;

import com.khiladiadda.in.network.VerifiApiManger;
import com.khiladiadda.in.network.VerifiSubscriberCallback;
import com.khiladiadda.in.network.model.BaseResponse;
import com.khiladiadda.in.network.model.request.PanUpdateRequest;
import com.khiladiadda.in.network.model.request.VerifyOtpSurepass;
import com.khiladiadda.in.network.model.response.ProfileResponse;
import com.khiladiadda.in.network.ApiManager;
import com.khiladiadda.in.network.ApiService;
import com.khiladiadda.in.network.IApiListener;
import com.khiladiadda.in.network.SubscriberCallback;
import com.khiladiadda.in.network.model.request.ProfileRequest;
import com.khiladiadda.in.network.model.response.UploadImageResponse;
import com.khiladiadda.in.network.model.request.AadhaarRequest;
import com.khiladiadda.in.network.model.response.AadharCaptchaResponse;
import com.khiladiadda.in.network.model.response.AadharDetailsResponse;
import com.khiladiadda.in.network.model.request.AadharUpdateRequest;
import com.khiladiadda.in.network.model.request.CaptchaRequest;
import com.khiladiadda.in.network.model.request.CheckAadharRequest;
import com.khiladiadda.in.network.model.request.GetOtpRequest;
import com.khiladiadda.in.network.model.response.VerifiBaseResponse;
import com.khiladiadda.in.network.model.request.VerifyOtpRequest;
import com.khiladiadda.in.network.model.response.WIthdrawLimitResponse;

import okhttp3.MultipartBody;
import rx.Subscription;

public class UpdateProfileInteractor {

    public Subscription updateProfile(ProfileRequest request, IApiListener<ProfileResponse> listener) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.updateProfile(request))
                .subscribe(new SubscriberCallback<>(listener));
    }

    public Subscription uploadImage(final IApiListener<UploadImageResponse> loginApiListener, MultipartBody.Part image, int type) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createMultipartService();
        return manager.createObservable(service.uploadImage(image, type))
                .subscribe(new SubscriberCallback<>(loginApiListener));
    }

    public Subscription updatePAN(PanUpdateRequest request, IApiListener<ProfileResponse> listener) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.updatePAN(request)).subscribe(new SubscriberCallback<>(listener));
    }

    public Subscription checkAadhar(CheckAadharRequest request, IApiListener<BaseResponse> listener) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.checkAadhar(request)).subscribe(new SubscriberCallback<>(listener));
    }

    public Subscription updateAadhar(AadharUpdateRequest request, IApiListener<ProfileResponse> listener) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.updateAadhar(request)).subscribe(new SubscriberCallback<>(listener));
    }

    public Subscription getCaptcha(CaptchaRequest request, IApiListener<AadharCaptchaResponse> listener) {
        VerifiApiManger manager = VerifiApiManger.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.getCaptcha(request)).subscribe(new VerifiSubscriberCallback<>(listener));
    }

    public Subscription getAadhaarOTP(GetOtpRequest request, IApiListener<VerifiBaseResponse> listener) {
        VerifiApiManger manager = VerifiApiManger.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.getAadhaarOTP(request)).subscribe(new VerifiSubscriberCallback<>(listener));
    }

    public Subscription verifyAadhaarOtp(VerifyOtpRequest request, IApiListener<VerifiBaseResponse> listener) {
        VerifiApiManger manager = VerifiApiManger.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.verifyAadhaarOTP(request)).subscribe(new VerifiSubscriberCallback<>(listener));
    }

    public Subscription getAadhaarKYCDetails(AadhaarRequest request, IApiListener<AadharDetailsResponse> listener) {
        VerifiApiManger manager = VerifiApiManger.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.getKYCDetails(request)).subscribe(new VerifiSubscriberCallback<>(listener));
    }

    public Subscription updateAadhaarOnServer(AadharUpdateRequest request, IApiListener<ProfileResponse> listener) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.updateAadhaar(request)).subscribe(new SubscriberCallback<>(listener));
    }

    public Subscription getWithdrawLimit(IApiListener<WIthdrawLimitResponse> listener) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.getWithdrawLimit()).subscribe(new SubscriberCallback<>(listener));
    }

    public Subscription verifyAadhaarOtpSurepass(VerifyOtpSurepass request, IApiListener<ProfileResponse> listener) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.verifyAadharOTPSurepass(request)).subscribe(new SubscriberCallback<>(listener));
    }

    public Subscription verifyBeneficiary(IApiListener<BaseResponse> listener, String beneficiaryId) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.verifyBeneficiary(beneficiaryId)).subscribe(new SubscriberCallback<>(listener));
    }

}