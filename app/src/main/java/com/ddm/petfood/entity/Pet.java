package com.ddm.petfood.entity;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.ddm.petfood.helper.DateConverter;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Pet implements Serializable, Parcelable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private int image;

    private String nome;
    private String raca;
    @TypeConverters(DateConverter.class)
    private Date dataAniversario;
    private String info;

    public Pet(String nome, String raca, Date dataAniversario, int image) {
        this.nome = nome;
        this.raca = raca;
        this.dataAniversario = dataAniversario;
        this.image = image;
    }

    protected Pet(Parcel in) {
        id = in.readInt();
        nome = in.readString();
        raca = in.readString();
        image = in.readInt();
        info = in.readString();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            dataAniversario = formatter.parse(in.readString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static final Creator<Pet> CREATOR = new Creator<Pet>() {
        @Override
        public Pet createFromParcel(Parcel in) {
            return new Pet(in);
        }

        @Override
        public Pet[] newArray(int size) {
            return new Pet[size];
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

    public int getImage() {
    return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(nome);
        parcel.writeString(raca);
        parcel.writeInt(image);
        parcel.writeString(info);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        parcel.writeString(formatter.format(dataAniversario));
    }
}
