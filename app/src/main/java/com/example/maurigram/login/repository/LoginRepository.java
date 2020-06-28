package com.example.maurigram.login.repository;

import android.app.Activity;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Mauri on 3/2020.
 */

public interface LoginRepository {
    void signIn(String username, String password, Activity activity, FirebaseAuth firebaseAuth);
}
