package com.ddm.petfood.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.ddm.petfood.helper.DateConverter;

import java.util.Date;

@Entity
public class Pet {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String nome;
    private String raca;
    @TypeConverters(DateConverter.class)
    private Date dataAniversario;
    private String info;

    public Pet(int id, String nome, String raca, Date dataAniversario, String info) {
        this.id = id;
        this.nome = nome;
        this.raca = raca;
        this.dataAniversario = dataAniversario;
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

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Date getDataAniversario() {
        return dataAniversario;
    }

    public void setDataAniversario(Date dataAniversario) {
        this.dataAniversario = dataAniversario;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "nome='" + nome + '\'' +
                ", raca='" + raca + '\'' +
                ", dataAniversario=" + dataAniversario +
                ", info='" + info + '\'' +
                '}';
    }
}
