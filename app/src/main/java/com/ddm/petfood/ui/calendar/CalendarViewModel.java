package com.ddm.petfood.ui.calendar;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ddm.petfood.entity.Calendario;
import com.ddm.petfood.entity.CalendarioWithPetAndRacao;
import com.ddm.petfood.entity.Pet;
import com.ddm.petfood.entity.Racao;
import com.ddm.petfood.repository.CalendarioRepository;
import com.ddm.petfood.repository.PetRepository;
import com.ddm.petfood.repository.RacaoRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CalendarViewModel extends ViewModel {

    private CalendarioRepository calendarioRepository;

    private MutableLiveData<List<CalendarioWithPetAndRacao>> calendarioLiveData;

    private List<Pet> spinnerPet = new ArrayList<>();

    private List<Racao> spinnerRacao = new ArrayList<>();

    private PetRepository petRepository;

    private RacaoRepository racaoRepository;

    public CalendarViewModel(CalendarioRepository calendarioRepository) {
        this.calendarioRepository = calendarioRepository;
    }

    public List<Pet> getOpcoesSpinnerPet(Context context){
        if(petRepository == null){
            petRepository = new PetRepository(context);
        }

        spinnerPet = petRepository.getAll();

        return spinnerPet;
    }

    public List<Racao> getOpcoesSpinnerRacao(Context context){
        if(racaoRepository == null){
            racaoRepository = new RacaoRepository(context);
        }

        spinnerRacao = racaoRepository.getAllRacao();

        return spinnerRacao;
    }

    public LiveData<List<CalendarioWithPetAndRacao>> getAllCalendarios(){
        if(calendarioLiveData == null)
            calendarioLiveData = new MutableLiveData<List<CalendarioWithPetAndRacao>>();
        loadAllCalendarios();
        return calendarioLiveData;
    }

    private void loadAllCalendarios(){
        List<CalendarioWithPetAndRacao> calendarios = calendarioRepository.ListarCalendarioWithPetAndRacao();
        calendarioLiveData.setValue(calendarios);

    }

    public void addCalendario(long petId, long racaoId, Date date){
        Calendario newCalendario = new Calendario(date, petId, racaoId);
        calendarioRepository.salvarCalendario(newCalendario);
    }

}
