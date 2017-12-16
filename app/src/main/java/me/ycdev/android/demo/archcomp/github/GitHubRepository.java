package me.ycdev.android.demo.archcomp.github;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import java.io.IOException;
import java.util.List;

import me.ycdev.android.demo.archcomp.github.web.GitHubRepo;
import me.ycdev.android.demo.archcomp.github.web.GitHubService;
import me.ycdev.android.demo.archcomp.github.web.GitHubUserProfile;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

public class GitHubRepository {
    private static final String TAG = "GitHubRepository";

    GitHubService mWebService;

    public GitHubRepository() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mWebService = retrofit.create(GitHubService.class);
    }

    public Response<GitHubUserProfile> getUser(String loginName) throws IOException {
        return mWebService.userProfile(loginName).execute();
    }

    public Response<List<GitHubRepo>> listRepos(String login) throws IOException {
        return mWebService.listRepos(login).execute();
    }

    public LiveData<GitHubUserProfile> getUserProfile(String loginName) {
        final MutableLiveData<GitHubUserProfile> userProfile = new MutableLiveData<>();
        mWebService.userProfile(loginName).enqueue(new Callback<GitHubUserProfile>() {
            @Override
            public void onResponse(Call<GitHubUserProfile> call, Response<GitHubUserProfile> response) {
                userProfile.setValue(response.body());
            }

            @Override
            public void onFailure(Call<GitHubUserProfile> call, Throwable t) {
                Timber.tag(TAG).w(t, "failed to fetch user profile from GitHub");
            }
        });
        return userProfile;
    }

    public LiveData<List<GitHubRepo>> getRepos(String loginName) {
        final MutableLiveData<List<GitHubRepo>> reposList = new MutableLiveData<>();
        mWebService.listRepos(loginName).enqueue(new Callback<List<GitHubRepo>>() {
            @Override
            public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
                reposList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {
                Timber.tag(TAG).w(t, "failed to fetch user repos from GitHub");
            }
        });
        return reposList;
    }
}
