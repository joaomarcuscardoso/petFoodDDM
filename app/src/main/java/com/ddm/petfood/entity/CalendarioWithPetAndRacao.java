package com.ddm.petfood.entity;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Relation;

public class CalendarioWithPetAndRacao {

    @Embedded
    private Calendario calendario;

    @Relation(parentColumn = "pet_id", entityColumn = "id")
    private Pet pet;

    @Relation(parentColumn = "racao_id", entityColumn = "id")
    private Racao racao;

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
