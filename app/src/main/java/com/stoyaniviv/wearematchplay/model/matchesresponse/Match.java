package com.stoyaniviv.wearematchplay.model.matchesresponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Match {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("course_id")
    @Expose
    private Integer courseId;
    @SerializedName("show_course")
    @Expose
    private Boolean showCourse;
    @SerializedName("type")
    @Expose
    private Integer type;
    @SerializedName("winning_score")
    @Expose
    private Integer winningScore;
    @SerializedName("holes_not_played")
    @Expose
    private Integer holesNotPlayed;
    @SerializedName("winning_team")
    @Expose
    private Integer winningTeam;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("played_at")
    @Expose
    private Object playedAt;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("deleted_at")
    @Expose
    private Object deletedAt;
    @SerializedName("verified_at")
    @Expose
    private Object verifiedAt;
    @SerializedName("liked")
    @Expose
    private Boolean liked;
    @SerializedName("like_count")
    @Expose
    private Integer likeCount;
    @SerializedName("comment_count")
    @Expose
    private Integer commentCount;
    @SerializedName("users")
    @Expose
    private List<User> users = null;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Boolean getShowCourse() {
        return showCourse;
    }

    public void setShowCourse(Boolean showCourse) {
        this.showCourse = showCourse;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getWinningScore() {
        return winningScore;
    }

    public void setWinningScore(Integer winningScore) {
        this.winningScore = winningScore;
    }

    public Integer getHolesNotPlayed() {
        return holesNotPlayed;
    }

    public void setHolesNotPlayed(Integer holesNotPlayed) {
        this.holesNotPlayed = holesNotPlayed;
    }

    public Integer getWinningTeam() {
        return winningTeam;
    }

    public void setWinningTeam(Integer winningTeam) {
        this.winningTeam = winningTeam;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getPlayedAt() {
        return playedAt;
    }

    public void setPlayedAt(Object playedAt) {
        this.playedAt = playedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Object getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Object deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Object getVerifiedAt() {
        return verifiedAt;
    }

    public void setVerifiedAt(Object verifiedAt) {
        this.verifiedAt = verifiedAt;
    }

    public Boolean getLiked() {
        return liked;
    }

    public void setLiked(Boolean liked) {
        this.liked = liked;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}