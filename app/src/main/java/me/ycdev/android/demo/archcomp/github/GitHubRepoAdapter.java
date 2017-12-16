package me.ycdev.android.demo.archcomp.github;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.ycdev.android.demo.archcomp.R;
import me.ycdev.android.demo.archcomp.github.web.GitHubRepo;

public class GitHubRepoAdapter extends RecyclerView.Adapter<GitHubRepoAdapter.ViewHolder> {
    private List<GitHubRepo> mRepoList;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.github_repo_list_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Context context = holder.itemView.getContext();
        GitHubRepo repo = mRepoList.get(position);
        holder.nameView.setText(repo.name);
        holder.webSiteView.setText(repo.htmlUrl);
        holder.folkView.setText(context.getString(R.string.github_folk_info, repo.folksCount));
        holder.starView.setText(context.getString(R.string.github_star_info, repo.starsCount));
    }

    @Override
    public int getItemCount() {
        return mRepoList != null ? mRepoList.size() : 0;
    }

    public void updateData(List<GitHubRepo> data) {
        mRepoList = data;
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.name)
        TextView nameView;
        @BindView(R.id.web_site)
        TextView webSiteView;
        @BindView(R.id.folk)
        TextView folkView;
        @BindView(R.id.star)
        TextView starView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
