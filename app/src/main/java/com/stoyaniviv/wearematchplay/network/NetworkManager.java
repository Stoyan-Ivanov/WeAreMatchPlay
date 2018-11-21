package com.stoyaniviv.wearematchplay.network;

import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.stoyaniviv.wearematchplay.Constants;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkManager {
    private static NetworkManager instance;
    private Retrofit retrofit;
    private WeAreMatchPlayAPI api;

    public static NetworkManager getInstance() {
        if(instance == null) {
            instance = new NetworkManager();
        }
        return instance;
    }

    private Retrofit getRetrofitInstance() {
        if(retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .baseUrl(Constants.BASE_URL)
                    .build();
        }
        return retrofit;
    }

    public WeAreMatchPlayAPI getApi() {
        if(api == null) {
            api = getRetrofitInstance().create(WeAreMatchPlayAPI.class);
        }
        return api;
    }
}
