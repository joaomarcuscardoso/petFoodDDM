package com.ddm.petfood.ui.meal;

import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.ddm.petfood.R;
import com.ddm.petfood.adapter.MealAdapter;
import com.ddm.petfood.databinding.FragmentMealBinding;
import com.ddm.petfood.entity.Racao;

import java.util.List;

public class MealFragment extends Fragment {

    private Context context;

    private MealAdapter mealAdapter;

    private List<Racao> meals;

    private Handler handler = new Handler();

    private RecyclerView recyclerView;

    private FragmentMealBinding binding;

    public MealFragment(){

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        context = getContext();
        MealViewModel mealViewModel =
                new ViewModelProvider(this, (ViewModelProvider.Factory) context).get(MealViewModel.class);

        binding = FragmentMealBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        recyclerView = root.findViewById(R.id.recycler_meal);

        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        mealViewModel.getMeals().observe(getViewLifecycleOwner(), meals ->{
            mealAdapter = new MealAdapter(context, meals);
            recyclerView.setAdapter(mealAdapter);
        });

        Button btnAdd = root.findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mealViewModel.addMeal();
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