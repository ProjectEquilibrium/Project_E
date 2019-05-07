package com.example.asus.equilibrium;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class ExerciseFragment extends Fragment {
    ImageButton imageButton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_exercise, container, false);
        imageButton = (ImageButton)view.findViewById(R.id.ChestButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new Youtubevideos();
                FragmentTransaction transaction=getFragmentManager().beginTransaction();
                transaction.replace(R.id.screen_area, fragment);
                transaction.commit();
            }
        });

        imageButton = (ImageButton)view.findViewById(R.id.ShoulderButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new Youtubevideos();
                FragmentTransaction transaction=getFragmentManager().beginTransaction();
                transaction.replace(R.id.screen_area, fragment);
                transaction.commit();
            }
        });
        imageButton = (ImageButton)view.findViewById(R.id.LegsButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new Youtubevideos();
                FragmentTransaction transaction=getFragmentManager().beginTransaction();
                transaction.replace(R.id.screen_area, fragment);
                transaction.commit();
            }
        });
        imageButton = (ImageButton)view.findViewById(R.id.ArmsButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new Youtubevideos();
                FragmentTransaction transaction=getFragmentManager().beginTransaction();
                transaction.replace(R.id.screen_area, fragment);
                transaction.commit();
            }
        });
        imageButton = (ImageButton)view.findViewById(R.id.BackButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new Youtubevideos();
                FragmentTransaction transaction=getFragmentManager().beginTransaction();
                transaction.replace(R.id.screen_area, fragment);
                transaction.commit();
            }
        });
        return view;
    }
}
