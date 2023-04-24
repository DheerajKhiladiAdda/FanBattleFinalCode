package com.khiladiadda.in.help;

import com.khiladiadda.in.help.interfaces.IHelpPresenter;
import com.khiladiadda.in.help.interfaces.IHelpView;
import com.khiladiadda.in.network.model.response.FaqCategoryResponse;
import com.khiladiadda.in.network.model.response.HelpResponse;
import com.khiladiadda.in.network.IApiListener;
import com.khiladiadda.in.network.model.ApiError;

import rx.Subscription;

public class HelpPresenter implements IHelpPresenter {

    private IHelpView mView;
    private HelpInteractor mInteractor;
    private Subscription mLoginSubscription;

    public HelpPresenter(IHelpView view) {
        mView = view;
        mInteractor = new HelpInteractor();
    }

    @Override
    public void getFaqCategory() {
        mLoginSubscription  =mInteractor.getCategory(mGetApiListener);
    }

    private IApiListener<FaqCategoryResponse> mGetApiListener = new IApiListener<FaqCategoryResponse>() {
        @Override
        public void onSuccess(FaqCategoryResponse response) { mView.onGetCategoryComplete(response); }

        @Override
        public void onError(ApiError error) { mView.onGetCategoryFailure(error); }
    };

    @Override
    public void getHelpList(String id) {
        mLoginSubscription = mInteractor.getHelp(mLoginApiListener, id);
    }

    private IApiListener<HelpResponse> mLoginApiListener = new IApiListener<HelpResponse>() {
        @Override
        public void onSuccess(HelpResponse response) {
            mView.onHelpComplete(response);
        }

        @Override
        public void onError(ApiError error) {
            mView.onHelpFailure(error);
        }
    };

    @Override
    public void destroy() {
        if (mLoginSubscription != null && !mLoginSubscription.isUnsubscribed()) {
            mLoginSubscription.unsubscribe();
        }
    }

}