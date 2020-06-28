package com.example.maurigram.login.repository;

import android.content.Context;
import android.util.Log;

import com.google.gson.JsonObject;
import com.example.maurigram.api.adapter.MaurigramFirebaseAdapter;
import com.example.maurigram.api.services.MaurigramFirebaseService;
import com.example.maurigram.login.presenter.CreateAccountPresenter;
import com.example.maurigram.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Mauri.
 */

public class CreateAccountRepositoryImpl implements CreateAccountRepository {

    private static final String TAG = "CreateAccountRepository";
    private CreateAccountPresenter presenter;

    public CreateAccountRepositoryImpl(CreateAccountPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void createAccount(User user, Context context) {
        MaurigramFirebaseAdapter maurigramFirebaseAdapter = new MaurigramFirebaseAdapter();
        MaurigramFirebaseService maurigramFirebaseService = maurigramFirebaseAdapter.getFirebaseService(context);
        Call<JsonObject> call = maurigramFirebaseService.createUser(user);

        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                Log.w(TAG, "RESPONSE ~ " +  response);
                Log.w(TAG, "RESPONSE ~ " +  response.body());
                presenter.createAccountSuccess();
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                presenter.createAccountError(t.toString());
                Log.e(TAG, t.toString());
                t.printStackTrace();
            }
        });
    }
}