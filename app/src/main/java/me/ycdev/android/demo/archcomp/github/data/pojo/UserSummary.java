package me.ycdev.android.demo.archcomp.github.data.pojo;

import android.arch.persistence.room.ColumnInfo;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;

import me.ycdev.android.demo.archcomp.github.data.entity.UserEntity;
import me.ycdev.android.demo.archcomp.github.web.GitHubUserProfile;

@SuppressWarnings("WeakerAccess, unused")
public class UserSummary {
    public static final String SELECT_COLUMNS = UserEntity.COLUMN_LOGIN
            + "," + UserEntity.COLUMN_TYPE
            + "," + UserEntity.COLUMN_NAME
            + "," + UserEntity.COLUMN_AVATAR_URL
            + "," + UserEntity.COLUMN_PUBLIC_REPOS_COUNT
            + "," + UserEntity.COLUMN_PUBLIC_GISTS_COUNT
            + "," + UserEntity.COLUMN_FOLLOWERS_COUNT
            + "," + UserEntity.COLUMN_FOLLOWING_COUNT;

    @ColumnInfo(name = UserEntity.COLUMN_LOGIN)
    public String login;

    @ColumnInfo(name = UserEntity.COLUMN_TYPE) @GitHubUserProfile.Type
    public String type;

    @ColumnInfo(name = UserEntity.COLUMN_NAME)
    public String name;

    @ColumnInfo(name = UserEntity.COLUMN_AVATAR_URL)
    public String avatarUrl;

    @ColumnInfo(name = UserEntity.COLUMN_PUBLIC_REPOS_COUNT)
    public int publicReposCount;

    @ColumnInfo(name = UserEntity.COLUMN_PUBLIC_GISTS_COUNT)
    public int publicGistsCount;

    @ColumnInfo(name = UserEntity.COLUMN_FOLLOWERS_COUNT)
    public int followersCount;

    @ColumnInfo(name = UserEntity.COLUMN_FOLLOWING_COUNT)
    public int followingCount;


    @VisibleForTesting
    public static boolean equal(UserEntity user1, UserSummary user2) {
        if (user1 == null && user2 == null) {
            return true;
        } else if (user1 != null && user2 != null) {
            return TextUtils.equals(user1.login, user2.login)
                    && TextUtils.equals(user1.type, user2.type)
                    && TextUtils.equals(user1.name, user2.name)
                    && TextUtils.equals(user1.avatarUrl, user2.avatarUrl)
                    && user1.publicReposCount == user2.publicReposCount
                    && user1.publicGistsCount == user2.publicGistsCount
                    && user1.followersCount == user2.followersCount
                    && user1.followingCount == user2.followingCount;
        } else {
            return false;
        }
    }
}
