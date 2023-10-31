package com.ddm.petfood.ui.meal;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ddm.petfood.R;
import com.ddm.petfood.databinding.FragmentMealBinding;

public class MealFragment extends Fragment {

    private FragmentMealBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MealViewModel homeViewModel =
                new ViewModelProvider(this).get(MealViewModel.class);

        binding = FragmentMealBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textMeal;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}