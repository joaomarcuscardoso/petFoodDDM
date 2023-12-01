package com.ddm.petfood.ui.home;

import android.widget.Button;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ddm.petfood.R;
import com.ddm.petfood.entity.Pet;
import com.ddm.petfood.entity.Racao;
import com.ddm.petfood.repository.PetRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HomeViewModel extends ViewModel {
    private MutableLiveData<List<Pet>> pets;

    private PetRepository petRepository;

    public HomeViewModel(PetRepository petRepository) {
        this.petRepository = petRepository;
    }


    public LiveData<List<Pet>> getAllPets(){
        if(pets == null)
            pets = new MutableLiveData<>();
        loadAllPets();
        return pets;
    }

    private void loadAllPets(){
        List<Pet> petsDB = petRepository.getAll();
        pets.setValue(petsDB);
    }

    public void addPet(String name, String race, Date date, String info) {
        Pet pet = new Pet(name, race, date, R.drawable.outline_pets_24);
        pet.setInfo(info);
        petRepository.salvarPet(pet);
    }

    public void removePet(Pet pet) {
        petRepository.excluirPet(pet);
    }

    public void atualiarPet(Pet pet) {
        petRepository.updatePet(pet);
    }
}
