package com.example.videotoimagesapplication.model;

import android.graphics.Bitmap;
import android.net.Uri;

import java.io.Serializable;

public class VideoModel  implements Serializable {
    String videoTitle;
    String videoDuration;
    Uri videoUri;
    Bitmap img;
    
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

    public Bitmap getImg() {
        return img;
    }

    public void setImg(Bitmap img) {
        this.img = img;
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