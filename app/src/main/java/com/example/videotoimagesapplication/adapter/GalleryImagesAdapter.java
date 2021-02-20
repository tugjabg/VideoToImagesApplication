package com.example.videotoimagesapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.videotoimagesapplication.R;

import java.util.List;

public class GalleryImagesAdapter extends RecyclerView.Adapter<GalleryImagesAdapter.ViewHolder>{
    private Context context;
    private List<String> imges;
    private PhotoListener photoListener;

    public GalleryImagesAdapter(Context context, List<String> imges, PhotoListener photoListener) {
        this.context = context;
        this.imges = imges;
        this.photoListener = photoListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.gallery_image_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String img = imges.get(position);
        Glide.with(context).load(img).into(holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                photoListener.onPhotoClick(img);
            }
        });
    }

    @Override
    public int getItemCount() {
        return imges.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img_view_gallery_images);
        }
    }

    public interface PhotoListener{
        void onPhotoClick(String path);
    }

}
