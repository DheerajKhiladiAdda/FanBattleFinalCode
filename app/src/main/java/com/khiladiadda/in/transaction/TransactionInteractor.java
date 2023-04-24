package com.khiladiadda.in.transaction;

import com.khiladiadda.in.network.ApiManager;
import com.khiladiadda.in.network.ApiService;
import com.khiladiadda.in.network.IApiListener;
import com.khiladiadda.in.network.SubscriberCallback;
import com.khiladiadda.in.network.model.BaseResponse;
import com.khiladiadda.in.network.model.request.PaymentHistoryRequest;
import com.khiladiadda.in.network.model.response.InvoiceResponse;
import com.khiladiadda.in.network.model.response.PaymentHistoryResponse;
import com.khiladiadda.in.network.model.response.WalletTransactionResponse;
import com.khiladiadda.in.network.model.response.WithdrawResponse;

import rx.Subscription;

public class TransactionInteractor {

    Subscription getAllTransaction(IApiListener<WalletTransactionResponse> listener, int page, int limit) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.getAllTransaction(page, limit)).subscribe(new SubscriberCallback<>(listener));
    }

    Subscription getWithdrawHistory(IApiListener<WithdrawResponse> listener, int page, int limit) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.getWithdraw(page, limit)).subscribe(new SubscriberCallback<>(listener));
    }

    Subscription getPaymentHistory(IApiListener<PaymentHistoryResponse> listener, PaymentHistoryRequest request) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.getPaymentDetails(request)).subscribe(new SubscriberCallback<>(listener));
    }

    Subscription getPaymentStatus(IApiListener<BaseResponse> listener, String id) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.getPaymentStatus(id)).subscribe(new SubscriberCallback<>(listener));
    }

    Subscription getInvoice(IApiListener<InvoiceResponse> listener, String id) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.getInvoice(id)).subscribe(new SubscriberCallback<>(listener));
    }

}