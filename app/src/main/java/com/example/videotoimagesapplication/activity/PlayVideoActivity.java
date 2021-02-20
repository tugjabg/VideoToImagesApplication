package com.example.videotoimagesapplication.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.videotoimagesapplication.R;
import com.example.videotoimagesapplication.adapter.MainViewPagerAdapter;
import com.example.videotoimagesapplication.fragment.QuickCaptureFragment;
import com.example.videotoimagesapplication.fragment.TimeCaptureFragment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import wseemann.media.FFmpegMediaMetadataRetriever;

public class PlayVideoActivity extends AppCompatActivity {
    public static String format = "JPG";
    public static String quanlity = "High";
    public static String size = "1x";
    File rootPath;
    FFmpegMediaMetadataRetriever myMediaMetadataRetriever;
    static VideoView videoView;
    static ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        rootPath = new File(Environment.getExternalStorageDirectory() + "/" + Environment.DIRECTORY_DOWNLOADS, "Video To Photo");
        if(!rootPath.exists()) {
            rootPath.mkdirs();
        }
        videoView = findViewById(R.id.videoView);
        setTitle("Video to photo");
//        viewPager = findViewById(R.id.viewPagerPlayVideo);
        //init();
        MediaController mediaController = new MediaController(this);
        Intent intent = getIntent();
        Uri uri = Uri.parse(intent.getStringExtra("uriVideo"));
//        Uri uri = Uri.parse("https://sites.google.com/site/androidexample9/download/RunningClock.mp4");
        myMediaMetadataRetriever = new FFmpegMediaMetadataRetriever();
        myMediaMetadataRetriever.setDataSource(String.valueOf(uri), new HashMap<String, String>());
//        myMediaMetadataRetriever = new MediaMetadataRetriever();
//        myMediaMetadataRetriever.setDataSource(String.valueOf(uri), new HashMap<String, String>());
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.button_header, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_camera:
                int cur = videoView.getCurrentPosition();// số giây
                Bitmap bitmap;
                int pos = cur*1000;
                bitmap = myMediaMetadataRetriever.getFrameAtTime(pos);
                try {
                    saveToExternal(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.action_done:
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return false;
    }

    private void saveToExternal(Bitmap bitmap) throws IOException {
        String path = Environment.getExternalStorageDirectory() + "/" + Environment.DIRECTORY_DOWNLOADS + "/Video To Photo" + "/" + System.currentTimeMillis() + "." + format;
        File file = new File(path);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        if (format.equals("JPG")){
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
        }else{
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
        }

    }
}