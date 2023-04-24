package com.khiladiadda.in.battle.interfaces;

import com.khiladiadda.in.battle.model.BannerResponse;
import com.khiladiadda.in.battle.model.BattleGroupResponse;
import com.khiladiadda.in.battle.model.BattleResponse;
import com.khiladiadda.in.network.model.ApiError;
import com.khiladiadda.in.network.model.BaseResponse;

public interface IBattleView {

    void onGetBattleListComplete(BattleResponse responseModel);

    void onGetBattleListFailure(ApiError error);

    void onGetGroupListComplete(BattleGroupResponse responseModel);

    void onGetGroupListFailure(ApiError error);

    void onJoinComplete(BaseResponse responseModel);

    void onJoinFailure(ApiError error);

    void onGetCalculationBannerComplete(BannerResponse responseModel);

    void onGetCalculationBannerFailure(ApiError error);

    void onCancelComplete(BaseResponse responseModel);

    void onCancelFailure(ApiError error);

    void onJoinSubstituteComplete(BaseResponse responseModel);

    void onJoinSubstituteFailure(ApiError error);

}