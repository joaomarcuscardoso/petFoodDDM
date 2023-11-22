package com.ddm.petfood.ui.pet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.ddm.petfood.DAO.PetDao;
import com.ddm.petfood.databinding.FragmentPetBinding;
import com.ddm.petfood.factory.PetViewModelFactory;
import com.ddm.petfood.repository.PetRepository;

public class PetFragment extends Fragment {

    private FragmentPetBinding binding;
    private PetViewModel petViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        PetDao petDao = new PetRepository(getContext());

        petViewModel = new ViewModelProvider(this, new PetViewModelFactory(petDao)).get(PetViewModel.class);

        binding = FragmentPetBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textPet;
        petViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}