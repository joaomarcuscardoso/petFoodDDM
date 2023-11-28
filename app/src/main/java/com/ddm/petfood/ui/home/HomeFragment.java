package com.ddm.petfood.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ddm.petfood.R;
import com.ddm.petfood.adapter.PetAdapter;
import com.ddm.petfood.databinding.FragmentHomeBinding;
import com.ddm.petfood.repository.PetRepository;
import com.ddm.petfood.ui.pet.AddPetActivity;

public class HomeFragment extends Fragment {
    private Context context;
    private PetAdapter adapter;
    private RecyclerView recyclerView;

    private FragmentHomeBinding binding;

    private HomeViewModel homeViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.context = getContext();

        PetRepository petRepository = new PetRepository(context);

        homeViewModel = new ViewModelProvider(this, new HomeViewModelFactory(petRepository)).get(HomeViewModel.class);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        recyclerView = root.findViewById(R.id.recyclerView);
        adapter = new PetAdapter(getContext());
        recyclerView.setAdapter(adapter);

        // Set the layout manager (e.g., LinearLayoutManager)
        recyclerView.setLayoutManager(new LinearLayoutManager(context)); // Set a LinearLayoutManager

        homeViewModel.getAllPets().observe(getViewLifecycleOwner(), pets -> {
            adapter.setPets(pets);
        });

        Button btnAdd = root.findViewById(R.id.btnAdd);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AddPetActivity.class);
                startActivity(intent);
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}