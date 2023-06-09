package com.khiladiadda.in.scratchcard;

import com.khiladiadda.in.network.IApiListener;
import com.khiladiadda.in.network.model.ApiError;
import com.khiladiadda.in.network.model.BaseResponse;
import com.khiladiadda.in.network.model.response.ScratchCardResponse;
import com.khiladiadda.in.scratchcard.interfaces.IScratchPresenter;
import com.khiladiadda.in.scratchcard.interfaces.IScratchView;

import rx.Subscription;

public class ScratchPresenter implements IScratchPresenter {
    private IScratchView mView;
    private ScratchInteractor mInteractor;
    private Subscription mSubscription;

    public ScratchPresenter(IScratchView view) {
        mView = view;
        mInteractor = new ScratchInteractor();
    }

    @Override
    public void getScratchCard(int type) {
        mSubscription = mInteractor.getScratchCards(mScratchCardApiListener, type);

    }

    @Override
    public void applyScratchCard(String scartchid) {
        mSubscription = mInteractor.applyScratchCard(mScratchedCardApiListener, scartchid);
    }

    IApiListener<ScratchCardResponse> mScratchCardApiListener = new IApiListener<ScratchCardResponse>() {

        @Override
        public void onSuccess(ScratchCardResponse response) {
            mView.onScratchCardComplete(response);
        }

        @Override
        public void onError(ApiError error) {
            mView.onScratchCardFailure(error);
        }
    };
    IApiListener<BaseResponse> mScratchedCardApiListener = new IApiListener<BaseResponse>() {


        @Override
        public void onSuccess(BaseResponse response) {
            mView.onScratchedCardComplete(response);
        }

        @Override
        public void onError(ApiError error) {
            mView.onScratchedCardFailure(error);
        }
    };

    @Override
    public void destroy() {
        if (mSubscription != null && !mSubscription.isUnsubscribed()) {
            mSubscription.unsubscribe();
        }
    }
}
