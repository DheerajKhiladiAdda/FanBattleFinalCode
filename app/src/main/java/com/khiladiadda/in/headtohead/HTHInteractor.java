package com.khiladiadda.in.headtohead;

import com.khiladiadda.in.network.ApiManager;
import com.khiladiadda.in.network.ApiService;
import com.khiladiadda.in.network.IApiListener;
import com.khiladiadda.in.network.SubscriberCallback;
import com.khiladiadda.in.network.model.response.HTHCancelResponse;
import com.khiladiadda.in.network.model.response.hth.HTHMainResponse;
import com.khiladiadda.in.network.model.response.hth.Result;

import rx.Subscription;

public class HTHInteractor {

    public Subscription getHTHMatches(IApiListener<HTHMainResponse> listener, String id) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.getMyHTHBattle(true, id)).subscribe(new SubscriberCallback<>(listener));
    }

    public Subscription onCancelBattle(IApiListener<HTHCancelResponse> listener, String id) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.CancelBattle(id)).subscribe(new SubscriberCallback<>(listener));
    }

    public Subscription onResultBattle(IApiListener<Result> listener, String id) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.getResult(id)).subscribe(new SubscriberCallback<>(listener));
    }

    public Subscription getMatchStatus(IApiListener<HTHMainResponse> listener, String matchId) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.getMatchStatus(matchId)).subscribe(new SubscriberCallback<>(listener));
    }

}