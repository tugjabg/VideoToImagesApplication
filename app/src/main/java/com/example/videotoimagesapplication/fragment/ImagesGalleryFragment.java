package com.example.videotoimagesapplication.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.videotoimagesapplication.R;
import com.example.videotoimagesapplication.adapter.GalleryImagesAdapter;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ImagesGalleryFragment extends Fragment {
    private RecyclerView recyclerView;
    private GalleryImagesAdapter galleryImagesAdapter;
    private List<String> imges;
    private TextView galleryNumber;
    private List<File> fileImages;
    View view;
    public ImagesGalleryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_images_gallery,container, false);
        recyclerView = view.findViewById(R.id.recycler_view_images_gallery);
        galleryNumber = view.findViewById(R.id.gallery_images_number);
        imges = new ArrayList<>();
        fileImages = findImages(new File(Environment.getExternalStorageDirectory() + "/"
                + Environment.DIRECTORY_DOWNLOADS + "/Video To Photo"));
        loadImages();
        return view;
    }

    private void loadImages() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        for (int i = 0; i < fileImages.size(); i++){
            imges.add(String.valueOf(fileImages.get(i)));
        }
        galleryImagesAdapter = new GalleryImagesAdapter(getActivity(), imges, new GalleryImagesAdapter.PhotoListener() {
            @Override
            public void onPhotoClick(String path) {
                System.out.println(path);
            }
        });
        recyclerView.setAdapter(galleryImagesAdapter);
        //galleryNumber.setText(imges.size());
    }
    private List<File> findImages(File file){
        List<File> files = new ArrayList<>();
        File[] imgs = file.listFiles();
        if (imgs!= null){
            for (File f : imgs){
                if (f.isDirectory() && !f.isHidden()){
                    files.addAll(findImages(f));
                }
                else{
                    if (f.getName().endsWith(".jpg") || f.getName().endsWith(".png")){
                        files.addAll(Collections.singleton(f));
                    }
                }
            }
        }

        return  files;
    }
}
