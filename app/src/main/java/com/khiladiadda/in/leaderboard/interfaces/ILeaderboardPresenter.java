package com.khiladiadda.in.leaderboard.interfaces;

import com.khiladiadda.in.base.interfaces.IBasePresenter;

public interface ILeaderboardPresenter extends IBasePresenter {

    void getQuizAll(int page, int limit);

    void getQuizMonth(int page, int limit);

    void getGameAll(String id, int page, int limit);

    void getGameMonth(String id, int page, int limit);

    void getGameById(String id, int page, int limit);

    void getLudo(int page, int limit, String type, int contestType);

    void getFanBattle(int page, int limit, int type);

    void getHTHBattles(int page, int limit, String type);

    void getLudoAdda(int page, int limit, String type);
}