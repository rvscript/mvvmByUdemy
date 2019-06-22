package com.example.rv193.mvvmudemy.home.activities.mainActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.rv193.mvvmudemy.R;
import com.example.rv193.mvvmudemy.home.mainActivity.fragments.listFragment.ListFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //load fragment
        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.screen_container, new ListFragment())
                    .commit();
        }
    }
}
