package com.khiladiadda.in.leaderboard;

import com.khiladiadda.in.leaderboard.interfaces.ILeaderboardPresenter;
import com.khiladiadda.in.leaderboard.interfaces.ILeaderboardView;
import com.khiladiadda.in.network.model.response.AllLeaderBoardResponse;
import com.khiladiadda.in.network.model.response.LudoAddaMainResponse;
import com.khiladiadda.in.network.model.response.LudoLeaderboardResponse;
import com.khiladiadda.in.network.IApiListener;
import com.khiladiadda.in.network.model.ApiError;
import com.khiladiadda.in.network.model.response.OverallLeadBoardResponse;
import com.khiladiadda.in.network.model.response.hth.LeaderBoardHthResponse;

import rx.Subscription;

public class LeaderboardPresenter implements ILeaderboardPresenter {

    private ILeaderboardView mView;
    private LeaderboardInteractor mInteractor;
    private Subscription mSubscription;

    public LeaderboardPresenter(ILeaderboardView view) {
        mView = view;
        mInteractor = new LeaderboardInteractor();
    }

    @Override
    public void getQuizAll(int page, int limit) {
        mSubscription = mInteractor.getQuizAll(mAllApiListener, page, limit);
    }

    @Override
    public void getQuizMonth(int page, int limit) {
        mSubscription = mInteractor.getQuizMonth(mAllApiListener, page, limit);
    }

    @Override
    public void getGameAll(String id, int page, int limit) {
        mSubscription = mInteractor.getGameAll(mAllApiListener, id, page, limit);
    }

    @Override
    public void getGameMonth(String id, int page, int limit) {
        mSubscription = mInteractor.getGameMonth(mAllApiListener, id, page, limit);
    }

    @Override
    public void getGameById(String id, int page, int limit) {
        mSubscription = mInteractor.getGameById(mAllApiListener, id, page, limit);
    }

    @Override
    public void getLudo(int page, int limit, String type, int contestType) {
        mSubscription = mInteractor.getLudo(mLudoApiListener, page, limit, type, contestType);
    }

    @Override
    public void getFanBattle(int page, int limit, int type) {
        mSubscription = mInteractor.getFanBattle(mFanBattleListener, type, page, limit);
    }

    @Override
    public void getHTHBattles(int page, int limit, String type) {
        mSubscription = mInteractor.getHTHBattle(mHTHApiListener, page, limit, type);
    }

    @Override
    public void getLudoAdda(int page, int limit, String type) {
        mSubscription = mInteractor.getLudoAdda(mLudoAddaListerner, page, limit, type);
    }

    private IApiListener<LudoAddaMainResponse> mLudoAddaListerner = new IApiListener<LudoAddaMainResponse>() {
        @Override
        public void onSuccess(LudoAddaMainResponse response) {
            mView.onLeaderLudoAddaComplete(response);
        }

        @Override
        public void onError(ApiError error) {
            mView.onLeaderLudoAdda(error);
        }
    };

    private IApiListener<LeaderBoardHthResponse> mHTHApiListener = new IApiListener<LeaderBoardHthResponse>() {
        @Override
        public void onSuccess(LeaderBoardHthResponse response) {
            mView.onLeaderHTHBattleComplete(response);
        }

        @Override
        public void onError(ApiError error) {
            mView.onLeaderHTHBattleFailure(error);
        }
    };

    private IApiListener<LudoLeaderboardResponse> mLudoApiListener = new IApiListener<LudoLeaderboardResponse>() {
        @Override
        public void onSuccess(LudoLeaderboardResponse response) {
            mView.onLudoLeaderBoardComplete(response);
        }

        @Override
        public void onError(ApiError error) {
            mView.onLudoLeaderBoardFailure(error);
        }
    };

    private IApiListener<OverallLeadBoardResponse> mFanBattleListener = new IApiListener<OverallLeadBoardResponse>() {
        @Override
        public void onSuccess(OverallLeadBoardResponse response) {
            mView.onLeaderFanBattleComplete(response);
        }

        @Override
        public void onError(ApiError error) {
            mView.onLeaderFanBattleFailure(error);

        }
    };

    private IApiListener<AllLeaderBoardResponse> mAllApiListener = new IApiListener<AllLeaderBoardResponse>() {
        @Override
        public void onSuccess(AllLeaderBoardResponse response) {
            mView.onLeaderBoardComplete(response);
        }

        @Override
        public void onError(ApiError error) {
            mView.onLeaderBoardFailure(error);
        }
    };

    @Override
    public void destroy() {
        if (mSubscription != null && !mSubscription.isUnsubscribed()) {
            mSubscription.unsubscribe();
        }
    }

}