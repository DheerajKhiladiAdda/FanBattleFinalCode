package com.khiladiadda.in.dialogs.interfaces;

import com.khiladiadda.in.network.model.response.hth.KaPlayerHTH;

import java.util.List;

public interface IOnCreateBattleListener {

    void onAddBattleListener(double amount, List<KaPlayerHTH> kaplayerList);

    void onCancelBattleListener();
}