package com.ddm.petfood.repository;

import android.content.Context;
import android.database.sqlite.SQLiteConstraintException;

import androidx.room.Room;

import com.ddm.petfood.AppDataBase;
import com.ddm.petfood.entity.Usuario;

import java.util.List;

public class UsuarioRepository {

    private Context context;
    private AppDataBase db;

    public UsuarioRepository(Context context) {
        this.context = context;
        db = Room.databaseBuilder(context, AppDataBase.class, "AlarmPet.sqlite").allowMainThreadQueries().build();
    }

    public void excluirUsuario(Usuario usuario){
        try {
            db.usuarioDao().deleteUsuario(usuario);
        }
        catch (Exception e){
            return;
        }
    }

    public boolean salvarUsuario(Usuario usuario){
        try {
            db.usuarioDao().insertAll(usuario);
            return true;
        }
        catch (SQLiteConstraintException e){
            return false;
        }
    }

    public boolean atualizarUsuario(Usuario usuario){
        try {
            db.usuarioDao().updateUsuario(usuario);
            return true;
        }
        catch (SQLiteConstraintException e){
            return false;
        }
    }

    public Usuario getUsuario(int id){
        try {
            Usuario usuario = db.usuarioDao().getUsuario(id);
            return usuario;
        }
        catch (Exception e){
            return null;
        }
    }

    public List<Usuario> listaUsuarios(){
        try {
            List<Usuario> pessoas = db.usuarioDao().getAll();
            return pessoas;
        }
        catch (Exception e){
            return null;
        }
    }
}
