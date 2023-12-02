package com.ddm.petfood.ui.meal;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ddm.petfood.entity.Pet;
import com.ddm.petfood.entity.Racao;
import com.ddm.petfood.repository.RacaoRepository;

import java.util.List;

public class MealViewModel extends ViewModel
{
    private MutableLiveData<List<Racao>> racaoLiveData;
    private RacaoRepository racaoRepository;

    public MealViewModel(RacaoRepository racaoRepository){
        this.racaoRepository = racaoRepository;
    }

    public void addNewRacao(String nome, String info){
        Racao newRacao = new Racao(nome, info);
        racaoRepository.salvarRacao(newRacao);
    }

    public LiveData<List<Racao>> getAllRacoes(){
        if(racaoLiveData == null)
            racaoLiveData = new MutableLiveData<>();
        loadAllRacoes();
        return racaoLiveData;
    }

    private void loadAllRacoes(){
        List<Racao> racoes = racaoRepository.getAllRacao();
        racaoLiveData.setValue(racoes);
    }

    public void removeRacao(Racao racao) {
        racaoRepository.excluirRacao(racao);
    }

    public void atualiarRacao(Racao racao) {
        System.out.println(racao.toString());
        racaoRepository.atualizarRacao(racao);
    }
}
