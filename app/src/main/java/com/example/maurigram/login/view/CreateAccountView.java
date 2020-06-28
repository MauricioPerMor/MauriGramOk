package com.example.maurigram.login.view;

/**
 * Created by Mauri on 13/03/20
 * .
 */

public interface CreateAccountView {

    void showProgressBar();
    void hideProgressBar();

    void createAccountError(String error);

    void goHome();
}