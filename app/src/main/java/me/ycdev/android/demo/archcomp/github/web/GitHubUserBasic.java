package me.ycdev.android.demo.archcomp.github.web;

import android.support.annotation.StringDef;

import com.google.gson.annotations.SerializedName;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@SuppressWarnings("WeakerAccess")
public class GitHubUserBasic {
    @Retention(RetentionPolicy.SOURCE)
    @StringDef({Type.USER, Type.ORG})
    public @interface Type {
        String USER = "User";
        String ORG = "Organization";
    }

    @SerializedName("id")
    public long id;
    @SerializedName("login")
    public String login;
    @SerializedName("type") @GitHubUserProfile.Type
    public String type;
    @SerializedName("avatar_url")
    public String avatarUrl;
}
