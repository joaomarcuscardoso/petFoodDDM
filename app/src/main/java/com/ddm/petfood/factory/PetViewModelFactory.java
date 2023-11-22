package com.ddm.petfood.factory;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.ddm.petfood.DAO.PetDao;
import com.ddm.petfood.ui.pet.PetViewModel;

public class PetViewModelFactory implements ViewModelProvider.Factory {
    private PetDao petDao;
    public PetViewModelFactory(PetDao petDao) {
        this.petDao = petDao;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(PetViewModel.class)) {
            return (T) new PetViewModel(petDao);
        }
        throw new IllegalArgumentException("Classe ViewModel desconhecida: " + modelClass.getName());
    }

}
