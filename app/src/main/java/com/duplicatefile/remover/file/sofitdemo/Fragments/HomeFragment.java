package com.duplicatefile.remover.file.sofitdemo.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.duplicatefile.remover.file.sofitdemo.Adapters.ImageAdapter;
import com.duplicatefile.remover.file.sofitdemo.R;
import com.duplicatefile.remover.file.sofitdemo.databinding.FragmentHomeBinding;

import java.util.ArrayList;

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

        ImageAdapter mAdapter;
        ArrayList<String> mStringList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            mStringList.add("https://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Ramkot_Fort_Mirpur.jpg/800px-Ramkot_Fort_Mirpur.jpg");
        }

        mAdapter = new ImageAdapter(mStringList);
        mBinding.rvImages.setHasFixedSize(true);
        mBinding.rvImages.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, true));
        mBinding.rvImages.setAdapter(mAdapter);

        mBinding.rvCv.setHasFixedSize(true);
        mBinding.rvCv.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, true));
        mBinding.rvCv.setAdapter(mAdapter);





//        setViews();
        return view;
    }
    private void setViews() {
        CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(mContext);
        circularProgressDrawable.setStrokeWidth(5f);
        circularProgressDrawable.setCenterRadius(30f);
        circularProgressDrawable.start();

    }
}