package com.khiladiadda.in.scratchcard;

import com.khiladiadda.in.network.ApiManager;
import com.khiladiadda.in.network.ApiService;
import com.khiladiadda.in.network.IApiListener;
import com.khiladiadda.in.network.SubscriberCallback;
import com.khiladiadda.in.network.model.BaseResponse;
import com.khiladiadda.in.network.model.response.ScratchCardResponse;

import rx.Subscription;

public class ScratchInteractor {

    Subscription getScratchCards(IApiListener<ScratchCardResponse> listener, int type) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.getAllScratchCards(type)).subscribe(new SubscriberCallback<>(listener));
    }

    Subscription applyScratchCard(IApiListener<BaseResponse> listener, String scractchCardid) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.scratchedCard(scractchCardid)).subscribe(new SubscriberCallback<>(listener));
    }

}