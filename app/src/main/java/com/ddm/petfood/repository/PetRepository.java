package com.ddm.petfood.repository;

import android.content.Context;
import android.database.sqlite.SQLiteConstraintException;

import androidx.room.Query;
import androidx.room.Room;

import com.ddm.petfood.AppDataBase;
import com.ddm.petfood.DAO.PetDao;
import com.ddm.petfood.entity.Pet;
import com.ddm.petfood.entity.Racao;

import java.util.List;

public class PetRepository implements PetDao {
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

    @Query("SELECT * FROM pet")
    public List<Pet> getAll() {
        List<Pet> pet = db.petDao().getAll();
        System.out.println("PET: " + pet);
        return pet;
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

    @Override
    public void insertAll(Pet... Pets) {

    }

    @Override
    public void updatePet(Pet Pet) {

    }

    @Override
    public void deletePet(Pet Pet) {

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
