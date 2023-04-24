package com.khiladiadda.in.participant.interfaces;


import com.khiladiadda.in.network.model.ApiError;
import com.khiladiadda.in.network.model.response.FBParticipantResponse;

public interface IParticipantView {

    void onFBGroupParticipantComplete(FBParticipantResponse responseModel);

    void onFBGroupParticipantFailure(ApiError error);

    void onFBBattleParticipantComplete(FBParticipantResponse responseModel);

    void onFBBattleParticipantFailure(ApiError error);

    void onFBMatchParticipantComplete(FBParticipantResponse responseModel);

    void onFBMatchParticipantFailure(ApiError error);
}
