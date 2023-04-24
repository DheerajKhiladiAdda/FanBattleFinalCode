package com.khiladiadda.in.leaderboard.past.interfaces;

import com.khiladiadda.in.base.interfaces.IBasePresenter;

public interface IPastLeaderboardPresenter extends IBasePresenter {

    void getLeaderboard(String id, int page, int limit);

}