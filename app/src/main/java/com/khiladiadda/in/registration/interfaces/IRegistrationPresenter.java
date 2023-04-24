package com.khiladiadda.in.registration.interfaces;

import com.khiladiadda.in.base.interfaces.IBasePresenter;

public interface IRegistrationPresenter extends IBasePresenter {

    void validateData();

    void doRegister();
}
