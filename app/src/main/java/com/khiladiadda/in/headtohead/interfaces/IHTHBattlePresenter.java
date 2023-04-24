package com.khiladiadda.in.headtohead.interfaces;

import com.khiladiadda.in.base.interfaces.IBasePresenter;

public interface IHTHBattlePresenter extends IBasePresenter {

    void getHTHMatchList(String id);

    void onCancelBattle(String id);

    void getBattleResult(String id);

    void getMatchStatus(String id);

}