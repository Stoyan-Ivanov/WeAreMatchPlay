package com.stoyaniviv.wearematchplay.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.stoyaniviv.wearematchplay.R;
import com.stoyaniviv.wearematchplay.model.matchesresponse.Match;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MatchesAdapter extends RecyclerView.Adapter<MatchesAdapter.MatchViewHolder> {

    private List<Match> matches;

    public MatchesAdapter(List<Match> matches) {
        this.matches = matches;
    }

    public void setMoreMatches(List<Match> newMatches) {
        matches.addAll(newMatches);
    }

    @NonNull
    @Override
    public MatchViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MatchViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_match, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MatchViewHolder matchViewHolder, int i) {
        matchViewHolder.bind(matches.get(i));
    }

    @Override
    public int getItemCount() {
        return matches.size();
    }

    public class MatchViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_match_id)
        TextView txtMatchId;
        @BindView(R.id.txt_winning_score)
        TextView txtWinningScore;
        @BindView(R.id.txt_played_at)
        TextView txtPlayedAt;

        public MatchViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(Match match) {
            txtMatchId.setText(itemView.getResources().getString(R.string.txt_match_id, match.getId()));
            txtWinningScore.setText(itemView.getResources().getString(R.string.txt_winning_score, match.getWinningScore()));
            txtPlayedAt.setText(itemView.getResources().getString(R.string.txt_played_at, match.getPlayedAt()));
        }
    }
}
