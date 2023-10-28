package com.ddm.petfood.ui;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ddm.petfood.R;
import com.ddm.petfood.adapter.PetAdapter;
import com.ddm.petfood.entity.Pet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HomeFragment extends Fragment {
    private Context context;

    private PetAdapter petAdapter;
    private List<Pet> pets;
    private Handler handler = new Handler();
    private PetAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        context = getContext();
        recyclerView = rootView.findViewById(R.id.recyclerView);

        pets = new ArrayList<>();
        // drawable/baseline_person_outline_24"
        for (int i = 0; i < 20; i++) {
            Pet pet = null;
            if (i % 2 == 0) {
                pet = new Pet("Beer " + i, "Gato", new Date(), R.drawable.baseline_person_outline_24);
                pet.setInfo("Gato muito fofo");
            }
            else {
                pet = new Pet("Ted " + i, "Cachorro", new Date(), R.drawable.outline_pets_24);
                pet.setInfo("Cachorro bricalhão");
            }

            pets.add(pet);
        }

        petAdapter = new PetAdapter(context, pets);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(petAdapter);

       return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}