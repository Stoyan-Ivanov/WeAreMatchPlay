package com.stoyaniviv.wearematchplay.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.stoyaniviv.wearematchplay.model.LoginDetails;
import com.stoyaniviv.wearematchplay.model.loginresponse.LoginResponse;
import com.stoyaniviv.wearematchplay.network.NetworkManager;

import io.reactivex.MaybeObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class LoginActivityViewModel extends ViewModel {
    private MutableLiveData<String> accessToken = new MutableLiveData<>();

    public void loginUser(LoginDetails loginDetails) {
        NetworkManager.getInstance()
                .getApi()
                .login(loginDetails)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new MaybeObserver<LoginResponse>() {
            @Override
            public void onSubscribe(Disposable d) {
                // Not used;
            }

            @Override
            public void onSuccess(LoginResponse loginResponse) {
                accessToken.postValue(loginResponse.getApi_token());
            }

            @Override
            public void onError(Throwable e) {
                Log.d("WAMP", "onError: " + e.getMessage());
            }

            @Override
            public void onComplete() {
                // Not used
            }
        });
    }

    public LiveData<String> getAccessToken() {
        return accessToken;
    }
}
