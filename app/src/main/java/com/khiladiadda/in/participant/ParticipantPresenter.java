package com.khiladiadda.in.participant;

import com.khiladiadda.in.network.IApiListener;
import com.khiladiadda.in.network.model.ApiError;
import com.khiladiadda.in.network.model.request.FBBattleParticipantRequest;
import com.khiladiadda.in.network.model.response.FBParticipantResponse;
import com.khiladiadda.in.network.model.response.ParticipantResponse;
import com.khiladiadda.in.network.model.response.QuizParticipantResponse;
import com.khiladiadda.in.network.model.response.TeamResponse;
import com.khiladiadda.in.participant.interfaces.IParticipantPresenter;
import com.khiladiadda.in.participant.interfaces.IParticipantView;

import rx.Subscription;

public class ParticipantPresenter implements IParticipantPresenter {

    private IParticipantView mView;
    private ParticipantInteractor mInteractor;
    private Subscription mSubscription;

    public ParticipantPresenter(IParticipantView view) {
        mView = view;
        mInteractor = new ParticipantInteractor();
    }






    @Override
    public void getFBGroupParticipant(String groupId, int page, int limit,boolean isLeaderboard) {
        FBBattleParticipantRequest request = new FBBattleParticipantRequest();
        request.setBattleId("");
        request.setMatchid("");
        request.setGroupId(groupId);
        request.setIsleaderboard(false);
        mSubscription = mInteractor.getFBGroupParticipant(request, page, limit,isLeaderboard, mGetFBGroupApiListener);
    }

    private IApiListener<FBParticipantResponse> mGetFBGroupApiListener = new IApiListener<FBParticipantResponse>() {
        @Override
        public void onSuccess(FBParticipantResponse response) {
            mView.onFBGroupParticipantComplete(response);
        }

        @Override
        public void onError(ApiError error) {
            mView.onFBGroupParticipantFailure(error);
        }
    };

    @Override
    public void getFBBattleParticipant(String battleId, int page, int limit) {
        FBBattleParticipantRequest request = new FBBattleParticipantRequest();
        request.setBattleId(battleId);
        request.setGroupId("");
        request.setMatchid("");
        request.setIsleaderboard(false);
        mSubscription = mInteractor.getFBBattleParticipant(request, page, limit, mGetFBBattleApiListener);
    }

    @Override
    public void getFBMatchParticipant(String matchId, int page, int limit) {
        FBBattleParticipantRequest request = new FBBattleParticipantRequest();
        request.setMatchid(matchId);
        request.setGroupId("");
        request.setBattleId("");
        request.setIsleaderboard(false);
        mSubscription = mInteractor.getFBMatchParticipant(request, page, limit, mGetFBMatchApiListener);
    }

    private IApiListener<FBParticipantResponse> mGetFBBattleApiListener = new IApiListener<FBParticipantResponse>() {
        @Override
        public void onSuccess(FBParticipantResponse response) {
            mView.onFBBattleParticipantComplete(response);
        }

        @Override
        public void onError(ApiError error) {
            mView.onFBBattleParticipantFailure(error);
        }
    };
    private IApiListener<FBParticipantResponse> mGetFBMatchApiListener = new IApiListener<FBParticipantResponse>() {
        @Override
        public void onSuccess(FBParticipantResponse response) {
            mView.onFBMatchParticipantComplete(response);
        }

        @Override
        public void onError(ApiError error) {
            mView.onFBMatchParticipantFailure(error);
        }
    };

    @Override
    public void destroy() {
        if (mSubscription != null && !mSubscription.isUnsubscribed()) {
            mSubscription.unsubscribe();
        }
    }


}