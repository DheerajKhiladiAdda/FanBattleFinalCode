package com.khiladiadda.in.withdrawcoins.interfaces;

import com.khiladiadda.in.base.interfaces.IBasePresenter;
import com.khiladiadda.in.network.model.request.AddBeneficieryRazorpay;
import com.khiladiadda.in.network.model.request.ManualWithdrawRequest;

public interface IWithdrawPresenter extends IBasePresenter {

    void validateData();

    void getBeneficiaryList();

    void onCashfreeAddBeneficiary(String bankAccount, String ifscCode, String address, String transferMode, String vpa, String name, int transferType);

    void onCashfreeTransfer(String beneficiaryId, String amount, String otp);

    void onRazorpayAddBeneficiary(AddBeneficieryRazorpay request);

    void onRazorpayTransfer(String beneficiaryId, String paymentMode, String amount, String otp, String paytmId);

    void deleteBeneficiary(String id,int type);

    void doManualWithdraw(ManualWithdrawRequest request);

    void getManualWithdraw();

    void resendOtp(String mobile);

    void sendOtp(String mobile);

    void getWithdrawLimit();

    void verifyBeneficiary(String beneficiaryId);

    void onAddBeneficiary(String bankAccount, String ifscCode, String address, String transferMode, String vpa, String name, int transferType, String benType);

    void onApexPayTransfer(String beneficiaryId, String amount, String otp);

    void onPaySharpTransfer(String beneficiaryId, String amount, String otp);

    void onAddBeneficiaryEasebuzz(String bankAccount, String ifscCode, String transferMode, String vpa, int transferType);

    void onEasebuzzTransfer(String beneficiaryId, double amount, String otp);

}