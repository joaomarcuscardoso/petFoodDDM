package com.ddm.petfood.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.ddm.petfood.helper.DateConverter;

import java.util.Date;

@Entity(foreignKeys = {
        @ForeignKey(entity = Pet.class, parentColumns = "id", childColumns = "pet_id"),
        @ForeignKey(entity = Racao.class, parentColumns = "id", childColumns = "racao_id")})
public class Calendario {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String titulo;

    @TypeConverters(DateConverter.class)
    private Date time;

    @ColumnInfo(name = "pet_id")
    private long petId;

    @ColumnInfo(name = "racao_id")
    private long racaoId;

    public Calendario(String titulo, Date time, long petId, long racaoId) {
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

    public long getPetId() {
        return petId;
    }

    public void setPetId(long petId) {
        this.petId = petId;
    }

    public long getRacaoId() {
        return racaoId;
    }

    public void setRacaoId(long racaoId) {
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
