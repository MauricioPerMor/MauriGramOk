package com.example.maurigram.login.presenter;

import android.content.Context;

import com.example.maurigram.login.interactor.CreateAccountInteractor;
import com.example.maurigram.login.interactor.CreateAccountInteractorImpl;
import com.example.maurigram.login.view.CreateAccountView;
import com.example.maurigram.login.view.LoginView;
import com.example.maurigram.model.User;

/**
 * Created by anahisalgado on 13/07/17.
 */

public class CreateAccountPresenterImpl implements CreateAccountPresenter {

    private CreateAccountView createAccountView;
    private CreateAccountInteractor interactor;

    public CreateAccountPresenterImpl(CreateAccountView createAccountView) {
        this.createAccountView = createAccountView;
        interactor = new CreateAccountInteractorImpl(this);
    }

    @Override
    public void createAccount(User user, Context context) {
        createAccountView.showProgressBar();
        interactor.createAccount(user, context);
    }

    @Override
    public void createAccountSuccess() {
        createAccountView.goHome();
        createAccountView.hideProgressBar();
    }

    @Override
    public void createAccountError(String error) {
        createAccountView.createAccountError(error);
    }
}