package com.idejie.android.quiz.models;

public class Video {
    public String videoId;
    public String title;
    public String description;

    public transient VideoBinder binder = new VideoBinder(this);

    public Video(String videoId, String title, String description) {
        this.videoId = videoId;
        this.title = title;
        this.description = description;
    }
}
