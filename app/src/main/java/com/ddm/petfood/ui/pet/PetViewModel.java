package com.ddm.petfood.ui.pet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.ddm.petfood.DAO.PetDao;
import com.ddm.petfood.entity.Pet;
import com.ddm.petfood.repository.PetRepository;

import java.util.List;

public class PetViewModel extends ViewModel {

    private final MutableLiveData<String> mText;
    private PetDao petDao;
    private MutableLiveData<List<Pet>> petsLiveData;

    public PetViewModel(PetDao petDao) {
        this.petDao = petDao;
        mText = new MutableLiveData<>();
        mText.setValue("This is pet fragment");
    }

    public LiveData<List<Pet>> listAllPets(){
        if (petsLiveData == null)
            petsLiveData = new MutableLiveData<>();
        loadAllPets();
        return petsLiveData;
    }

    public void loadAllPets(){
        List<Pet> pets = petDao.getAll();
        petsLiveData.setValue(pets);
    }

    public void insertPet(Pet pet){
        petDao.insertAll(pet);
        loadAllPets();
    }
}
