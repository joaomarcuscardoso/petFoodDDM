package com.ddm.petfood.ui.meal;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.ddm.petfood.repository.RacaoRepository;

public class MealViewModelFactory implements ViewModelProvider.Factory{

    private final RacaoRepository racaoRepository;

    public MealViewModelFactory(RacaoRepository racaoRepository){
        this.racaoRepository = racaoRepository;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MealViewModel.class)) {
            return (T) new MealViewModel(racaoRepository);
        }
        throw new IllegalArgumentException("Classe ViewModel desconhecida: " + modelClass.getName());
    }


}
