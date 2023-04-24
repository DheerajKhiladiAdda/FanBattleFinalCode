package com.khiladiadda.in.registration;

import com.khiladiadda.in.network.ApiManager;
import com.khiladiadda.in.network.ApiService;
import com.khiladiadda.in.network.IApiListener;
import com.khiladiadda.in.network.SubscriberCallback;
import com.khiladiadda.in.network.model.BaseResponse;
import com.khiladiadda.in.network.model.request.RegistrationRequest;

import rx.Subscription;

public class RegistrationInteractor {

    public Subscription doRegister(RegistrationRequest request, IApiListener<BaseResponse> listener) {
        ApiManager manager = ApiManager.getInstance();
        ApiService service = manager.createService();
        return manager.createObservable(service.register(request)).subscribe(new SubscriberCallback<>(listener));
    }

}