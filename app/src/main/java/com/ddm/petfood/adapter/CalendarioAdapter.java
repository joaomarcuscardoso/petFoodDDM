package com.ddm.petfood.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ddm.petfood.R;
import com.ddm.petfood.entity.CalendarioWithPetAndRacao;

import java.util.List;

public class CalendarioAdapter extends RecyclerView.Adapter<CalendarioAdapter.ViewHolder> {

    private Context context;

    private List<CalendarioWithPetAndRacao> calendarios;

    public CalendarioAdapter(Context context){
        this.context = context;
    }

    public List<CalendarioWithPetAndRacao> getCalendarios(){
        return calendarios;
    }

    public void setCalendarios(List<CalendarioWithPetAndRacao> calendarios) {
        this.calendarios = calendarios;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView pet;
        public TextView racao;
        public TextView horario;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pet = itemView.findViewById(R.id.textPet);
            racao = itemView.findViewById(R.id.textRacao);
            horario = itemView.findViewById(R.id.dateCalendar);
        }
    }
    @NonNull
    @Override
    public CalendarioAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.calendar_card, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CalendarioAdapter.ViewHolder holder, int position) {
        CalendarioWithPetAndRacao calendario = calendarios.get(position);
        holder.pet.setText(calendario.getPet().getNome());
        holder.racao.setText(calendario.getRacao().getNome());
        holder.horario.setText(calendario.getCalendario().getTime().toString());
    }

    @Override
    public int getItemCount() {
        return calendarios.size();
    }
}
