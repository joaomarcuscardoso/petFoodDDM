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

public class MealAdapter extends RecyclerView.Adapter<MealAdapter.ViewHolder>
{

    private Context context;
    private List<Racao> meals;

    public MealAdapter(Context context,List<Racao> meals){
        this.context = context;
        this.meals = meals;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtNome;
        TextView txtInfo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNome = itemView.findViewById(R.id.nome_meal);
            txtInfo = itemView.findViewById(R.id.info_meal);
        }
    }

    @NonNull
    @Override
    public MealAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.meal_card, parent, false);

        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Racao meal = meals.get(position);
        holder.txtNome.setText(meal.getNome());
        holder.txtInfo.setText(meal.getInfo());
    }

    @Override
    public int getItemCount() {
        return meals.size();
    }
}
