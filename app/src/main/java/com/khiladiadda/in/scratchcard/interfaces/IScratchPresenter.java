package com.khiladiadda.in.scratchcard.interfaces;

import com.khiladiadda.in.base.interfaces.IBasePresenter;

public interface IScratchPresenter extends IBasePresenter {
    void getScratchCard(int type);

    void applyScratchCard(String scartchid);
}
