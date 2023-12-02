package com.ddm.petfood.ui.calendar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ddm.petfood.R;
import com.ddm.petfood.adapter.CalendarioAdapter;
import com.ddm.petfood.databinding.FragmentCalendarBinding;
import com.ddm.petfood.entity.CalendarioWithPetAndRacao;
import com.ddm.petfood.entity.Pet;
import com.ddm.petfood.entity.Racao;
import com.ddm.petfood.repository.CalendarioRepository;
import com.ddm.petfood.ui.calendar.CalendarViewModel;

import java.util.List;

public class CalendarFragment extends Fragment {

    private Context context;

    private CalendarioAdapter calendarioAdapter;

    private Handler handler = new Handler();

    private RecyclerView recyclerView;

    private FragmentCalendarBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        this.context = getContext();

        CalendarioRepository calendarioRepository = new CalendarioRepository(context);

        CalendarViewModel calendarViewModel =
                new ViewModelProvider(this, new CalendarViewModelFactory(calendarioRepository)).get(CalendarViewModel.class);

        binding = FragmentCalendarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Spinner spPet = root.findViewById(R.id.spinner_pet);
        Spinner spRacao = root.findViewById(R.id.spinner_racao);

        calendarViewModel.getOpcoesSpinnerPet(context).observe(getViewLifecycleOwner(), opcoes -> {
            ArrayAdapter<Pet> adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, opcoes);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spPet.setAdapter(adapter);
        });

        calendarViewModel.getOpcoesSpinnerRacao(context).observe(getViewLifecycleOwner(), opcoes -> {
            ArrayAdapter<Racao> adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, opcoes);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spRacao.setAdapter(adapter);
        });

        recyclerView = root.findViewById(R.id.recycler_calendar);
        calendarioAdapter = new CalendarioAdapter(context);
        recyclerView.setAdapter(calendarioAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        calendarViewModel.getAllCalendarios().observe(getViewLifecycleOwner(), new Observer<List<CalendarioWithPetAndRacao>>() {
            @Override
            public void onChanged(List<CalendarioWithPetAndRacao> calendarioWithPetAndRacaos) {
                calendarioAdapter.setCalendarios(calendarioWithPetAndRacaos);
            }
        });

        Button btnAdd = root.findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), CalendarCadastro.class);
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