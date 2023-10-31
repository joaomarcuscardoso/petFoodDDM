package com.ddm.petfood.ui.pet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.ddm.petfood.R;
import com.ddm.petfood.databinding.FragmentPetBinding;

public class PetFragment extends Fragment {

    private FragmentPetBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        PetViewModel petViewModel =
                new ViewModelProvider(this).get(PetViewModel.class);

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