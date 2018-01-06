package me.ycdev.android.demo.archcomp.github.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.VisibleForTesting;

import me.ycdev.android.demo.archcomp.github.data.entity.RepoEntity;
import me.ycdev.android.demo.archcomp.github.data.entity.UserEntity;

@Database(entities = {UserEntity.class, RepoEntity.class}, version = GitHubDatabase.DB_VERSION)
public abstract class GitHubDatabase extends RoomDatabase {
    static final String DB_NAME = "github";
    static final int DB_VERSION = 1;

    private static volatile GitHubDatabase sInstance;

    public static GitHubDatabase getInstance(Context context) {
        if (sInstance == null) {
            synchronized (GitHubDatabase.class) {
                if (sInstance == null) {
                    sInstance = Room.databaseBuilder(context.getApplicationContext(),
                            GitHubDatabase.class, DB_NAME).build();
                }
            }
        }
        return sInstance;
    }

    @VisibleForTesting
    public static void switchToInMemory(Context context) {
        sInstance = Room.inMemoryDatabaseBuilder(context.getApplicationContext(),
                GitHubDatabase.class).build();
    }

    public abstract GitHubDao dao();
}
