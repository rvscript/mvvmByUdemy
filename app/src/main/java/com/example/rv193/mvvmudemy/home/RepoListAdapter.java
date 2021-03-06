package com.example.rv193.mvvmudemy.home;

import android.arch.lifecycle.LifecycleOwner;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rv193.mvvmudemy.R;
import com.example.rv193.mvvmudemy.model.Repo;
import com.example.rv193.mvvmudemy.viewmodel.ListViewModel;

import java.util.ArrayList;
import java.util.List;

public class RepoListAdapter extends RecyclerView.Adapter<RepoListAdapter.RepoViewHolder> {

    private final List<Repo> data = new ArrayList<>();

    //    constructor will initiate list and view model
    RepoListAdapter(ListViewModel viewModel, LifecycleOwner lco) {
//        to set up always pass in the lifecycle owner in observe
        viewModel.getRepos().observe(lco, repos -> {
            data.clear();
            if (repos != null) {
                data.addAll(repos);
                notifyDataSetChanged(); // TODO: use diffUtil tool for notifyDataSetChanged
            }
        });
        setHasStableIds(true);
    }

    @NonNull
    @Override
    public RepoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_repo_list_item, viewGroup, false);
        return new RepoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RepoViewHolder repoViewHolder, int i) {
        repoViewHolder.bindHolder(data.get(i));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public long getItemId(int position) {
        return data.get(position).id;
    }

    static final class RepoViewHolder extends RecyclerView.ViewHolder {
        private TextView tvRepoName, tvDescription, tvForks, tvStars;

        RepoViewHolder(@NonNull View v) {
            super(v);
            tvRepoName = v.findViewById(R.id.tv_repo_name);
            tvDescription = v.findViewById(R.id.tv_description);
            tvForks = v.findViewById(R.id.tv_fork);
            tvStars = v.findViewById(R.id.tv_stars);
        }

        void bindHolder(Repo repo) {
            tvRepoName.setText(repo.name);
            tvDescription.setText(repo.description);
//            wrap a number as a String so that android will avoid resource value
            tvForks.setText(String.valueOf(repo.forks));
            tvStars.setText(String.valueOf(repo.stars));
        }

    }
}
