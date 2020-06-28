package com.example.maurigram.login.presenter;

import android.app.Activity;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Mauri 2020
 *
 */

public interface LoginPresenter {
    void signIn(String username, String password, Activity activity, FirebaseAuth firebaseAuth); // Interactor
    void loginSuccess();
    void loginError(String error);


}