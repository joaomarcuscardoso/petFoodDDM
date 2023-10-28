package com.ddm.petfood;

import android.content.SharedPreferences;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.ddm.petfood.DAO.CalendarioDao;
import com.ddm.petfood.DAO.CalendarioWithPetAndRacaoDao;
import com.ddm.petfood.DAO.PetDao;
import com.ddm.petfood.DAO.RacaoDao;
import com.ddm.petfood.DAO.UsuarioDao;
import com.ddm.petfood.entity.Calendario;
import com.ddm.petfood.entity.CalendarioWithPetAndRacao;
import com.ddm.petfood.entity.Pet;
import com.ddm.petfood.entity.Racao;
import com.ddm.petfood.entity.Usuario;

@Database(entities = {Usuario.class, Pet.class, Calendario.class, Racao.class}, version = 2, exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {

    public abstract UsuarioDao usuarioDao();
    public abstract PetDao petDao();

    public abstract RacaoDao racaoDao();

    public abstract CalendarioDao calendarioDao();

    public abstract CalendarioWithPetAndRacaoDao calendarioWithPetAndRacaoDao();

}
