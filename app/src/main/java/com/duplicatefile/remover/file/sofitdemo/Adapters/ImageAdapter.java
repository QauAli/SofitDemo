package com.duplicatefile.remover.file.sofitdemo.Adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.duplicatefile.remover.file.sofitdemo.databinding.RvImageItemBinding;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {
    private ArrayList<String> imageUrls;

    public ImageAdapter(ArrayList<String> imageUrls) {
        this.imageUrls = imageUrls;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(RvImageItemBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final String s = imageUrls.get(position);

        Glide.with(holder.mBinding.iv.getContext())
                .load(s)
                .centerCrop()
                .into(holder.mBinding.iv);
    }

    @Override
    public int getItemCount() {
        return imageUrls.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private RvImageItemBinding mBinding;

        public ViewHolder(RvImageItemBinding mBinding) {
            super(mBinding.getRoot());
            this.mBinding = mBinding;

        }
    }
}