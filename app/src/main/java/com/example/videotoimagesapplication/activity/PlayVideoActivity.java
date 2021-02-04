package com.example.videotoimagesapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.videotoimagesapplication.R;
import com.example.videotoimagesapplication.adapter.MainViewPagerAdapter;
import com.example.videotoimagesapplication.fragment.QuickCaptureFragment;
import com.example.videotoimagesapplication.fragment.TimeCaptureFragment;

public class PlayVideoActivity extends AppCompatActivity {
    static VideoView videoView;
    static ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        videoView = findViewById(R.id.videoView);
        viewPager = findViewById(R.id.viewPagerPlayVideo);
        init();
        MediaController mediaController = new MediaController(this);
        Intent intent = getIntent();
        Uri uri = Uri.parse(intent.getStringExtra("uriVideo"));
        playVideo(uri, mediaController);
    }
    private static void playVideo(Uri uri, MediaController mediaController){
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
        videoView.start();
    }
    private void init(){
        MainViewPagerAdapter main = new MainViewPagerAdapter(getSupportFragmentManager(),1);
        main.addFragment(new QuickCaptureFragment(), "QUICK CAPTURE");
        main.addFragment(new TimeCaptureFragment(), "TIME CAPTURE");
        viewPager.setAdapter(main);

    }
}