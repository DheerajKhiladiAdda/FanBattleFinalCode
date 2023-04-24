package com.khiladiadda.in.leaderboard.past;

import com.khiladiadda.in.network.model.response.SquadLeaderbordResponse;
import com.khiladiadda.in.network.ApiManager;
import com.khiladiadda.in.network.ApiService;
import com.khiladiadda.in.network.IApiListener;
import com.khiladiadda.in.network.SubscriberCallback;

import rx.Subscription;

public class PastLeaderboardInteractor {

    public Subscription getPastLeaderboard(IApiListener<SquadLeaderbordResponse> listener, String id, int page, int limit) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.getSquadDuoLeaderBoard(id, page, limit))
                .subscribe(new SubscriberCallback<SquadLeaderbordResponse>(listener));
    }

}