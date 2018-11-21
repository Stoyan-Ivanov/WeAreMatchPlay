package com.stoyaniviv.wearematchplay.model.matchesresponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Pivot {

    @SerializedName("match_id")
    @Expose
    private Integer matchId;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("team")
    @Expose
    private Integer team;
    @SerializedName("handicap")
    @Expose
    private Integer handicap;
    @SerializedName("stroke_count")
    @Expose
    private Integer strokeCount;
    @SerializedName("is_creator")
    @Expose
    private Integer isCreator;
    @SerializedName("scores")
    @Expose
    private List<Integer> scores = null;

    public Integer getMatchId() {
        return matchId;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getTeam() {
        return team;
    }

    public void setTeam(Integer team) {
        this.team = team;
    }

    public Integer getHandicap() {
        return handicap;
    }

    public void setHandicap(Integer handicap) {
        this.handicap = handicap;
    }

    public Integer getStrokeCount() {
        return strokeCount;
    }

    public void setStrokeCount(Integer strokeCount) {
        this.strokeCount = strokeCount;
    }

    public Integer getIsCreator() {
        return isCreator;
    }

    public void setIsCreator(Integer isCreator) {
        this.isCreator = isCreator;
    }

    public List<Integer> getScores() {
        return scores;
    }

    public void setScores(List<Integer> scores) {
        this.scores = scores;
    }
}
