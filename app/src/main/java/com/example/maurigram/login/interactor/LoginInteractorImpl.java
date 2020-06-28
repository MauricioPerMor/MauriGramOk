package com.example.maurigram.login.interactor;

import android.app.Activity;

import com.google.firebase.auth.FirebaseAuth;
import com.example.maurigram.login.presenter.LoginPresenter;
import com.example.maurigram.login.repository.LoginRepository;
import com.example.maurigram.login.repository.LoginRepositoryImpl;

/**
 * Created by Mauri
 */

public class LoginInteractorImpl  implements LoginInteractor{

    private LoginPresenter presenter;
    private LoginRepository repository;

    public LoginInteractorImpl(LoginPresenter presenter) {
        this.presenter = presenter;
        repository = new LoginRepositoryImpl(presenter);
    }

    @Override
    public void signIn(String username, String password, Activity activity, FirebaseAuth firebaseAuth) {
        repository.signIn(username, password, activity, firebaseAuth);
    }
}
