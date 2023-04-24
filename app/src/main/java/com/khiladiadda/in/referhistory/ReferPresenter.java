package com.khiladiadda.in.referhistory;

import com.khiladiadda.in.network.IApiListener;
import com.khiladiadda.in.network.model.ApiError;
import com.khiladiadda.in.network.model.response.ReferResponse;
import com.khiladiadda.in.referhistory.interfaces.IReferPresenter;
import com.khiladiadda.in.referhistory.interfaces.IReferView;

import rx.Subscription;

public class ReferPresenter implements IReferPresenter {

    private IReferView mView;
    private ReferInteractor mInteractor;
    private Subscription mLikedSubscription;

    public ReferPresenter(IReferView view) {
        mView = view;
        mInteractor = new ReferInteractor();
    }

    @Override public void getRefer() {
        mLikedSubscription = mInteractor.getRefer(mLikedAPIListener);
    }

    private IApiListener<ReferResponse> mLikedAPIListener = new IApiListener<ReferResponse>() {
        @Override public void onSuccess(ReferResponse response) {
            mView.onReferComplete(response);
        }

        @Override public void onError(ApiError error) {
            mView.onReferFailure(error);
        }
    };

    @Override public void destroy() {
        if (mLikedSubscription != null && !mLikedSubscription.isUnsubscribed()) {
            mLikedSubscription.unsubscribe();
        }
    }

}