package com.stoyaniviv.wearematchplay.viewmodel;

import android.annotation.SuppressLint;
import android.arch.lifecycle.ViewModel;
import android.content.Intent;
import android.util.Log;

import com.stoyaniviv.wearematchplay.Constants;
import com.stoyaniviv.wearematchplay.model.followersresponse.Follower;
import com.stoyaniviv.wearematchplay.model.matchesresponse.Match;
import com.stoyaniviv.wearematchplay.model.matchesresponse.MatchesResponse;
import com.stoyaniviv.wearematchplay.network.NetworkManager;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class MatchesActivityViewModel extends ViewModel {
    private String accessToken;

    public void setExtras(Intent intent) {
        if(intent.getExtras() != null) {
            accessToken =  Constants.AUTHORIZATION + intent.getStringExtra(Constants.EXTRA_ACCESS_TOKEN);
        }
    }

    @SuppressLint("CheckResult")
    private Observable<ArrayList<Follower>> getCurrentUserFollowers() {
        return NetworkManager.getInstance()
                .getApi()
                .getFollowersForUser(accessToken, "me");
    }

    @SuppressLint("CheckResult")
    public Observable<List<Match>> getFollowersMatches() {
        return getCurrentUserFollowers()
                .flatMapIterable(followers -> followers)
                .flatMap(follower -> NetworkManager.getInstance().getApi()
                        .getMatchesForUser(accessToken, String.valueOf(follower.getId())))
                .map(MatchesResponse::getMatches);
    }
}
