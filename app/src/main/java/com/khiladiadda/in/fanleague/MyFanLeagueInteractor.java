package com.khiladiadda.in.fanleague;

import com.khiladiadda.in.network.model.response.CricScorce;
import com.khiladiadda.in.network.model.response.MatchResponse;
import com.khiladiadda.in.network.ApiManager;
import com.khiladiadda.in.network.ApiService;
import com.khiladiadda.in.network.CricBuzzApiManger;
import com.khiladiadda.in.network.CricSubscriberCallback;
import com.khiladiadda.in.network.IApiListener;
import com.khiladiadda.in.network.SubscriberCallback;
import com.khiladiadda.in.network.model.CricAPiListerner;

import rx.Subscription;

public class MyFanLeagueInteractor {

    public MyFanLeagueInteractor() { }

    public Subscription getMyFanLeague(IApiListener<MatchResponse> listener, boolean upcoming, boolean past, boolean live) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.getMyFanLeague(upcoming, past, live)).subscribe(new SubscriberCallback<>(listener));
    }

    public Subscription getlive(CricAPiListerner<CricScorce> listener, String apikey, int matchid) {
        CricBuzzApiManger manager = CricBuzzApiManger.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.getlivescore(apikey, matchid)).subscribe(new CricSubscriberCallback<>(listener));
    }

}