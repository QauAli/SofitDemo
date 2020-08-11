package com.duplicatefile.remover.file.sofitdemo.Fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.duplicatefile.remover.file.sofitdemo.Adapters.PostAdapter;
import com.duplicatefile.remover.file.sofitdemo.Model.Posts;
import com.duplicatefile.remover.file.sofitdemo.databinding.FragmentPostsBinding;
import com.duplicatefile.remover.file.sofitdemo.utils.GetDataService;
import com.duplicatefile.remover.file.sofitdemo.utils.RetrofitClientInstance;

import java.util.List;

public class PostsFragment extends Fragment {

    private FragmentPostsBinding mBinding;
    private Context mContext;
private PostAdapter postAdapter;
    ProgressDialog progressDoalog;

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

        progressDoalog = new ProgressDialog(mContext);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();

        /*Create handle for the RetrofitInstance interface*/
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<Posts>> call = service.getAllPosts();
        call.enqueue(new Callback<List<Posts>>() {
            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {
                progressDoalog.dismiss();
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(mContext, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
    /*Method to generate List of data using RecyclerView with custom adapter*/
    private void generateDataList(List<Posts> photoList) {
        postAdapter = new PostAdapter(photoList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(mContext);
        mBinding.customResyclerView.setLayoutManager(layoutManager);
        mBinding.customResyclerView.setAdapter(postAdapter);
    }

}