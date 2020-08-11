package com.duplicatefile.remover.file.sofitdemo.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.duplicatefile.remover.file.sofitdemo.R;
import com.duplicatefile.remover.file.sofitdemo.databinding.FragmentPostsBinding;

public class PostsFragment extends Fragment {

    private FragmentPostsBinding mBinding;
    private Context mContext;

    public PostsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentPostsBinding.inflate(inflater, container, false);
        View view = mBinding.getRoot();
        mContext = view.getContext();
        return view;

    }
}