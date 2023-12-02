package com.ddm.petfood.entity;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Racao implements Serializable, Parcelable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String nome;

    private String info;

    public Racao(String nome, String info) {
        this.nome = nome;
        this.info = info;
    }

    protected Racao(Parcel in) {
        id = in.readInt();
        nome = in.readString();
        info = in.readString();
    }

    public static final Creator<Racao> CREATOR = new Creator<Racao>() {
        @Override
        public Racao createFromParcel(Parcel in) {
            return new Racao(in);
        }

        @Override
        public Racao[] newArray(int size) {
            return new Racao[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(nome);
        parcel.writeString(info);
    }
}
