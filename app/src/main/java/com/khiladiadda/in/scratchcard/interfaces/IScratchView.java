package com.khiladiadda.in.scratchcard.interfaces;

import com.khiladiadda.in.network.model.ApiError;
import com.khiladiadda.in.network.model.BaseResponse;
import com.khiladiadda.in.network.model.response.ScratchCardResponse;

public interface IScratchView {
    void onScratchCardComplete(ScratchCardResponse responseModel);

    void onScratchCardFailure(ApiError error);

    void onScratchedCardComplete(BaseResponse responseModel);

    void onScratchedCardFailure(ApiError error);
}
