package com.khiladiadda.in.headtohead.createbattle.interfaces;

import com.khiladiadda.in.network.model.ApiError;
import com.khiladiadda.in.network.model.BaseResponse;
import com.khiladiadda.in.network.model.response.hth.BattleResponseHTH;
import com.khiladiadda.in.network.model.response.hth.CreateBattleResponse;
import com.khiladiadda.in.network.model.response.hth.HTHMainResponse;

public interface ICreateBattleView {

    void onJoinComplete(CreateBattleResponse responseModel);

    void onJoinFailure(ApiError error);

    void onUpdateComplete(BaseResponse responseModel);

    void onUpdateFailure(ApiError error);

    void onAcceptComplete(CreateBattleResponse responseModel);

    void onAcceptFailure(ApiError error);

    void onAllBattlesComplete(BattleResponseHTH responseModel);

    void onAllBattlesFailure(ApiError error);

    void onMyBattlesComplete(BattleResponseHTH responseModel);

    void onMyBattlesFailure(ApiError error);

    void onFetchLegues(HTHMainResponse responseModel);

    void onFetchLegues(ApiError error);

    void onUpdatePLayers(BaseResponse response);

    void onUpdatePLayerError(ApiError error);

    void onPlayerStatus(HTHMainResponse responseModel);

    void onPlayerStatusError(ApiError error);

}