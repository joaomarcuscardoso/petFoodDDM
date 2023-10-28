package com.ddm.petfood.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.room.Room;

import com.ddm.petfood.AppDataBase;
import com.ddm.petfood.entity.Calendario;
import com.ddm.petfood.entity.CalendarioWithPetAndRacao;

import java.util.List;

public class CalendarioRepository {
    private Context context;
    private AppDataBase db;

    public CalendarioRepository(Context context){
        this.context = context;
        db = Room.databaseBuilder(context, AppDataBase.class, "AlarmPet.sqlite").allowMainThreadQueries().build();
    }

    public void excluirCalendario(Calendario calendario){
        try {
           db.calendarioDao().delete(calendario);
        }catch (Exception e){
            return;
        }
    }

    public boolean salvarCalendario(Calendario calendario){
        try {
            db.calendarioDao().insertAll(calendario);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean atualizarCalendario(Calendario calendario){
        try {
            db.calendarioDao().update(calendario);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public LiveData<List<CalendarioWithPetAndRacao>> ListarCalendarioWithPetAndRacao(){
        return db.calendarioWithPetAndRacaoDao().getCalendariosWithPetAndRacao();
    }

    public LiveData<CalendarioWithPetAndRacao> getCalendarioWithPetAndRacao(int id){
        return db.calendarioWithPetAndRacaoDao().getCalendarioWithPetAndRacaoById(id);
    }

}
