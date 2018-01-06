package me.ycdev.android.demo.archcomp.github.data;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.List;

import me.ycdev.android.demo.archcomp.github.data.entity.UserEntity;
import me.ycdev.android.demo.archcomp.github.data.pojo.UserSummary;
import me.ycdev.android.demo.archcomp.github.web.GitHubUserBasic;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(AndroidJUnit4.class)
public class GitHubDaoTest {
    private GitHubDatabase mDb;
    private GitHubDao mDao;

    @Before
    public void createDb() {
        Context context = InstrumentationRegistry.getTargetContext();
        mDb = Room.inMemoryDatabaseBuilder(context, GitHubDatabase.class).build();
        mDao = mDb.dao();
    }

    @After
    public void closeDb() throws IOException {
        mDb.close();
    }

    private static UserEntity createUser_yongce() {
        UserEntity user = new UserEntity();
        user.userId = 373447L;
        user.login = "yongce";
        user.type = GitHubUserBasic.Type.USER;
        user.name = "Yongce Tu";
        user.avatarUrl = "https://avatars3.githubusercontent.com/u/373447?v=4";
        user.email = "";
        user.bio = "Haha...";
        user.location = "Beijing, China";
        user.company = "Mobvoi";
        user.blog = null;
        user.publicReposCount = 23;
        user.publicGistsCount = 4;
        user.followersCount = 156;
        user.followingCount = 16;
        user.createdAt = "2010-08-23T13:35:17Z";
        return user;
    }

    private static void checkUser_yongce(UserEntity user) {
        assertThat(user.userId, is(373447L));
        assertThat(user.login, is("yongce"));
        assertThat(user.type, is(GitHubUserBasic.Type.USER));
        assertThat(user.name, is("Yongce Tu"));
        assertThat(user.avatarUrl, is("https://avatars3.githubusercontent.com/u/373447?v=4"));
        assertThat(user.email, is(""));
        assertThat(user.bio, is("Haha..."));
        assertThat(user.location, is("Beijing, China"));
        assertThat(user.company, is("Mobvoi"));
        assertThat(user.blog, nullValue());
        assertThat(user.publicReposCount, is(23));
        assertThat(user.publicGistsCount, is(4));
        assertThat(user.followersCount, is(156));
        assertThat(user.followingCount, is(16));
        assertThat(user.createdAt, is("2010-08-23T13:35:17Z"));
    }

    private static void checkUser_yongce(UserSummary user) {
        assertThat(user.login, is("yongce"));
        assertThat(user.type, is(GitHubUserBasic.Type.USER));
        assertThat(user.name, is("Yongce Tu"));
        assertThat(user.avatarUrl, is("https://avatars3.githubusercontent.com/u/373447?v=4"));
        assertThat(user.publicReposCount, is(23));
        assertThat(user.publicGistsCount, is(4));
        assertThat(user.followersCount, is(156));
        assertThat(user.followingCount, is(16));
    }

    private UserEntity createUser_ycdev_demo() {
        UserEntity user = new UserEntity();
        user.userId = 6318286L;
        user.login = "ycdev-demo";
        user.type = GitHubUserBasic.Type.ORG;
        user.name = "";
        user.avatarUrl = "https://avatars1.githubusercontent.com/u/6318286?v=4";
        user.email = "";
//        user.bio = null; // no such field for 'ORG'
        user.location = null;
        user.company = null;
        user.blog = "";
        user.publicReposCount = 21;
        user.publicGistsCount = 0;
        user.followersCount = 0;
        user.followingCount = 0;
        user.createdAt = "2014-01-04T15:10:40Z";
        return user;
    }

    private static void checkUser_ycdev_demo(UserEntity user) {
        assertThat(user.userId, is(6318286L));
        assertThat(user.login, is("ycdev-demo"));
        assertThat(user.type, is(GitHubUserBasic.Type.ORG));
        assertThat(user.name, is(""));
        assertThat(user.avatarUrl, is("https://avatars1.githubusercontent.com/u/6318286?v=4"));
        assertThat(user.email, is(""));
        assertThat(user.bio, nullValue());
        assertThat(user.location, nullValue());
        assertThat(user.company, nullValue());
        assertThat(user.blog, is(""));
        assertThat(user.publicReposCount, is(21));
        assertThat(user.publicGistsCount, is(0));
        assertThat(user.followersCount, is(0));
        assertThat(user.followingCount, is(0));
        assertThat(user.createdAt, is("2014-01-04T15:10:40Z"));
    }

    private static void checkUser_ycdev_demo(UserSummary user) {
        assertThat(user.login, is("ycdev-demo"));
        assertThat(user.type, is(GitHubUserBasic.Type.ORG));
        assertThat(user.name, is(""));
        assertThat(user.avatarUrl, is("https://avatars1.githubusercontent.com/u/6318286?v=4"));
        assertThat(user.publicReposCount, is(21));
        assertThat(user.publicGistsCount, is(0));
        assertThat(user.followersCount, is(0));
        assertThat(user.followingCount, is(0));
    }

    @Test
    public void usersCount() {
        assertThat(mDao.usersCount(), is(0));
        mDao.insert(createUser_yongce());
        mDao.insert(createUser_ycdev_demo());

        assertThat(mDao.usersCount(), is(2));
    }

    @Test
    public void loadAllUsers() {
        mDao.insert(createUser_yongce());
        mDao.insert(createUser_ycdev_demo());

        List<UserSummary> users = mDao.loadAllUsers();
        assertThat(users.size(), is(2));
        checkUser_yongce(users.get(0));
        checkUser_ycdev_demo(users.get(1));
    }

    @Test
    public void loadUsersByType() {
        mDao.insert(createUser_yongce());
        mDao.insert(createUser_ycdev_demo());

        {
            List<UserSummary> users = mDao.loadUsersByType(GitHubUserBasic.Type.USER);
            assertThat(users.size(), equalTo(1));
            checkUser_yongce(users.get(0));
        }

        {
            List<UserSummary> orgs = mDao.loadUsersByType(GitHubUserBasic.Type.ORG);
            assertThat(orgs.size(), equalTo(1));
            checkUser_ycdev_demo(orgs.get(0));
        }
    }

    @Test
    public void loadUser() {
        mDao.insert(createUser_yongce());
        mDao.insert(createUser_ycdev_demo());

        {
            UserEntity user = mDao.loadUser("yongce");
            checkUser_yongce(user);
        }

        {
            UserEntity user = mDao.loadUser(373447L);
            checkUser_yongce(user);
        }
    }

    @Test
    public void insertUser() {
        assertThat(mDao.usersCount(), is(0));
        mDao.insert(createUser_yongce());

        assertThat(mDao.usersCount(), is(1));
        UserEntity user = mDao.loadUser("yongce");
        assertThat(user.userId, is(373447L));
        assertThat(user.login, is("yongce"));
        assertThat(user.type, is(GitHubUserBasic.Type.USER));
        assertThat(user.name, is("Yongce Tu"));
        assertThat(user.avatarUrl, is("https://avatars3.githubusercontent.com/u/373447?v=4"));
        assertThat(user.email, is(""));
        assertThat(user.bio, is("Haha..."));
        assertThat(user.location, is("Beijing, China"));
        assertThat(user.company, is("Mobvoi"));
        assertThat(user.blog, nullValue());
        assertThat(user.publicReposCount, is(23));
        assertThat(user.publicGistsCount, is(4));
        assertThat(user.followersCount, is(156));
        assertThat(user.followingCount, is(16));
        assertThat(user.createdAt, is("2010-08-23T13:35:17Z"));
    }

    @Test
    public void updateUser() {
        {
            long id = mDao.insert(createUser_yongce());
            UserEntity user1 = createUser_yongce();
            user1.id = id; // used to identify the user
            user1.login = "yongce2";
            mDao.update(user1);

            mDao.update(createUser_ycdev_demo());
        }

        {
            UserEntity user = mDao.loadUser("yongce");
            assertThat(user, nullValue());
            user = mDao.loadUser("yongce2");
            assertThat(user.login, is("yongce2"));
            user.login = "yongce";
            checkUser_yongce(user);
        }

        {
            UserEntity user = mDao.loadUser("ycdev-demo");
            assertThat(user, nullValue());
        }
    }

    @Test
    public void deleteUser() {
        mDao.insert(createUser_yongce());
        UserEntity ycDevDemo = createUser_ycdev_demo();
        ycDevDemo.id = mDao.insert(ycDevDemo);

        {
            mDao.deleteUser("yongce");
            assertThat(mDao.usersCount(), is(1));
            UserEntity user = mDao.loadUser("ycdev-demo");
            checkUser_ycdev_demo(user);
        }

        {
            mDao.delete(ycDevDemo);
            assertThat(mDao.usersCount(), is(0));
        }
    }
}
