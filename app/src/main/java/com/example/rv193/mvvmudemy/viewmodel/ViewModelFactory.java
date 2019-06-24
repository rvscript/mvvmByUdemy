package com.example.rv193.mvvmudemy.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
public class ViewModelFactory implements ViewModelProvider.Factory {

    private final Map<Class<? extends ViewModel>, Provider<ViewModel>> viewModels;

//    Here we inject the Map that we created for Dagger to map our viewmodels
    @Inject
    ViewModelFactory(Map<Class<? extends ViewModel>, Provider<ViewModel>> viewModels){
        this.viewModels = viewModels;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        try {
            return (T) viewModels.get(modelClass).get();
        } catch (Exception e) {
            throw new RuntimeException("Error creating ViewModel for class: "+modelClass.getSimpleName(), e);
        }

    }
}
