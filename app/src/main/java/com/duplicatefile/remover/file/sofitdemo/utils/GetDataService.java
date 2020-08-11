package com.duplicatefile.remover.file.sofitdemo.utils;

import com.duplicatefile.remover.file.sofitdemo.Model.Posts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {

    @GET("/posts")
    Call<List<Posts>> getAllPosts();
}