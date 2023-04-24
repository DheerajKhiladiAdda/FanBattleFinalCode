package com.khiladiadda.in.referhistory;

import com.khiladiadda.in.network.ApiManager;
import com.khiladiadda.in.network.ApiService;
import com.khiladiadda.in.network.IApiListener;
import com.khiladiadda.in.network.SubscriberCallback;
import com.khiladiadda.in.network.model.response.ReferResponse;

import rx.Subscription;

public class ReferInteractor {

    public Subscription getRefer(IApiListener<ReferResponse> listener) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.getRefer()).subscribe(new SubscriberCallback<>(listener));
    }

}