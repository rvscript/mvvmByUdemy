package com.example.rv193.mvvmudemy.base;

import com.example.rv193.mvvmudemy.home.mainActivity.fragments.detailsFragment.DetailsFragment;
import com.example.rv193.mvvmudemy.home.mainActivity.fragments.listFragment.ListFragment;
import com.example.rv193.mvvmudemy.network.NetworkModule;
import com.example.rv193.mvvmudemy.viewmodel.ViewModelModule;

import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules = {
        NetworkModule.class,
        ViewModelModule.class
})
// the inject will be used in the list fragment so that dagger can generate an implementation
public interface ApplicationComponent {
    void inject(ListFragment listFragment);
    void inject(DetailsFragment detailsFragment);
}
