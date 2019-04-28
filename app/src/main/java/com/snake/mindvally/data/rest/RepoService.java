package com.snake.mindvally.data.rest;

import com.snake.mindvally.data.model.pojo.Data;
import com.snake.mindvally.data.model.pojo.User;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RepoService {

//    @GET("orgs/Google/repos")
//Single<List<Repo>> getRepositories();
    @GET("wgkJgazE")
    Single<List<Data>> getRepositories();

//    @GET("raw/wgkJgazE/")
    Single<User> getRepo(@Path("owner") String owner, @Path("name") String name);
}
