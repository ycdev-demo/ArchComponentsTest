package me.ycdev.android.demo.archcomp.github.data.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.provider.BaseColumns;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;

import me.ycdev.android.demo.archcomp.github.web.GitHubUserProfile;

@SuppressWarnings("WeakerAccess, unused")
@Entity(tableName = UserEntity.TABLE_NAME)
public class UserEntity {
    public static final String TABLE_NAME = "user";

    public static final String COLUMN_ID = BaseColumns._ID;
    public static final String COLUMN_USER_ID = "user_id";
    public static final String COLUMN_LOGIN = "login";
    public static final String COLUMN_TYPE = "type";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_AVATAR_URL = "avatar_url";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_BIO = "bio";
    public static final String COLUMN_LOCATION = "location";
    public static final String COLUMN_COMPANY = "company";
    public static final String COLUMN_BLOG = "blog";
    public static final String COLUMN_PUBLIC_REPOS_COUNT = "public_repos_count";
    public static final String COLUMN_PUBLIC_GISTS_COUNT = "public_gists_count";
    public static final String COLUMN_FOLLOWERS_COUNT = "followers_count";
    public static final String COLUMN_FOLLOWING_COUNT = "following_count";
    public static final String COLUMN_CREATED_AT = "created";

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_ID, index = true)
    public long id;

    @ColumnInfo(name = COLUMN_USER_ID, index = true)
    public long userId;

    @ColumnInfo(name = COLUMN_LOGIN, index = true)
    public String login;

    @ColumnInfo(name = COLUMN_TYPE) @GitHubUserProfile.Type
    public String type;

    @ColumnInfo(name = COLUMN_NAME)
    public String name;

    @ColumnInfo(name = COLUMN_AVATAR_URL)
    public String avatarUrl;

    @ColumnInfo(name = COLUMN_EMAIL)
    public String email;

    @ColumnInfo(name = COLUMN_BIO)
    public String bio;

    @ColumnInfo(name = COLUMN_LOCATION)
    public String location;

    @ColumnInfo(name = COLUMN_COMPANY)
    public String company;

    @ColumnInfo(name = COLUMN_BLOG)
    public String blog;

    @ColumnInfo(name = COLUMN_PUBLIC_REPOS_COUNT)
    public int publicReposCount;

    @ColumnInfo(name = COLUMN_PUBLIC_GISTS_COUNT)
    public int publicGistsCount;

    @ColumnInfo(name = COLUMN_FOLLOWERS_COUNT)
    public int followersCount;

    @ColumnInfo(name = COLUMN_FOLLOWING_COUNT)
    public int followingCount;

    @ColumnInfo(name = COLUMN_CREATED_AT)
    public String createdAt;

    @VisibleForTesting
    static boolean equal(UserEntity user1, UserEntity user2) {
        if (user1 == user2) {
            return true;
        } else if (user1 != null && user2 != null) {
            return user1.userId == user2.userId
                    && TextUtils.equals(user1.login, user2.login)
                    && TextUtils.equals(user1.type, user2.type)
                    && TextUtils.equals(user1.name, user2.name)
                    && TextUtils.equals(user1.avatarUrl, user2.avatarUrl)
                    && TextUtils.equals(user1.email, user2.email)
                    && TextUtils.equals(user1.bio, user2.bio)
                    && TextUtils.equals(user1.location, user2.location)
                    && TextUtils.equals(user1.company, user2.company)
                    && TextUtils.equals(user1.blog, user2.blog)
                    && user1.publicReposCount == user2.publicReposCount
                    && user1.publicGistsCount == user2.publicGistsCount
                    && user1.followersCount == user2.followersCount
                    && user1.followingCount == user2.followingCount
                    && TextUtils.equals(user1.createdAt, user2.createdAt);
        } else {
            return false;
        }
    }
}
