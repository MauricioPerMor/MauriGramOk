package com.example.maurigram.View.Fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.maurigram.R;
import com.example.maurigram.adapter.PictureAdapterRecyclerView;
import com.example.maurigram.model.Picture;
import com.google.firebase.crash.FirebaseCrash;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {


    private String TAG = "ProfileFragment";

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FirebaseCrash.log("Iniciando " + TAG);
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        showToolbar("", false, view);

        RecyclerView picturesRecycler = (RecyclerView) view.findViewById(R.id.picturesProfileRecycler);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        picturesRecycler.setLayoutManager(linearLayoutManager);

        PictureAdapterRecyclerView pictureAdapterRecyclerView =
                new PictureAdapterRecyclerView(buidPictures(), R.layout.cardview_picture, getActivity());
        picturesRecycler.setAdapter(pictureAdapterRecyclerView);

        return view;
    }

        public ArrayList<Picture> buidPictures(){
            ArrayList<Picture> pictures = new ArrayList<>();
            pictures.add(new Picture("https://e.ad.amtv.pe/futbol-mundial-boca-juniors-se-corono-campeon-superliga-argentina-n321355-594x334-467066.jpg", "Grande Boca ", "4 días", "3 Me Gusta"));
            pictures.add(new Picture("@drawable/futbol_boca_juniors_campeon_superliga", "Mauricio P M", "3 días", "10 Me Gusta"));
            pictures.add(new Picture("https://www.eluniversal.com.mx/sites/default/files/styles/f03-651x400/public/2017/05/25/turismo_texas_tanques_de_guerra.jpg?itok=828JGGJH&c=4ebd31acd10680d863281f7912d6554c", "Martin M M", "2 días", "9 Me Gusta"));
            return pictures;
        }

        public void showToolbar(String tittle, boolean upButton, View view){
            Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
            ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(tittle);
            ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);

        }

    }