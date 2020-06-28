package com.example.maurigram.login.interactor;

import android.content.Context;

import com.example.maurigram.login.presenter.CreateAccountPresenter;
import com.example.maurigram.login.repository.CreateAccountRepository;
import com.example.maurigram.login.repository.CreateAccountRepositoryImpl;
import com.example.maurigram.model.User;


public class CreateAccountInteractorImpl implements CreateAccountInteractor{

    private CreateAccountPresenter presenter;
    private CreateAccountRepository repository;

    public CreateAccountInteractorImpl(CreateAccountPresenter presenter) {
        this.presenter = presenter;
        repository = new CreateAccountRepositoryImpl(presenter);
    }


    @Override
    public void createAccount(User user, Context context) {
        repository.createAccount(user, context);
    }
}