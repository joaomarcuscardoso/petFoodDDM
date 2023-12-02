package com.ddm.petfood.ui.calendar;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ddm.petfood.entity.CalendarioWithPetAndRacao;
import com.ddm.petfood.entity.Pet;
import com.ddm.petfood.entity.Racao;
import com.ddm.petfood.repository.CalendarioRepository;
import com.ddm.petfood.repository.PetRepository;
import com.ddm.petfood.repository.RacaoRepository;

import java.util.Date;
import java.util.List;

public class CalendarViewModel extends ViewModel {

    private CalendarioRepository calendarioRepository;

    private MutableLiveData<List<CalendarioWithPetAndRacao>> calendarioLiveData;

    private MutableLiveData<List<Pet>> spinnerPet = new MutableLiveData<>();

    private MutableLiveData<List<Racao>> spinnerRacao = new MutableLiveData<>();

    private PetRepository petRepository;

    private RacaoRepository racaoRepository;

    public CalendarViewModel(CalendarioRepository calendarioRepository) {
        this.calendarioRepository = calendarioRepository;
    }

    public LiveData<List<Pet>> getOpcoesSpinnerPet(Context context){
        if(petRepository == null){
            petRepository = new PetRepository(context);
        }

        List<Pet> opcoes = petRepository.getAll();

        spinnerPet.setValue(opcoes);

        return spinnerPet;
    }

    public LiveData<List<Racao>> getOpcoesSpinnerRacao(Context context){
        if(racaoRepository == null){
            racaoRepository = new RacaoRepository(context);
        }

        List<Racao> opcoes = racaoRepository.getAllRacao();

        spinnerRacao.setValue(opcoes);

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

    public void addCalendario(Pet pet, Racao racao, Date date){

    }

}
