package com.example.maurigram.View.Fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.maurigram.R;
import com.google.firebase.crash.FirebaseCrash;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {


    private String TAG ="SearchFragment";

    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FirebaseCrash.log("Iniciando " + TAG);
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

}