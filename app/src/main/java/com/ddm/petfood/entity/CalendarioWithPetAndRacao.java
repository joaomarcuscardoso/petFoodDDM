package com.ddm.petfood.entity;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Relation;
import androidx.room.TypeConverters;

import com.ddm.petfood.entity.Calendario;
import com.ddm.petfood.entity.Racao;
import com.ddm.petfood.entity.Pet;
import com.ddm.petfood.helper.DateConverter;

@TypeConverters(DateConverter.class)
public class CalendarioWithPetAndRacao {

    @Embedded
    public Calendario calendario;

    @Relation(parentColumn = "pet_id", entityColumn = "id")
    public Pet pet;

    @Relation(parentColumn = "racao_id", entityColumn = "id")
    public Racao racao;

    public CalendarioWithPetAndRacao(){

    }

    public CalendarioWithPetAndRacao(Calendario calendario, Pet pet, Racao racao) {
        this.calendario = calendario;
        this.pet = pet;
        this.racao = racao;
    }

    public Calendario getCalendario() {
        return calendario;
    }

    public Pet getPet() {
        return pet;
    }

    public Racao getRacao() {
        return racao;
    }

    @Override
    public String toString() {
        return "CalendarioWithPetAndRacao{" +
                "calendario=" + calendario +
                ", pet=" + pet +
                ", racao=" + racao +
                '}';
    }
}
