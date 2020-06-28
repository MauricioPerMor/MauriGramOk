package com.example.maurigram.post.view;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.maurigram.R;
import com.example.maurigram.adapter.PictureAdapterRecyclerView;
import com.example.maurigram.model.Picture;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.crash.FirebaseCrash;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/*
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private static final int REQUEST_CAMERA = 1;
    private com.google.android.material.floatingactionbutton.FloatingActionButton fabCamera;
    private String photoPathTemp ="";



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        showToolbar("Inicio", false, view);
        RecyclerView picturesRecycler = (RecyclerView) view.findViewById(R.id.pictureRecycler);
fabCamera = (FloatingActionButton) view.findViewById(R.id.fabCamera);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation((LinearLayoutManager.VERTICAL));

        picturesRecycler.setLayoutManager(linearLayoutManager);

        PictureAdapterRecyclerView pictureAdapterRecyclerView =
                new PictureAdapterRecyclerView(buildPictures(), R.layout.cardview_picture, getActivity());
        picturesRecycler.setAdapter(pictureAdapterRecyclerView);

fabCamera.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
     takePicture();
    }
});

        return view;
    }

    private void takePicture() {
        Intent intentTakePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intentTakePicture.resolveActivity(getActivity().getPackageManager()) !=null) {
File photoFile = null;
try{
photoFile = createImageFile();

}
catch (Exception e){
    e.printStackTrace();
    FirebaseCrash.report(e);
}
if (photoFile!=null){
    Uri photoUri = FileProvider.getUriForFile(getActivity(),"com.example.maurigram",photoFile);
    intentTakePicture.putExtra(MediaStore.EXTRA_OUTPUT,photoUri);
    startActivityForResult(intentTakePicture,REQUEST_CAMERA);

}



        }

    }

    private File createImageFile() throws IOException {
String timeStamp = new SimpleDateFormat("yyyyMMdd_HH-mm-ss").format(new Date());
String imageFilename = "JPEG" + timeStamp+ "_";
File storageDir = getActivity().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
File photo = File.createTempFile(imageFilename,".jpg", storageDir);
photoPathTemp = "file:"+photo.getAbsolutePath();


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
if (requestCode == REQUEST_CAMERA && resultCode == getActivity().RESULT_OK){
 Log.d("HomeFragment", "Camera OK!! ,)");
 Intent i= new Intent(getActivity(),NewPostActivity.class);
 i.putExtra("PHOTO_PATH_TEMP", photoPathTemp);
 startActivity(i);


}
    }

    public ArrayList<Picture> buildPictures(){
        ArrayList<Picture> pictures = new ArrayList<>();
        pictures.add(new Picture("https://e.ad.amtv.pe/futbol-mundial-boca-juniors-se-corono-campeon-superliga-argentina-n321355-594x334-467066.jpg", "Boca Forever", "4 días", "3 Me Gusta"));
        pictures.add(new Picture("@drawable/futbol_boca_juniors_campeon_superliga", "Mauricio Perez M", "3 días", "10 Me Gusta"));
        pictures.add(new Picture("https://www.eluniversal.com.mx/sites/default/files/styles/f03-651x400/public/2017/05/25/turismo_texas_tanques_de_guerra.jpg?itok=828JGGJH&c=4ebd31acd10680d863281f7912d6554c", "Martin MM", "2 días", "9 Me Gusta"));

        return pictures;
    }


    public void showToolbar(String tittle, boolean upButton, View view){
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(tittle);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);


    }


}
