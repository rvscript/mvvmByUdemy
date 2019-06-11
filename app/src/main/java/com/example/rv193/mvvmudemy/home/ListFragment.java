package com.example.rv193.mvvmudemy.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.rv193.mvvmudemy.R;

public class ListFragment extends Fragment {
    RecyclerView recyclerView;
    TextView textView;
    ProgressBar progressBar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);
        textView = view.findViewById(R.id.tv_error);
        progressBar = view.findViewById(R.id.loading_view);

        return view;
    }

}
