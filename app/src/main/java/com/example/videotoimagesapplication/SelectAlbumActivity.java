package com.example.videotoimagesapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.io.File;

public class SelectAlbumActivity extends AppCompatActivity {
    private File dir;
    private String[] allPath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_album);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}