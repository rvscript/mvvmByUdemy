package com.example.rv193.mvvmudemy.home;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.rv193.mvvmudemy.R;
import com.example.rv193.mvvmudemy.viewmodel.ListViewModel;

public class ListFragment extends Fragment {
    private RecyclerView recyclerView;
    private TextView textView;
    private ProgressBar progressBar;
    private ListViewModel viewModel;
    private static int y = 0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);
        textView = view.findViewById(R.id.tv_error);
        progressBar = view.findViewById(R.id.loading_view);
        //setRetainInstance(true);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        MVVM will reuse one instance of this !!!
        viewModel = ViewModelProviders.of(this).get(ListViewModel.class);
        Log.d(ListViewModel.TAG, "onViewCreated: "+y+++" ListViewModel count="+ ListViewModel.x);
//        set up recyclerview
//        add itemdecoration for item separation
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
//        set adapter with vm and lifecycle owner
        recyclerView.setAdapter(new RepoListAdapter(viewModel, this));
//        set the layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        We need to listen to all of the livedata objects with the following observe method
        observeViewModel();
    }

    private void observeViewModel() {
//        to observe livedata use the GETTER from ViewModel and Call OBSERVE
//        viewmodel.getYouCreated().observe(LifeCycleOwner: this, anonymous f() lambda)
        viewModel.getRepos().observe(this, repos -> {
            if(repos != null) {
                recyclerView.setVisibility(View.VISIBLE);
            }
        });
//        reference to the error live data and do the same thing
        viewModel.getError().observe(this, isError -> {
//            if isError Check
            if(isError) {
                textView.setVisibility(View.VISIBLE);
                recyclerView.setVisibility(View.GONE);
                textView.setText(R.string.api_error_repos);
            } else {
                textView.setVisibility(View.GONE);
                textView.setText(null);
            }
        });
//        Loading live data
        viewModel.getLoading().observe(this, isLoading -> {
            progressBar.setVisibility(isLoading ? View.VISIBLE : View.GONE);
            if(isLoading) {
                textView.setVisibility(View.GONE);
                recyclerView.setVisibility(View.GONE);
            }
        });
    }
}
