package me.ycdev.android.demo.archcomp.github.web;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings({"WeakerAccess", "unused"})
public class GitHubRepo {
    @SerializedName("id")
    public long id;
    @SerializedName("name")
    public String name;
    @SerializedName("full_name")
    public String fullName;
    @SerializedName("owner")
    public GitHubUserBasic owner;

    @SerializedName("html_url")
    public String htmlUrl;
    @SerializedName("fork")
    public boolean isFork;
    @SerializedName("stargazers_count")
    public int starsCount;
    @SerializedName("forks_count")
    public int folksCount;
}
