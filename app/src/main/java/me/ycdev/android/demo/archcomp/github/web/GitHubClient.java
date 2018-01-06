package me.ycdev.android.demo.archcomp.github.web;

import java.io.IOException;
import java.util.List;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GitHubClient {
    GitHubService mWebService;

    public GitHubClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mWebService = retrofit.create(GitHubService.class);
    }

    public Response<GitHubUserProfile> getUser(String login) throws IOException {
        return mWebService.userProfile(login).execute();
    }

    public Response<List<GitHubRepo>> listRepos(String login) throws IOException {
        return mWebService.listRepos(login).execute();
    }
}
