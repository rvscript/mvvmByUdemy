package com.example.rv193.mvvmudemy.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.rv193.mvvmudemy.model.Repo;

public class SelectedRepoViewModel extends ViewModel {
    private final MutableLiveData<Repo> selectedRepo = new MutableLiveData<>();
    public LiveData<Repo> getSelectedRepo() {
        return selectedRepo;
    }

    public void setSelectedRepo(Repo repo) {
        selectedRepo.setValue(repo);
    }
}
