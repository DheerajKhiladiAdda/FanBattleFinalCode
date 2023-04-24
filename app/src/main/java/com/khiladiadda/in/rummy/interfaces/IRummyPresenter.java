package com.khiladiadda.in.rummy.interfaces;
import com.khiladiadda.in.base.interfaces.IBasePresenter;
public interface IRummyPresenter extends IBasePresenter {

    void getRummyList(String arenaType);
    void getRummyRefreshToken();
    void getCheckGameStatus();
}