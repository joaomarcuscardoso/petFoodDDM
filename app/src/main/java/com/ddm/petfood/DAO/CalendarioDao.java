package com.ddm.petfood.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;

import com.ddm.petfood.entity.Calendario;

@Dao
public interface CalendarioDao {

    @Insert
    void insertAll(Calendario... calendarios);

    @Update
    void update(Calendario calendario);

    @Delete
    void delete(Calendario calendario);
}
