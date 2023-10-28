package com.ddm.petfood.repository;

import android.content.Context;
import android.database.sqlite.SQLiteConstraintException;

import androidx.room.Room;

import com.ddm.petfood.AppDataBase;
import com.ddm.petfood.entity.Pet;

import java.util.List;

public class PetRepository {
    private Context context;
    private AppDataBase db;

    public PetRepository(Context context) {
        this.context = context;
        db = Room.databaseBuilder(context, AppDataBase.class, "AlarmPet.sqlite").allowMainThreadQueries().build();
    }

    public void excluirPet(Pet pet){
        try {
            db.petDao().deletePet(pet);
        }catch (Exception e){
            return;
        }
    }

    public boolean salvarPet(Pet Pet){
        try {
            db.petDao().insertAll(Pet);
            return true;
        }
        catch (SQLiteConstraintException e){
            return false;
        }
    }

    public boolean atualizarPet(Pet Pet){
        try {
            db.petDao().updatePet(Pet);
            return true;
        }
        catch (SQLiteConstraintException e){
            return false;
        }
    }

    public Pet getPet(int id){
        try {
            Pet Pet = db.petDao().getPet(id);
            return Pet;
        }
        catch (Exception e){
            return null;
        }
    }

    public List<Pet> listarPets(){
        try {
            List<Pet> Pets = db.petDao().getAll();
            return Pets;
        }
        catch (Exception e){
            return null;
        }
    }
}
