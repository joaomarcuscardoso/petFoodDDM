package com.ddm.petfood.ui.calendar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.ddm.petfood.R;
import com.ddm.petfood.entity.Pet;
import com.ddm.petfood.entity.Racao;
import com.ddm.petfood.repository.CalendarioRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CalendarCadastro extends AppCompatActivity {

    private Spinner spinnerPet;
    private Spinner spinnerRacao;
    private EditText editTextHorario;

    private CalendarViewModel calendarViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_cadastro);

        CalendarioRepository calendarioRepository = new CalendarioRepository(this);

        calendarViewModel = new ViewModelProvider(this, new CalendarViewModelFactory(calendarioRepository)).get(CalendarViewModel.class);

        spinnerPet = findViewById(R.id.spinner_pet);
        spinnerRacao = findViewById(R.id.spinner_racao);

        ArrayAdapter<Pet> adapterPet = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,
                calendarViewModel.getOpcoesSpinnerPet(this));

        spinnerPet.setAdapter(adapterPet);

        ArrayAdapter<Racao> adapterRacao = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,
                calendarViewModel.getOpcoesSpinnerRacao(this));

        spinnerRacao.setAdapter(adapterRacao);
        
        editTextHorario = findViewById(R.id.edDate);
        Button btnSalvar = findViewById(R.id.btnSalvar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pet pet = (Pet) spinnerPet.getSelectedItem();
                Racao racao = (Racao) spinnerRacao.getSelectedItem();

                if(pet == null){
                    Toast.makeText(CalendarCadastro.this,"Não foi informado um pet!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(racao == null){
                    Toast.makeText(CalendarCadastro.this, "Não foi informado uma Ração!", Toast.LENGTH_SHORT).show();
                    return;
                }
                try {
                    SimpleDateFormat format = new SimpleDateFormat("hh:mm");
                    Date date = format.parse(editTextHorario.getText().toString());
                    //falta terminar o metodo de addCalendario
                    // calendarViewModel.addCalendario();
                } catch (ParseException e){
                    Toast.makeText(CalendarCadastro.this, "Data Inválida!", Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(CalendarCadastro.this, "Horario adicionado com sucesso!", Toast.LENGTH_SHORT).show();

                replaceFragment(new CalendarFragment());
            }

        });
        setTitle("add Horario");
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame_layout, fragment);
        transaction.commit();
    }
}