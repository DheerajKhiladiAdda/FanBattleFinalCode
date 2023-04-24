package com.khiladiadda.in.participant.interfaces;


import com.khiladiadda.in.base.interfaces.IBasePresenter;

public interface IParticipantPresenter extends IBasePresenter {



    void getFBGroupParticipant(String groupId, int page, int limit, boolean isLeaderboard);

    void getFBBattleParticipant(String battleId, int page, int limit);

    void getFBMatchParticipant(String matchId, int page, int limit);

}