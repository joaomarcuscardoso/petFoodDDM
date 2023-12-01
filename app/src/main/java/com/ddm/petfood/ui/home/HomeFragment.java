package com.ddm.petfood.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SearchView;

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

    public static HomeViewModel homeViewModel;

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

        homeViewModel.getAllPets().observe(getViewLifecycleOwner(), petsRepo -> {
            adapter.setPets(petsRepo);
            adapter.notifyDataSetChanged();
        });

        Button btnAdd = root.findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AddPetActivity.class);
                startActivity(intent);
            }
        });

        SearchView searchView = root.findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            // Called when the user submits the query (e.g., by pressing the search button on the keyboard)
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (query.isEmpty()) {
                    homeViewModel.getAllPets().observe(getViewLifecycleOwner(), petsRepo -> {
                        adapter.setPets(petsRepo);
                        adapter.notifyDataSetChanged();
                    });
                } else {
                    homeViewModel.searchPets(query);
                    adapter.notifyDataSetChanged();
                }
                return true;
            }

            // Called when the query text is changed by the user
            @Override
            public boolean onQueryTextChange(String query) {
                if (query.isEmpty()) {
                    homeViewModel.getAllPets().observe(getViewLifecycleOwner(), petsRepo -> {
                        adapter.setPets(petsRepo);
                        adapter.notifyDataSetChanged();
                    });
                } else {
                    homeViewModel.searchPets(query);
                    adapter.notifyDataSetChanged();

                }
                return true;
            }
        });

        return root;
    }
}