package com.duplicatefile.remover.file.sofitdemo.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.duplicatefile.remover.file.sofitdemo.R;
import com.duplicatefile.remover.file.sofitdemo.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding mBinding;
    private Context mContext;
    public HomeFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mBinding = FragmentHomeBinding.inflate(inflater, container, false);
        View view = mBinding.getRoot();
        mContext = view.getContext();
        setViews();
        return view;
    }
    private void setViews() {
        CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(mContext);
        circularProgressDrawable.setStrokeWidth(5f);
        circularProgressDrawable.setCenterRadius(30f);
        circularProgressDrawable.start();

        Glide.with(mContext)
                .applyDefaultRequestOptions(RequestOptions.centerCropTransform()
                        .diskCacheStrategy(DiskCacheStrategy.RESOURCE))
                .load("http://goo.gl/gEgYUd")
                .placeholder(circularProgressDrawable)
                .into(mBinding.imageView);
    }
}