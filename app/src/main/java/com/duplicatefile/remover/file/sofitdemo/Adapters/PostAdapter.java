package com.duplicatefile.remover.file.sofitdemo.Adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.duplicatefile.remover.file.sofitdemo.Model.Posts;
import com.duplicatefile.remover.file.sofitdemo.databinding.RvPostItemBinding;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    private List<Posts> dataList;

    public PostAdapter(List<Posts> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(RvPostItemBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Posts s = dataList.get(position);

        holder.mBinding.tv.setText(s.getTitle());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private RvPostItemBinding mBinding;

        public ViewHolder(RvPostItemBinding mBinding) {
            super(mBinding.getRoot());
            this.mBinding = mBinding;

        }
    }
}