package com.khiladiadda.in.help.interfaces;

import com.khiladiadda.in.network.model.response.FaqCategoryResponse;
import com.khiladiadda.in.network.model.response.HelpResponse;
import com.khiladiadda.in.network.model.ApiError;

public interface IHelpView {

    void onGetCategoryComplete(FaqCategoryResponse responseModel);

    void onGetCategoryFailure(ApiError error);

    void onHelpComplete(HelpResponse responseModel);

    void onHelpFailure(ApiError error);

}
