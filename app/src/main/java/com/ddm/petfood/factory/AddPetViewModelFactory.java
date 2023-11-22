package com.ddm.petfood.factory;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.ddm.petfood.DAO.PetDao;
import com.ddm.petfood.ui.pet.add.AddPetViewModel;

public class AddPetViewModelFactory implements ViewModelProvider.Factory {
    private PetDao petDao;
    public AddPetViewModelFactory(PetDao petDao) {
        this.petDao = petDao;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(AddPetViewModel.class)) {
            return (T) new AddPetViewModel(petDao);
        }
        throw new IllegalArgumentException("Classe ViewModel desconhecida: " + modelClass.getName());
    }

}
