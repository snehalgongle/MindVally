package com.snake.mindvally.data.rest;

import com.snake.mindvally.data.model.pojo.Data;
import com.snake.mindvally.data.model.pojo.User;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class RepoRepository {

    private final RepoService repoService;

    @Inject
    public RepoRepository(RepoService repoService) {
        this.repoService = repoService;
    }

    public Single<List<Data>> getRepositories() {
//        Log.d(this.getClass().getSimpleName(), "getRepositories: "+ repoService.getRepositories().toString());
        return repoService.getRepositories();
    }

    public Single<User> getRepo(String owner, String name) {
        return repoService.getRepo(owner, name);
    }
}
