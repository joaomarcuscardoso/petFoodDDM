package com.ddm.petfood.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.ddm.petfood.entity.Racao;

import java.util.List;

@Dao
public interface RacaoDao {

    @Query("SELECT * FROM racao")
    List<Racao> getAllRacao();

    @Query("SELECT * FROM racao WHERE id = :id")
    Racao getRacao(int id);

    @Insert
    void insetAll(Racao... racaos);

    @Update
    void updateRacao(Racao racao);

    @Delete
    void deleteRacao(Racao racao);
}
