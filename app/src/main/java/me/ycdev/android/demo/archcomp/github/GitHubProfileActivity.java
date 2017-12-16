package me.ycdev.android.demo.archcomp.github;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.ycdev.android.demo.archcomp.R;
import me.ycdev.android.demo.archcomp.github.web.GitHubUserProfile;
import me.ycdev.android.lib.common.utils.DateTimeUtils;

public class GitHubProfileActivity extends AppCompatActivity {
    @BindView(R.id.avatar)
    ImageView mAvatarView;
    @BindView(R.id.name)
    TextView mNameView;
    @BindView(R.id.following)
    TextView mFollowingView;
    @BindView(R.id.followers)
    TextView mFollowersView;
    @BindView(R.id.updated_at)
    TextView mUpdatedAtView;
    @BindView(R.id.repos)
    RecyclerView mReposView;

    GitHubRepoAdapter mReposAdapter;

    private GitHubProfileViewModel mModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_github_profile);
        ButterKnife.bind(this);

        mReposView.setLayoutManager(new LinearLayoutManager(this));
        mReposAdapter = new GitHubRepoAdapter();
        mReposView.setAdapter(mReposAdapter);

        mModel = ViewModelProviders.of(this).get(GitHubProfileViewModel.class);
        mModel.init("yongce");
        mModel.getUserProfile().observe(this, gitHubUserProfile -> {
            if (gitHubUserProfile != null) {
                refreshUi(gitHubUserProfile);
            }
        });
        mModel.getRepos().observe(this, gitHubRepos -> mReposAdapter.updateData(gitHubRepos));
    }

    private void refreshUi(@NonNull GitHubUserProfile userProfile) {
        Glide.with(this).asBitmap()
                .load(userProfile.avatarUrl)
                .apply(RequestOptions.circleCropTransform())
                .into(mAvatarView);
        mNameView.setText(getString(R.string.github_user_name_info,
                userProfile.login, userProfile.name));
        mFollowingView.setText(getString(R.string.github_following_info, userProfile.followingCount));
        mFollowersView.setText(getString(R.string.github_followers_info, userProfile.followersCount));
        mUpdatedAtView.setText(getString(R.string.common_update_at,
                DateTimeUtils.getReadableTimeStamp(System.currentTimeMillis())));
    }
}
