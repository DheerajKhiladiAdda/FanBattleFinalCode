package com.khiladiadda.in.fanbattle;

import com.khiladiadda.in.network.model.response.MatchResponse;
import com.khiladiadda.in.network.ApiManager;
import com.khiladiadda.in.network.ApiService;
import com.khiladiadda.in.network.IApiListener;
import com.khiladiadda.in.network.SubscriberCallback;

import rx.Subscription;

public class FanBattleInteractor {

    public Subscription getCategory(IApiListener<MatchResponse> listener, String id) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.getMatchList(id, true)).subscribe(new SubscriberCallback<>(listener));
    }

}