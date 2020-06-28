package com.example.maurigram.login.interactor;



import android.app.Activity;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Mauri
 */

public interface LoginInteractor {
    void signIn(String username, String password, Activity activity, FirebaseAuth firebaseAuth);
}
