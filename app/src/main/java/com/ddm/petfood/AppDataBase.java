package com.ddm.petfood;

import android.content.SharedPreferences;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.ddm.petfood.DAO.PetDao;
import com.ddm.petfood.DAO.UsuarioDao;
import com.ddm.petfood.entity.Pet;
import com.ddm.petfood.entity.Usuario;

@Database(entities = {Usuario.class, Pet.class}, version = 1, exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {

    public abstract UsuarioDao usuarioDao();
    public abstract PetDao petDao();

}
