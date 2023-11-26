package com.ddm.petfood.ui.pet.add;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ddm.petfood.DAO.PetDao;
import com.ddm.petfood.entity.Pet;

import java.util.List;

public class AddPetViewModel extends ViewModel {

    private PetDao petDao;
    private MutableLiveData<List<Pet>> petsLiveData;

    public AddPetViewModel(PetDao petDao) {
        this.petDao = petDao;
    }

    public void insertPet(Pet pet){
        petDao.insertAll(pet);
    }
}