package com.duplicatefile.remover.file.sofitdemo.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.duplicatefile.remover.file.sofitdemo.R;
import com.duplicatefile.remover.file.sofitdemo.databinding.FragmentServicesBinding;

public class ServicesFragment extends Fragment {
    private FragmentServicesBinding mBinding;
    private Context mContext;

    public ServicesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentServicesBinding.inflate(inflater, container, false);
        View view = mBinding.getRoot();
        mContext = view.getContext();
        return view;
    }
}