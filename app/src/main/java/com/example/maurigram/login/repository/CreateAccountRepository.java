package com.example.maurigram.login.repository;

import android.content.Context;

import com.example.maurigram.model.User;

/**
 * Created by Mauri 2020.
 */

public interface CreateAccountRepository {
    void createAccount(User user, Context context); // Interactor
}