package com.example.videotoimagesapplication.model;

import android.net.Uri;

import java.io.Serializable;

public class VideoModel  implements Serializable {
    String videoTitle;
    String videoDuration;
    Uri videoUri;
    
    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

     public String getVideoDuration() {
        return videoDuration;
    }

    public void setVideoDuration(String videoDuration) {
        this.videoDuration = videoDuration;
    }
    
    public Uri getVideoUri() {
        return videoUri;
    }

    public void setVideoUri(Uri videoUri) {
        this.videoUri = videoUri;
    }

    @Override
    public String toString() {
        return "VideoModel{" +
                "videoTitle='" + videoTitle + '\'' +
                ", videoDuration='" + videoDuration + '\'' +
                ", videoUri=" + videoUri +
                '}';
    }
}