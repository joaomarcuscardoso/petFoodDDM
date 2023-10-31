package com.ddm.petfood.ui.home;

import android.widget.Button;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ddm.petfood.R;
import com.ddm.petfood.entity.Pet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HomeViewModel extends ViewModel {
    private final MutableLiveData<List<Pet>> pets;

    public HomeViewModel() {
        this.pets = new MutableLiveData<List<Pet>>();
        this.pets.setValue(new ArrayList<>()); // Initialize the LiveData with an empty ArrayList
    }

    public LiveData<List<Pet>> getPets() {
        return pets;
    }

    public void addPet() {
        Pet pet = new Pet("Ted", "Ted é um cachorro muito legal", new Date(), R.drawable.outline_pets_24);

        List<Pet> petList = this.pets.getValue();
        petList.add(pet);
        this.pets.setValue(petList);
    }
}
