package com.example.rv193.mvvmudemy.network;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

@Module
public class NetworkModule {
//    The repo Api class will be in here
    private static final String BASE_URL = "https://api.github.com/";

    @Provides
    @Singleton
    static Retrofit providRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build();
    }

//    we need to add a provider for our reposervice to the networkmodule
    @Provides
    @Singleton
    static RepoService provideRepoService(Retrofit retrofit) {
        return retrofit.create(RepoService.class);
    }
}
