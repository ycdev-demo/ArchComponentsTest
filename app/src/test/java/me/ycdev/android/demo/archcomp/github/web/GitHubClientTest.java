package me.ycdev.android.demo.archcomp.github.web;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;

import retrofit2.Response;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GitHubClientTest {
    private static GitHubClient sGitHubClient;

    @BeforeClass
    public static void setupClass() {
        sGitHubClient = new GitHubClient();
    }

    @Test
    public void getUser_user() throws IOException {
        Response<GitHubUserProfile> response = sGitHubClient.getUser("yongce");
        assertThat(response.code(), is(HttpURLConnection.HTTP_OK));
        assertThat(response.isSuccessful(), is(true));
        GitHubUserProfile user = response.body();

        assert user != null;
        assertThat(user.id, is(373447L));
        assertThat(user.login, is("yongce"));
        assertThat(user.type, is(GitHubUserProfile.Type.USER));
        assertThat(user.avatarUrl, is("https://avatars3.githubusercontent.com/u/373447?v=4"));
        assertThat(user.name, is("Yongce Tu"));
//        assertThat(user.email, is("yongce.tu@gmail.com"));
        assertThat(user.location, is("Beijing, China"));
        assertThat(user.publicReposCount, greaterThan(0));
        assertThat(user.publicGistsCount, greaterThan(0));
        assertThat(user.followersCount, greaterThan(0));
        assertThat(user.followingCount, greaterThan(0));
        assertThat(user.createdAt, is("2010-08-23T13:35:17Z"));
    }

    @Test
    public void getUser_org() throws IOException {
        Response<GitHubUserProfile> response = sGitHubClient.getUser("ycdev-demo");
        assertThat(response.code(), is(HttpURLConnection.HTTP_OK));
        assertThat(response.isSuccessful(), is(true));
        GitHubUserProfile user = response.body();

        assert user != null;
        assertThat(user.id, is(6318286L));
        assertThat(user.login, is("ycdev-demo"));
        assertThat(user.type, is(GitHubUserProfile.Type.ORG));
        assertThat(user.publicReposCount, greaterThan(0));
        assertThat(user.publicGistsCount, is(0));
        assertThat(user.followersCount, is(0));
        assertThat(user.followingCount, is(0));
        assertThat(user.createdAt, is("2014-01-04T15:10:40Z"));
    }

    @Test
    public void listRepos_user() throws IOException {
        Response<List<GitHubRepo>> response = sGitHubClient.listRepos("yongce");
        assertThat(response.code(), is(HttpURLConnection.HTTP_OK));
        assertThat(response.isSuccessful(), is(true));
        List<GitHubRepo> reposList = response.body();

        assert reposList != null;
        GitHubRepo repo = findRepo(reposList, 38250720L);
        assert repo != null;
        assertThat(repo.id, is(38250720L));
        assertThat(repo.name, is("AndroidArch"));
        assertThat(repo.fullName, is("yongce/AndroidArch"));
        assertThat(repo.owner.id, is(373447L));
        assertThat(repo.owner.login, is("yongce"));
        assertThat(repo.owner.type, is(GitHubUserBasic.Type.USER));
        assertThat(repo.owner.avatarUrl, is("https://avatars3.githubusercontent.com/u/373447?v=4"));
        assertThat(repo.htmlUrl, is("https://github.com/yongce/AndroidArch"));
        assertThat(repo.isFork, is(false));
        assertThat(repo.starsCount, is(5));
        assertThat(repo.folksCount, is(3));
    }

    private GitHubRepo findRepo(List<GitHubRepo> reposList, long id) {
        for (GitHubRepo repo : reposList) {
            if (repo.id == id) {
                return repo;
            }
        }
        return null;
    }
}
