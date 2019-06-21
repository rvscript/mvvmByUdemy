package com.example.rv193.mvvmudemy.network;

import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class RepoApi {
    private static final String BASE_URL = "https://api.github.com/";
    private static Retrofit retrofit;
//    private constructor so that no instances can be created
    private RepoApi() {

    }

//    create a static field to initialize retrofit
    private static void initializeRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build();
    }

//    create a public static method that will get our instance creataed by retrofit
    private static RepoService repoService;
    public static RepoService getInstance() {
//        check if repo service is null
        if(repoService != null) {
            return repoService;
        }
//        if null check if retrofit instance is null
        if(retrofit == null){
            initializeRetrofit();
        }
//        now that we have our service create an instance
        repoService = retrofit.create(RepoService.class);
        return repoService;
    }
}
