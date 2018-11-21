package com.stoyaniviv.wearematchplay;

import android.app.Application;
import android.content.Context;

public class App extends Application {
    private static App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance  = this;
    }

    public static App getInstance() {
        if(instance == null) {
            instance = new App();
        }
        return instance;
    }
}
