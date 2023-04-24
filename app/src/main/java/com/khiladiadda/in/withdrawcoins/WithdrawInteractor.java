package com.khiladiadda.in.withdrawcoins;

import com.khiladiadda.in.network.ApiManager;
import com.khiladiadda.in.network.ApiService;
import com.khiladiadda.in.network.IApiListener;
import com.khiladiadda.in.network.SubscriberCallback;
import com.khiladiadda.in.network.model.BaseResponse;
import com.khiladiadda.in.network.model.request.AddBeneficiaryRequest;
import com.khiladiadda.in.network.model.request.AddBeneficieryRazorpay;
import com.khiladiadda.in.network.model.request.ManualWithdrawRequest;
import com.khiladiadda.in.network.model.request.RazorpayTransferAmountRequest;
import com.khiladiadda.in.network.model.request.ResendOtpRequest;
import com.khiladiadda.in.network.model.request.SendOTPRequest;
import com.khiladiadda.in.network.model.request.TransferAmountRequest;
import com.khiladiadda.in.network.model.response.AddBeneficiaryResponse;
import com.khiladiadda.in.network.model.response.BeneficiaryResponse;
import com.khiladiadda.in.network.model.response.BeneficiaryVerifyResponse;
import com.khiladiadda.in.network.model.response.ManualWithdrawResponse;
import com.khiladiadda.in.network.model.response.OtpResponse;
import com.khiladiadda.in.network.model.response.PayoutResponse;
import com.khiladiadda.in.network.model.response.WIthdrawLimitResponse;

import rx.Subscription;

public class WithdrawInteractor {

    public Subscription addCashfreeBeneficiary(AddBeneficiaryRequest request, IApiListener<AddBeneficiaryResponse> listener) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.addCashfreeBeneficiary(request)).subscribe(new SubscriberCallback<>(listener));
    }

    public Subscription transferAmount(TransferAmountRequest request, String id, IApiListener<PayoutResponse> listener) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.transferAmount(request, id)).subscribe(new SubscriberCallback<>(listener));
    }

    public Subscription getWithdraw(IApiListener<BeneficiaryResponse> listener) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.getBeneficiaryList()).subscribe(new SubscriberCallback<>(listener));
    }

    public Subscription deleteBeneficiary(String id,int type, IApiListener<BaseResponse> listener) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.deleteBeneficiary(id,type)).subscribe(new SubscriberCallback<>(listener));
    }

    public Subscription doManualWithdraw(ManualWithdrawRequest request, IApiListener<BaseResponse> listener) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.doManualWithdraw(request)).subscribe(new SubscriberCallback<>(listener));
    }

    public Subscription getManualWithdraw(IApiListener<ManualWithdrawResponse> listener) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.getManualWithdraw()).subscribe(new SubscriberCallback<>(listener));
    }

    public Subscription resendOtp(ResendOtpRequest request, IApiListener<OtpResponse> listener) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.resendOTP(request)).subscribe(new SubscriberCallback<>(listener));
    }

    public Subscription sendOtp(SendOTPRequest request, IApiListener<BaseResponse> listener) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.sendOTP(request)).subscribe(new SubscriberCallback<>(listener));
    }

    public Subscription addRazorpayBeneficiary(AddBeneficieryRazorpay request, IApiListener<AddBeneficiaryResponse> listener) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.addRazorpayBeneficiary(request)).subscribe(new SubscriberCallback<>(listener));
    }

    public Subscription transferRazorpayAmount(RazorpayTransferAmountRequest request, IApiListener<PayoutResponse> listener) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.transferRazorpayAmount(request)).subscribe(new SubscriberCallback<>(listener));
    }

    public Subscription getWithdrawLimit(IApiListener<WIthdrawLimitResponse> listener) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.getWithdrawLimit()).subscribe(new SubscriberCallback<>(listener));
    }

    public Subscription verifyBeneficiary(IApiListener<BeneficiaryVerifyResponse> listener, String beneficiaryId) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.verifyBeneficiary(beneficiaryId)).subscribe(new SubscriberCallback<>(listener));
    }

    public Subscription onApexPayTransfer(IApiListener<PayoutResponse> listener, String beneficiaryId, String amount, String otp) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.onApexPayTransfer(beneficiaryId, amount, otp)).subscribe(new SubscriberCallback<>(listener));
    }

    public Subscription onPaySharpTransfer(IApiListener<PayoutResponse> listener, String beneficiaryId, String amount, String otp) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.onPaySharpTransfer(beneficiaryId, amount, otp)).subscribe(new SubscriberCallback<>(listener));
    }

    public Subscription addBeneficiary(AddBeneficiaryRequest request, IApiListener<AddBeneficiaryResponse> listener) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.addBeneficiary(request)).subscribe(new SubscriberCallback<>(listener));
    }

    public Subscription addBeneficiaryEasebuzz(AddBeneficiaryRequest request, IApiListener<AddBeneficiaryResponse> listener) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.addBeneficiaryEasebuzz(request)).subscribe(new SubscriberCallback<>(listener));
    }

    public Subscription onEasebuzzTransfer(IApiListener<PayoutResponse> listener, String beneficiaryId, double amount, String otp) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.onEasebuzzTransfer(beneficiaryId, amount, otp)).subscribe(new SubscriberCallback<>(listener));
    }

}