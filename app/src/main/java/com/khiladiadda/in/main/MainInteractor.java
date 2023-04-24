package com.khiladiadda.in.main;

import com.khiladiadda.in.network.ApiManager;
import com.khiladiadda.in.network.ApiService;
import com.khiladiadda.in.network.IApiListener;
import com.khiladiadda.in.network.SubscriberCallback;
import com.khiladiadda.in.network.model.BaseResponse;
import com.khiladiadda.in.network.model.request.UpdateFavouriteRequest;
import com.khiladiadda.in.network.model.response.DashboardResponse;

import rx.Subscription;

public class MainInteractor {

    public Subscription getTrending(IApiListener<DashboardResponse> listener) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.getDashboardData())
                .subscribe(new SubscriberCallback<>(listener));
    }

    public Subscription updateFavourite(IApiListener<BaseResponse> listener, UpdateFavouriteRequest request) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.updateFavourite(request))
                .subscribe(new SubscriberCallback<>(listener));
    }
}
