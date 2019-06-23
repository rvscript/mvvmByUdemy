package com.example.rv193.mvvmudemy.home.mainActivity.fragments.detailsFragment;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rv193.mvvmudemy.R;
import com.example.rv193.mvvmudemy.viewmodel.SelectedRepoViewModel;

public class DetailsFragment extends Fragment {
    private TextView tvRepoName, tvDescription, tvForks, tvStars;
    private SelectedRepoViewModel selectedRepoViewModel;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.screen_details, container, false);
        tvRepoName = v.findViewById(R.id.tv_repo_name);
        tvDescription = v.findViewById(R.id.tv_description);
        tvForks = v.findViewById(R.id.tv_forks);
        tvStars = v.findViewById(R.id.tv_stars);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        We will have viewmodel here to have additional methods for save and restore
//        get a reference to the SelectRepoViewModel
        selectedRepoViewModel =
                ViewModelProviders.of(getActivity()).get(SelectedRepoViewModel.class);
//        notice we are using the fragments Bundle
        selectedRepoViewModel.restoreFromBundle(savedInstanceState);
        displayRepo();
    }

//    onSaveInstanceState
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        selectedRepoViewModel.saveToBundle(outState);
    }

    private void displayRepo() {

        selectedRepoViewModel.getSelectedRepo().observe(this, repo -> {
            tvRepoName.setText(repo.name);
            tvDescription.setText(repo.description);
//            use String.ValueOf()
            tvForks.setText(String.valueOf(repo.forks));
            tvStars.setText(String.valueOf(repo.stars));
        });
    }
}
