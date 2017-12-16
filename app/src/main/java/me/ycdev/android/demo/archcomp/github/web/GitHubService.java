package me.ycdev.android.demo.archcomp.github.web;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubService {
    @GET("/users/{user}")
    Call<GitHubUserProfile> userProfile(@Path("user") String user);

    @GET("/users/{user}/repos")
    Call<List<GitHubRepo>> listRepos(@Path("user") String user);
}
