package com.ddm.petfood.ui.pet.add;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ddm.petfood.DAO.PetDao;
import com.ddm.petfood.entity.Pet;
import com.ddm.petfood.repository.PetRepository;

import java.util.List;

public class AddPetViewModel extends ViewModel {

    private PetRepository petRepository;
    private MutableLiveData<List<Pet>> petsLiveData;

    public AddPetViewModel(PetRepository petRepo) {
        this.petRepository = petRepo;
    }

    public void insertPet(Pet pet){
        petRepository.insertAll(pet);
    }
}