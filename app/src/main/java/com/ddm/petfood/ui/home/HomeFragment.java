package com.ddm.petfood.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ddm.petfood.R;
import com.ddm.petfood.adapter.PetAdapter;
import com.ddm.petfood.databinding.FragmentHomeBinding;
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

    private FragmentHomeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        recyclerView = root.findViewById(R.id.recyclerView);

        // Set the layout manager (e.g., LinearLayoutManager)
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext())); // Set a LinearLayoutManager

        homeViewModel.getPets().observe(getViewLifecycleOwner(), pets -> {
            adapter = new PetAdapter(getContext(), pets);
            recyclerView.setAdapter(adapter);
        });

        Button btnAdd = root.findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeViewModel.addPet();
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}