package com.ddm.petfood.ui.home;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.ddm.petfood.repository.PetRepository;
import com.ddm.petfood.repository.RacaoRepository;
import com.ddm.petfood.ui.meal.MealViewModel;

public class HomeViewModelFactory implements ViewModelProvider.Factory {
    private PetRepository petRepository;
    public HomeViewModelFactory(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(HomeViewModel.class)) {
            return (T) new HomeViewModel(petRepository);
        }
        throw new IllegalArgumentException("Classe ViewModel desconhecida: " + modelClass.getName());
    }
}
