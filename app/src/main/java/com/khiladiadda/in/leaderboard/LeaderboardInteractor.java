package com.khiladiadda.in.leaderboard;

import com.khiladiadda.in.network.model.response.AllLeaderBoardResponse;
import com.khiladiadda.in.network.model.response.LudoAddaMainResponse;
import com.khiladiadda.in.network.model.response.LudoLeaderboardResponse;
import com.khiladiadda.in.network.ApiManager;
import com.khiladiadda.in.network.ApiService;
import com.khiladiadda.in.network.IApiListener;
import com.khiladiadda.in.network.SubscriberCallback;
import com.khiladiadda.in.network.model.response.OverallLeadBoardResponse;
import com.khiladiadda.in.network.model.response.hth.LeaderBoardHthResponse;

import rx.Subscription;

public class LeaderboardInteractor {

    public Subscription getQuizAll(IApiListener<AllLeaderBoardResponse> listener, int page, int limit) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.getLeaderBoardAll(page, limit))
                .subscribe(new SubscriberCallback<>(listener));
    }

    public Subscription getQuizMonth(IApiListener<AllLeaderBoardResponse> listener, int page, int limit) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.getLeaderboardMonth(page, limit))
                .subscribe(new SubscriberCallback<>(listener));
    }

    public Subscription getGameAll(IApiListener<AllLeaderBoardResponse> listener, String id, int page, int limit) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.getGameLeaderBoardAll(id, page, limit))
                .subscribe(new SubscriberCallback<>(listener));
    }

    public Subscription getGameMonth(IApiListener<AllLeaderBoardResponse> listener, String id, int page, int limit) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.getGameLeaderBoardMonth(id, page, limit))
                .subscribe(new SubscriberCallback<>(listener));
    }

    public Subscription getGameById(IApiListener<AllLeaderBoardResponse> listener, String id, int page, int limit) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.getGameLeaderBoardById(id, page, limit))
                .subscribe(new SubscriberCallback<>(listener));
    }

    public Subscription getLudo(IApiListener<LudoLeaderboardResponse> listener, int page, int limit, String type, int gameType) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.getLudoLeaderBoard(page, limit, type, gameType))
                .subscribe(new SubscriberCallback<LudoLeaderboardResponse>(listener));
    }

    public Subscription getFanBattle(IApiListener<OverallLeadBoardResponse> listener, int type, int page, int limit) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.getOverAllLeaderboard(type, page, limit)).subscribe(new SubscriberCallback<>(listener));
    }

    public Subscription getHTHBattle(IApiListener<LeaderBoardHthResponse> listener, int page, int limit,String type) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.getOverHTHAllLeaderboard(page, limit,type)).subscribe(new SubscriberCallback<>(listener));
    }

    public Subscription getLudoAdda(IApiListener<LudoAddaMainResponse> listener, int page, int limit, String type) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.getOverLudoAddaAllLeaderboard(page, limit,type)).subscribe(new SubscriberCallback<>(listener));
    }

}