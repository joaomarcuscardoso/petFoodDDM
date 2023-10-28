package com.ddm.petfood.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Racao {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String nome;

    private String info;

    public Racao(String nome, String info) {
        this.nome = nome;
        this.info = info;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Racao{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
