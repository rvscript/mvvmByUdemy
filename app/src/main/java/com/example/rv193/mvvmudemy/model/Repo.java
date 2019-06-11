package com.example.rv193.mvvmudemy.model;

import com.squareup.moshi.Json;

public class Repo {
    public final long id;
    public final String name;
    public final String description;
    public final User owner;
//    moshi allows us to give the api value what ever we want
    @Json(name = "stargazers_count")
    public final long stars;
    @Json(name = "forks_count")
    public final long forks;

    public Repo(long id, String name, String description, User owner, long stars, long forks) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.owner = owner;
        this.stars = stars;
        this.forks = forks;
    }
}
