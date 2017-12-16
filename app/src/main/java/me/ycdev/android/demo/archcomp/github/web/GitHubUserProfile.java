package me.ycdev.android.demo.archcomp.github.web;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings({"WeakerAccess", "unused"})
public class GitHubUserProfile extends GitHubUserBasic {
    @SerializedName("name")
    public String name;
    @SerializedName("email")
    public String email;
    @SerializedName("bio")
    public String bio;
    @SerializedName("location")
    public String location;
    @SerializedName("company")
    public String company;
    @SerializedName("blog")
    public String blog;
    @SerializedName("public_repos")
    public int publicReposCount;
    @SerializedName("public_gists")
    public int publicGistsCount;
    @SerializedName("followers")
    public int followersCount;
    @SerializedName("following")
    public int followingCount;
    @SerializedName("created_at")
    public String createdAt;
}
