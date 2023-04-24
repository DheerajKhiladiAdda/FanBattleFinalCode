package com.khiladiadda.in.fcm;

import com.khiladiadda.in.network.ApiManager;
import com.khiladiadda.in.network.ApiService;
import com.khiladiadda.in.network.IApiListener;
import com.khiladiadda.in.network.SubscriberCallback;
import com.khiladiadda.in.network.model.BaseResponse;
import com.khiladiadda.in.network.model.request.FcmRequest;

import rx.Subscription;

public class FCMInteractor {

    public FCMInteractor() { }

    public Subscription updateLeague(IApiListener<BaseResponse> listener, FcmRequest request) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.updateLeague(request)).subscribe(new SubscriberCallback<>(listener));
    }

}