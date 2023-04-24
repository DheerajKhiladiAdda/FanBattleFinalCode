package com.khiladiadda.in.headtohead.createbattle.interfaces;

import com.khiladiadda.in.base.interfaces.IBasePresenter;
import com.khiladiadda.in.network.model.request.hth.CreateBattleRequest;
import com.khiladiadda.in.network.model.request.hth.UpdateOpponentPlayers;

public interface ICreateBattlePresenter extends IBasePresenter {

    void createBattle(CreateBattleRequest request);

    void updateBattleGroup(CreateBattleRequest request, String groupId);

    void acceptBattleGroup(CreateBattleRequest request);

    void getMyBattles(String matchId, String battleId, boolean user, boolean highestBattle, boolean lowestBattle, boolean newestBattle);

    void getALLBattles(String matchId, String battleId, boolean user, boolean highestBattle, boolean lowestBattle, boolean newestBattle);

    void getLeguesBattles(boolean upcoming, boolean past, boolean live);

    void updateOpponentPlayer(String id, UpdateOpponentPlayers request);

    void getPlayerStatus(String id, UpdateOpponentPlayers players);
}