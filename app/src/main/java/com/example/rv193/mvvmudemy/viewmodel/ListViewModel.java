package com.example.rv193.mvvmudemy.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.rv193.mvvmudemy.model.Repo;

import java.util.List;

public class ListViewModel extends ViewModel {
    private final MutableLiveData<List<Repo>> repos = new MutableLiveData<>();
    private final MutableLiveData<Boolean> repoLoadError = new MutableLiveData<>();
}
