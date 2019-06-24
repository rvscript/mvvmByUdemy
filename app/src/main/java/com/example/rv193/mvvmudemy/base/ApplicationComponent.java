package com.example.rv193.mvvmudemy.base;

import com.example.rv193.mvvmudemy.network.NetworkModule;
import com.example.rv193.mvvmudemy.viewmodel.ViewModelModule;

import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules = {
        NetworkModule.class,
        ViewModelModule.class,
})
public interface ApplicationComponent {

}
