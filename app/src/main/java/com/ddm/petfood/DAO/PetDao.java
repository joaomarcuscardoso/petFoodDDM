package com.ddm.petfood.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.ddm.petfood.entity.Pet;
import com.ddm.petfood.entity.Racao;

import java.util.List;

@Dao
public interface PetDao {

    @Query("SELECT * FROM pet")
    List<Pet> getAll();

    @Query("SELECT * FROM pet WHERE ID = :id")
    Pet getPet(int id);

    @Query("SELECT * FROM pet WHERE nome LIKE :nome")
    List<Pet> searchPets(String nome);

    @Insert
    void insertAll(Pet... Pets);

    @Update
    void updatePet(Pet Pet);

    @Delete
    void deletePet(Pet Pet);
}
