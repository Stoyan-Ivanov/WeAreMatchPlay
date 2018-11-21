package com.stoyaniviv.wearematchplay.network;

import com.stoyaniviv.wearematchplay.model.followersresponse.Follower;
import com.stoyaniviv.wearematchplay.model.loginresponse.LoginResponse;
import com.stoyaniviv.wearematchplay.model.LoginDetails;
import com.stoyaniviv.wearematchplay.model.matchesresponse.MatchesResponse;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Maybe;
import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface WeAreMatchPlayAPI {
    @Headers({"Content-Type: application/json",
            "Accept: application/json"})
    @POST("auth/login")
    Maybe<LoginResponse> login(@Body LoginDetails loginDetails);

    @Headers({"Content-Type: application/json",
            "Accept: application/json"})
    @GET("users/{user}/followers")
    Observable<ArrayList<Follower>> getFollowersForUser(@Header("Authorization") String accessToken,
                                                        @Path("user") String userId);
    @Headers({"Content-Type: application/json",
            "Accept: application/json"})
    @GET("users/{user}/matches")
    Observable<MatchesResponse> getMatchesForUser(@Header("Authorization") String accessToken,
                                                  @Path("user") String userId);
}
