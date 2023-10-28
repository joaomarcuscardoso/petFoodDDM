package com.ddm.petfood.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.room.Room;

import com.ddm.petfood.AppDataBase;
import com.ddm.petfood.entity.Racao;

import java.util.List;

public class RacaoRepository {

    private Context context;
    private AppDataBase db;

    public RacaoRepository(Context context){
        this.context = context;
        db = Room.databaseBuilder(context, AppDataBase.class, "AlarmPet.sqlite").allowMainThreadQueries().build();
    }

    public void excluirRacao(Racao racao){
        try {
            db.racaoDao().deleteRacao(racao);
        }catch (Exception e){
            return;
        }
    }

    public boolean salvarRacao(Racao racao){
        try {
            db.racaoDao().insetAll(racao);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean atualizarRacao(Racao racao){
        try {
            db.racaoDao().updateRacao(racao);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public LiveData<Racao> getRacao(int id){
        return db.racaoDao().getRacaoLiveData(id);
    }

    public LiveData<List<Racao>> listarRacao(){
        return db.racaoDao().getAllLiveData();
    }
}
