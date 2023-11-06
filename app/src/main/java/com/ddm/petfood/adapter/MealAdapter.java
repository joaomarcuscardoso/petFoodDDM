package com.ddm.petfood.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ddm.petfood.R;
import com.ddm.petfood.entity.Racao;

import java.util.List;

public class MealAdapter extends RecyclerView.Adapter<MealAdapter.ViewHolder>{

    private List<Racao> meals;
    private Context context;

    public MealAdapter(Context context, List<Racao> meals){
        this.context = context;
        this.meals = meals;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView nome;
        public TextView info;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.nome_meal);
            info = itemView.findViewById(R.id.info_meal);
        }
    }
    @NonNull
    @Override
    public MealAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.meal_card, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MealAdapter.ViewHolder holder, int position) {
        Racao meal = meals.get(position);
        holder.nome.setText(meal.getNome());
        holder.info.setText(meal.getInfo());
    }

    @Override
    public int getItemCount() {
        return meals.size();
    }
}
