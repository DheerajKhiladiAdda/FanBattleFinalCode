package com.khiladiadda.in.login.interfaces;

import com.khiladiadda.in.base.interfaces.IBasePresenter;

public interface ILoginPresenter extends IBasePresenter {

    void validateData();

    void doLogin(String emailAddress);

    void doGmailLogin(String gmailId);

    void doFbLogin(String token);

    void getMasterData();

}