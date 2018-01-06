package me.ycdev.android.demo.archcomp.github.data.pojo;

import android.arch.persistence.room.ColumnInfo;

import me.ycdev.android.demo.archcomp.github.data.entity.RepoEntity;

@SuppressWarnings("WeakerAccess, unused")
public class RepoSummary {
    public static final String SELECT_COLUMNS = RepoEntity.COLUMN_NAME
            + "," + RepoEntity.COLUMN_HTML_URL
            + "," + RepoEntity.COLUMN_WATCHERS_COUNT
            + "," + RepoEntity.COLUMN_STARS_COUNT
            + "," + RepoEntity.COLUMN_FOLKS_COUNT;

    @ColumnInfo(name = RepoEntity.COLUMN_NAME)
    public String name;

    @ColumnInfo(name = RepoEntity.COLUMN_HTML_URL)
    public String htmlUrl;

    @ColumnInfo(name = RepoEntity.COLUMN_WATCHERS_COUNT)
    public int watchersCount;

    @ColumnInfo(name = RepoEntity.COLUMN_STARS_COUNT)
    public int starsCount;

    @ColumnInfo(name = RepoEntity.COLUMN_FOLKS_COUNT)
    public int folksCount;
}
