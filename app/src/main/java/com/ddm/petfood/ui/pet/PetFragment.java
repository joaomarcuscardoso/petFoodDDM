package com.ddm.petfood.ui.pet;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.ddm.petfood.adapter.PetAdapter;
import com.ddm.petfood.databinding.FragmentPetBinding;
import com.ddm.petfood.entity.Pet;
import com.ddm.petfood.entity.Racao;
import com.ddm.petfood.repository.PetRepository;

import java.util.List;

public class PetFragment extends Fragment {

    private FragmentPetBinding binding;
    private PetViewModel petViewModel;

    private Context context;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        this.context = getContext();

        PetRepository petRepository = new PetRepository(getContext());

        petViewModel = new ViewModelProvider(this, new PetViewModelFactory(petRepository)).get(PetViewModel.class);

        binding = FragmentPetBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        PetAdapter petAdapter = new PetAdapter(context);


        petViewModel.listAllPets().observe(getViewLifecycleOwner(), new Observer<List<Pet>>() {
            @Override
            public void onChanged(List<Pet> pets) {

            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public static class PetViewModelFactory implements ViewModelProvider.Factory {
        private PetRepository petRepository;
        public PetViewModelFactory(PetRepository petRepository) {
            this.petRepository = petRepository;
        }

        @Override
        public <T extends ViewModel> T create(Class<T> modelClass) {
            if (modelClass.isAssignableFrom(PetViewModel.class)) {
                return (T) new PetViewModel(petRepository);
            }
            throw new IllegalArgumentException("Classe ViewModel desconhecida: " + modelClass.getName());
        }

    }
}