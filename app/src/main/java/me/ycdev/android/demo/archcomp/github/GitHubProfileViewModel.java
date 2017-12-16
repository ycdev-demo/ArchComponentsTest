package me.ycdev.android.demo.archcomp.github;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import me.ycdev.android.demo.archcomp.github.web.GitHubRepo;
import me.ycdev.android.demo.archcomp.github.web.GitHubUserProfile;

public class GitHubProfileViewModel extends ViewModel {
    private GitHubRepository mRepository;
    private LiveData<GitHubUserProfile> mUserProfile;
    private LiveData<List<GitHubRepo>> mReposList;

    public GitHubProfileViewModel() {
        mRepository = new GitHubRepository();
    }

    public void init(String userLoginName) {
        if (mUserProfile != null) {
            return;
        }
        mUserProfile = mRepository.getUserProfile(userLoginName);
        mReposList = mRepository.getRepos(userLoginName);
    }

    public LiveData<GitHubUserProfile> getUserProfile() {
        return mUserProfile;
    }

    public LiveData<List<GitHubRepo>> getRepos() {
        return mReposList;
    }
}
