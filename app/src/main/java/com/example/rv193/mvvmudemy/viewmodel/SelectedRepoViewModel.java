package com.example.rv193.mvvmudemy.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.Bundle;
import android.util.Log;

import com.example.rv193.mvvmudemy.model.Repo;
import com.example.rv193.mvvmudemy.network.RepoApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SelectedRepoViewModel extends ViewModel {
    private final MutableLiveData<Repo> selectedRepo = new MutableLiveData<>();
    public LiveData<Repo> getSelectedRepo() {
        return selectedRepo;
    }

    private Call<Repo> repoCall;

    public void setSelectedRepo(Repo repo) {
        selectedRepo.setValue(repo);
    }

//    saveToBundle
    public void saveToBundle(Bundle outState) {
        if (selectedRepo.getValue() != null) {
            outState.putStringArray("repo_details", new String[]{
                    selectedRepo.getValue().owner.login, selectedRepo.getValue().name
            });
        }
    }

/*
        if saved instance state is NOT NULL and contains the key repo_details then load the repo
 */
    public void restoreFromBundle(Bundle savedInstanceState) {
        if (selectedRepo.getValue() == null) {
            if (savedInstanceState != null && savedInstanceState.containsKey("repo_details")) {
                loadRepo(savedInstanceState.getStringArray("repo_details"));
            }
        }
    }

    private void loadRepo(String[] repoDetails) {
//        get a reference to a Call from repoService
        repoCall = RepoApi.getInstance().getRepo(repoDetails[0], repoDetails[1]);
        repoCall.enqueue(new Callback<Repo>() {
            @Override
            public void onResponse(Call<Repo> call, Response<Repo> response) {
                selectedRepo.setValue(response.body());
                repoCall = null;
            }

            @Override
            public void onFailure(Call<Repo> call, Throwable t) {
                Log.e(getClass().getSimpleName(), "Error loading Repo", t);
                repoCall = null;
            }
        });
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if(repoCall != null) {
            repoCall.cancel();
            repoCall = null;
        }
    }
}
