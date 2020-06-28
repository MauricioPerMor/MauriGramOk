package com.example.maurigram;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;

import com.facebook.FacebookSdk;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.crash.FirebaseCrash;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

/**
 * Created by Mauri */

public class MaurigramApplication extends Application {

    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;
    private FirebaseStorage firebaseStorage;
    private String TAG = "MaurigramApplication";

    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseCrash.log("Inicializando variables MaurigramApplication");

        FacebookSdk.sdkInitialize(getApplicationContext());

        firebaseAuth = FirebaseAuth.getInstance();
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                if (firebaseUser != null){
                    FirebaseCrash.logcat(Log.WARN, TAG, "Usuario logeado " + firebaseUser.getEmail());
                }else {
                    FirebaseCrash.logcat(Log.WARN, TAG, "Usuario No logeado ");
                }
            }
        };

        firebaseStorage = FirebaseStorage.getInstance();
    }


    public StorageReference getStorageReference(){
        return firebaseStorage.getReference();
    }
}


