package com.example.videotoimagesapplication.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.videotoimagesapplication.fragment.ImagesGalleryFragment;
import com.example.videotoimagesapplication.fragment.VideoGalleryFragment;

public class TabGalleryAdapter extends FragmentStatePagerAdapter {

    public TabGalleryAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new VideoGalleryFragment();
                break;
            case 1:
                fragment = new ImagesGalleryFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0){
            return "Video";
        }
        return "Image";
    }
}
