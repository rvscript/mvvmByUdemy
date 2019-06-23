package com.example.rv193.mvvmudemy.network;

import com.example.rv193.mvvmudemy.model.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RepoService {
    @GET("orgs/Google/repos")
    Call<List<Repo>> getRepositories();
//    adding endpoint for owner we are going to substitute owner and name in the path
    @GET("repos/{owner}/{name}")
//    The @Path is a meta tag to substitute owner and name in this example
    Call<Repo> getRepo(@Path("owner") String repoOwner, @Path("name") String repoName);
}
