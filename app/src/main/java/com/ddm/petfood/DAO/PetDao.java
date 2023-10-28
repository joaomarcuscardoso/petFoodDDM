package com.ddm.petfood.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.ddm.petfood.entity.Pet;

import java.util.List;

@Dao
public interface PetDao {

    @Query("SELECT * FROM pet")
    List<Pet> getAll();

    @Query("SELECT * FROM Pet WHERE ID = :id")
    Pet getPet(int id);

    @Insert
    void insertAll(Pet... Pets);

    @Update
    void updatePet(Pet Pet);

    @Delete
    void deletePet(Pet Pet);
}
