package com.example.maurigram.login.presenter;

import android.app.Activity;
import android.content.Context;

import com.google.firebase.auth.FirebaseAuth;
import com.example.maurigram.model.User;

/**
 * Created by Mauri 3/2020
 */

public interface CreateAccountPresenter {

    void createAccount(User user, Context context); // Interactor
    void createAccountSuccess();
    void createAccountError(String error);
}