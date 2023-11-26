package com.ddm.petfood.ui.pet.add;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.ddm.petfood.DAO.PetDao;
import com.ddm.petfood.repository.PetRepository;
import com.ddm.petfood.ui.pet.add.AddPetViewModel;

public class AddPetViewModelFactory implements ViewModelProvider.Factory {
    private PetRepository petRepository;
    public AddPetViewModelFactory(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(AddPetViewModel.class)) {
            return (T) new AddPetViewModel(petRepository);
        }
        throw new IllegalArgumentException("Classe ViewModel desconhecida: " + modelClass.getName());
    }

}
