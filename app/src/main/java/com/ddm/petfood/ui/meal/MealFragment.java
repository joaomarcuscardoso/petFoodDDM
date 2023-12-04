package com.ddm.petfood.ui.meal;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ddm.petfood.R;
import com.ddm.petfood.adapter.MealAdapter;
import com.ddm.petfood.databinding.FragmentMealBinding;
import com.ddm.petfood.entity.Racao;
import com.ddm.petfood.repository.RacaoRepository;

import java.util.List;

public class MealFragment extends Fragment {

    private Context context;

    private MealAdapter mealAdapter;

    private Handler handler = new Handler();

    private RecyclerView recyclerView;

    private FragmentMealBinding binding;

    public static MealViewModel mealViewModel;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.context = getContext();

        RacaoRepository racaoRepository = new RacaoRepository(context);
        mealViewModel = new ViewModelProvider(this, new MealViewModelFactory(racaoRepository)).get(MealViewModel.class);

        binding = FragmentMealBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        recyclerView = root.findViewById(R.id.recycler_meal);
        mealAdapter = new MealAdapter(context);
        recyclerView.setAdapter(mealAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        mealViewModel.getAllRacoes().observe(getViewLifecycleOwner(), new Observer<List<Racao>>() {
            @Override
            public void onChanged(List<Racao> racaos) {
                mealAdapter.setMeals(racaos);
            }
        });


        Button btnAdd = root.findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MealCadastro.class);
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