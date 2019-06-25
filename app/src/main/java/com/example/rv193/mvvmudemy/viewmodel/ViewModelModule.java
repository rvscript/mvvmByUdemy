package com.example.rv193.mvvmudemy.viewmodel;

import android.arch.lifecycle.ViewModel;

import com.example.rv193.mvvmudemy.viewmodel.viewModels.ListViewModel;
import com.example.rv193.mvvmudemy.viewmodel.viewModels.SelectedRepoViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

// this will provide all our viewmodel map values
// dagger will create a map with two values and the keys
// keys are the viewmodel keys and the values are the method arguments
// use @inject so that the viewmodels can use them
@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ListViewModel.class)
    abstract ViewModel bindListViewModel(ListViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(SelectedRepoViewModel.class)
    abstract ViewModel bindSelectedRepoViewModel(SelectedRepoViewModel viewModel);
}
