package com.khiladiadda.in.rummy;
import com.khiladiadda.in.network.ApiManager;
import com.khiladiadda.in.network.ApiService;
import com.khiladiadda.in.network.IApiListener;
import com.khiladiadda.in.network.SubscriberCallback;
import com.khiladiadda.in.network.model.response.RummyCheckGameResponse;
import com.khiladiadda.in.network.model.response.RummyHistoryMainResponse;
import com.khiladiadda.in.network.model.response.RummyRefreshTokenMainResponse;
import com.khiladiadda.in.network.model.response.RummyResponse;
import rx.Subscription;
public class RummyInteractor {
    Subscription getRummyList(IApiListener<RummyResponse> listener, String arenaType) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.getRummyList(arenaType, "20")).subscribe(new SubscriberCallback<>(listener));
    }

    Subscription getRummyRefreshToken(IApiListener<RummyRefreshTokenMainResponse> listener) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.getRummyRefershToken()).subscribe(new SubscriberCallback<>(listener));
    }

    Subscription getCheckGameStatus(IApiListener<RummyCheckGameResponse> listener) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.getRummyCheckGameStatus()).subscribe(new SubscriberCallback<>(listener));
    }

    Subscription getRummyHistory(IApiListener<RummyHistoryMainResponse> listener) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.getRummyHistory()).subscribe(new SubscriberCallback<>(listener));
    }

}