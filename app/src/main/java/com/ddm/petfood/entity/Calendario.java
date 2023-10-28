package com.ddm.petfood.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.sql.Date;

@Entity(foreignKeys = {@ForeignKey(entity = Pet.class, parentColumns = "id", childColumns = "pet_id"), @ForeignKey(entity = Racao.class, parentColumns = "id", childColumns = "racao_id")})
public class Calendario {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String titulo;

    private Date time;

    @ColumnInfo(name = "pet_id")
    private Pet petId;

    @ColumnInfo(name = "racao_id")
    private Racao racaoId;

    public Calendario(String titulo, Date time, Pet petId, Racao racaoId) {
        this.titulo = titulo;
        this.time = time;
        this.petId = petId;
        this.racaoId = racaoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Pet getPetId() {
        return petId;
    }

    public void setPetId(Pet petId) {
        this.petId = petId;
    }

    public Racao getRacaoId() {
        return racaoId;
    }

    public void setRacaoId(Racao racaoId) {
        this.racaoId = racaoId;
    }

    @Override
    public String toString() {
        return "Calendario{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", time=" + time +
                ", petId=" + petId +
                ", racaoId=" + racaoId +
                '}';
    }
}
