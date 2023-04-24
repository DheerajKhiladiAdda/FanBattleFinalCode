package com.khiladiadda.in.battle.interfaces;

import com.khiladiadda.in.base.interfaces.IBasePresenter;
import com.khiladiadda.in.battle.model.JoinGroupRequest;
import com.khiladiadda.in.battle.model.JoinGroupSubstituteRequest;

public interface IBattlePresenter extends IBasePresenter {

    void getBattleList(String id, boolean isPlayed, boolean live, boolean past);

    void getGroupList(String id, boolean is_reverse,boolean profile);

    void joinBattleGroup(JoinGroupRequest request, String id);

    void getCalculationBanner();

    void cancelGroup(String groupId);

    void joinGroupForSubstitute(JoinGroupSubstituteRequest request);
}