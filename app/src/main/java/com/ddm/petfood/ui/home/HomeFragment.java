package com.ddm.petfood.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ddm.petfood.MainActivity;
import com.ddm.petfood.R;
import com.ddm.petfood.adapter.MealAdapter;
import com.ddm.petfood.adapter.PetAdapter;
import com.ddm.petfood.databinding.FragmentHomeBinding;
import com.ddm.petfood.entity.Pet;
import com.ddm.petfood.entity.Racao;
import com.ddm.petfood.repository.PetRepository;
import com.ddm.petfood.repository.RacaoRepository;
import com.ddm.petfood.ui.AddPetActivity;
import com.ddm.petfood.ui.meal.MealCadastro;
import com.ddm.petfood.ui.meal.MealViewModel;
import com.ddm.petfood.ui.meal.MealViewModelFactory;
import com.ddm.petfood.ui.pet.PetViewModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
                // call AddPetFragment
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