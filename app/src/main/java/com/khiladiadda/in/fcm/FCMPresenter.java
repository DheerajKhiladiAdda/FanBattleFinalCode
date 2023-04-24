package com.khiladiadda.in.fcm;

import com.khiladiadda.in.fcm.interfaces.IFCMPresenter;
import com.khiladiadda.in.fcm.interfaces.IFCMView;
import com.khiladiadda.in.network.IApiListener;
import com.khiladiadda.in.network.model.ApiError;
import com.khiladiadda.in.network.model.BaseResponse;
import com.khiladiadda.in.network.model.request.FcmRequest;

import rx.Subscription;

public class FCMPresenter implements IFCMPresenter {

    private IFCMView mView;
    private FCMInteractor mInteractor;
    private Subscription mAddSubscription;

    public FCMPresenter(IFCMView view) {
        mView = view;
        mInteractor = new FCMInteractor();
    }

    @Override
    public void updateLeague(boolean leagueDisabled) {
        FcmRequest request = new FcmRequest();
        request.setLeagueDisabled(leagueDisabled);
        mAddSubscription = mInteractor.updateLeague(mAddApiListener, request);
    }

    private IApiListener<BaseResponse> mAddApiListener = new IApiListener<BaseResponse>() {
        @Override
        public void onSuccess(BaseResponse response) {
            mView.onFcmUpdateComplete(response);
        }

        @Override
        public void onError(ApiError error) {
            mView.onFcmUpdateFailure(error);
        }
    };

    @Override
    public void destroy() {
        if (mAddSubscription != null && !mAddSubscription.isUnsubscribed()) {
            mAddSubscription.unsubscribe();
        }
    }

}