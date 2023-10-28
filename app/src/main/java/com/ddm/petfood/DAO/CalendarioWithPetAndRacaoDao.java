package com.ddm.petfood.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.ddm.petfood.entity.CalendarioWithPetAndRacao;

import java.util.List;

@Dao
public interface CalendarioWithPetAndRacaoDao {

    @Transaction
    @Query("SELECT * FROM Calendario")
    LiveData<List<CalendarioWithPetAndRacao>> getCalendariosWithPetAndRacao();

    @Transaction
    @Query("SELECT * FROM Calendario WHERE id = :id")
    LiveData<CalendarioWithPetAndRacao> getCalendarioWithPetAndRacaoById(int id);

}
