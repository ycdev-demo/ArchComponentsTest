package me.ycdev.android.demo.archcomp.github.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import me.ycdev.android.demo.archcomp.github.data.entity.RepoEntity;
import me.ycdev.android.demo.archcomp.github.data.entity.UserEntity;
import me.ycdev.android.demo.archcomp.github.data.pojo.RepoSummary;
import me.ycdev.android.demo.archcomp.github.data.pojo.UserSummary;
import me.ycdev.android.demo.archcomp.github.web.GitHubUserBasic;

@SuppressWarnings("unused")
@Dao
public interface GitHubDao {
    /*
     * DAO methods for user/organization
     */
    @Query("SELECT COUNT(*) FROM user")
    int usersCount();

    @Query("SELECT " + UserSummary.SELECT_COLUMNS +" FROM user")
    List<UserSummary> loadAllUsers();

    @Query("SELECT " + UserSummary.SELECT_COLUMNS +" FROM user WHERE type = :type")
    List<UserSummary> loadUsersByType(@GitHubUserBasic.Type String type);

    @Query("SELECT * FROM user WHERE login = :login")
    UserEntity loadUser(String login);

    @Query("SELECT * FROM user WHERE user_id = :userId")
    UserEntity loadUser(long userId);

    @Insert
    long insert(UserEntity user);

    @Insert
    long[] insert(UserEntity... users);

    @Update
    int update(UserEntity user);

    @Delete
    int delete(UserEntity user);

    @Query("DELETE FROM user WHERE login = :login")
    int deleteUser(String login);

    /*
     * DAO methods for repo
     */

    @Query("SELECT COUNT(*) FROM repo")
    int reposCount();

    @Query("SELECT COUNT(*) FROM repo WHERE owner_user_login = :userLogin")
    int reposCount(String userLogin);

    @Query("SELECT COUNT(*) FROM repo WHERE owner_user_id = :userId")
    int reposCount(long userId);

    @Query("SELECT " + RepoSummary.SELECT_COLUMNS + " FROM repo")
    List<RepoSummary> loadAllRepos();

    @Query("SELECT " + RepoSummary.SELECT_COLUMNS + " FROM repo WHERE owner_user_login = :userLogin")
    List<RepoSummary> loadRepos(String userLogin);

    @Query("SELECT " + RepoSummary.SELECT_COLUMNS + " FROM repo WHERE owner_user_id = :userId")
    List<RepoSummary> loadRepos(long userId);

    @Query("SELECT * FROM repo WHERE full_name = :fullName")
    RepoEntity loadRepo(String fullName);

    @Query("SELECT * FROM repo WHERE repo_id = :repoId")
    RepoEntity loadRepo(long repoId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertRepo(RepoEntity repos);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertRepos(RepoEntity[] repos);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertRepos(List<RepoEntity> repos);

    @Update
    int updateRepo(RepoEntity repo);

    @Update
    int updateRepos(RepoEntity[] repos);

    @Update
    int updateRepos(List<RepoEntity> repos);

    @Delete
    int deleteRepo(RepoEntity repo);

    @Query("DELETE FROM repo WHERE repo_id = :repoId")
    int deleteRepo(long repoId);

    @Query("DELETE FROM repo WHERE full_name = :fullName")
    int deleteRepo(String fullName);
}
