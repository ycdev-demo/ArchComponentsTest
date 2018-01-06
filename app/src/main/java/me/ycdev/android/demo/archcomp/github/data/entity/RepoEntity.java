package me.ycdev.android.demo.archcomp.github.data.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.provider.BaseColumns;

@SuppressWarnings("WeakerAccess, unused")
@Entity(tableName = RepoEntity.TABLE_NAME)
public class RepoEntity {
    public static final String TABLE_NAME = "repo";

    public static final String COLUMN_ID = BaseColumns._ID;
    public static final String COLUMN_REPO_ID = "repo_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_FULL_NAME = "full_name";
    public static final String COLUMN_OWNER_USER_ID = "owner_user_id";
    public static final String COLUMN_OWNER_USER_LOGIN = "owner_user_login";
    public static final String COLUMN_HTML_URL = "html_url";
    public static final String COLUMN_IS_FORK = "is_fork";
    public static final String COLUMN_WATCHERS_COUNT = "watchers_count";
    public static final String COLUMN_STARS_COUNT = "stars_count";
    public static final String COLUMN_FOLKS_COUNT = "forks_count";

    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUNN_LANGUAGE = "language";
    public static final String COLUMN_CREATED_AT = "created_at";
    public static final String COLUMN_UPDATED_AT = "updated_at";
    public static final String COLUMN_PUSHED_AT = "pushed_at";
    public static final String COLUMN_OPEN_ISSUES_COUNT = "open_issues_count";

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_ID, index = true)
    public long id;

    @ColumnInfo(name = COLUMN_REPO_ID, index = true)
    public long repoId;

    @ColumnInfo(name = COLUMN_NAME, index = true)
    public String name;

    @ColumnInfo(name = COLUMN_FULL_NAME)
    public String fullName;

    @ColumnInfo(name = COLUMN_OWNER_USER_ID)
    public long ownerUserId;

    @ColumnInfo(name = COLUMN_OWNER_USER_LOGIN)
    public String ownerUserLogin;

    @ColumnInfo(name = COLUMN_HTML_URL)
    public String htmlUrl;

    @ColumnInfo(name = COLUMN_IS_FORK)
    public boolean isFork;

    @ColumnInfo(name = COLUMN_WATCHERS_COUNT)
    public int watchersCount;

    @ColumnInfo(name = COLUMN_STARS_COUNT)
    public int starsCount;

    @ColumnInfo(name = COLUMN_FOLKS_COUNT)
    public int folksCount;

    @ColumnInfo(name = COLUMN_DESCRIPTION)
    public String description;

    @ColumnInfo(name = COLUNN_LANGUAGE)
    public String language;

    @ColumnInfo(name = COLUMN_CREATED_AT)
    public String createdAt;

    @ColumnInfo(name = COLUMN_UPDATED_AT)
    public String updatedAt;

    @ColumnInfo(name = COLUMN_PUSHED_AT)
    public String pushedAt;

    @ColumnInfo(name = COLUMN_OPEN_ISSUES_COUNT)
    public int openIssuesCount;
}
