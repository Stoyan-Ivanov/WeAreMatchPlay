package com.stoyaniviv.wearematchplay.ui;

import android.annotation.SuppressLint;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.stoyaniviv.wearematchplay.Constants;
import com.stoyaniviv.wearematchplay.R;
import com.stoyaniviv.wearematchplay.adapter.MatchesAdapter;
import com.stoyaniviv.wearematchplay.model.followersresponse.Follower;
import com.stoyaniviv.wearematchplay.model.matchesresponse.Match;
import com.stoyaniviv.wearematchplay.utils.SpaceItemDecoration;
import com.stoyaniviv.wearematchplay.viewmodel.MatchesActivityViewModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MatchesActivity extends BaseActivity {
    @BindView(R.id.recycler_view_matches)
    RecyclerView recyclerView;

    private MatchesActivityViewModel viewModel;
    private MatchesAdapter adapter;

    public static Intent getIntent(Context context, String accessToken) {
        Intent intent = new Intent(context, MatchesActivity.class);
        intent.putExtra(Constants.EXTRA_ACCESS_TOKEN, accessToken);
        return intent;
    }

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matches);

        viewModel = ViewModelProviders.of(this).get(MatchesActivityViewModel.class);
        viewModel.setExtras(getIntent());
        getFollowersMatches();
    }

    @SuppressLint("CheckResult")
    private void getFollowersMatches() {
        viewModel.getFollowersMatches()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(throwable -> {
                    Log.d("SII", "getFollowersMatches: " + throwable.getMessage());
                })
                .subscribe(new Observer<List<Match>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<Match> matches) {
                        if(adapter == null) {
                            adapter = new MatchesAdapter(matches);
                            configureRecyclerView();
                        } else {
                            adapter.setMoreMatches(matches);
                        }
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("SII", "onError: " + e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void configureRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new SpaceItemDecoration(16, SpaceItemDecoration.HORIZONTAL));
        recyclerView.setAdapter(adapter);
    }
}
