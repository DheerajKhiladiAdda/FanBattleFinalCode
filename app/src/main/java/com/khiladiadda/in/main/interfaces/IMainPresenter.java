package com.khiladiadda.in.main.interfaces;

import com.khiladiadda.in.base.interfaces.IBasePresenter;
import com.khiladiadda.in.network.model.request.UpdateFavouriteRequest;

public interface IMainPresenter extends IBasePresenter {

    void getData();

    void updateFavourite(UpdateFavouriteRequest request);

}