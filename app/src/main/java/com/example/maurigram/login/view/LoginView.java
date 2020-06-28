package com.example.maurigram.login.view;

/**
 * Created by Mauri 2020.
 */

public interface LoginView {

    void enableInputs();
    void disableInputs();

    void showProgressBar();
    void hideProgressBar();

    void loginError(String error);

    void goCreateAccount();
    void goHome();

}