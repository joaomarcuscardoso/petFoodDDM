package com.ddm.petfood.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ddm.petfood.R;
import com.ddm.petfood.entity.Racao;
import com.ddm.petfood.ui.home.HomeFragment;
import com.ddm.petfood.ui.meal.EditMealActivity;
import com.ddm.petfood.ui.meal.MealFragment;
import com.ddm.petfood.ui.pet.EditPetActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MealAdapter extends RecyclerView.Adapter<MealAdapter.ViewHolder>{

    private List<Racao> meals;
    private Context context;

    public MealAdapter(Context context){
        this.context = context;
    }

    public void setMeals(List<Racao> meals){
        this.meals = meals;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView nome;
        public TextView info;
        public FloatingActionButton btnRemove;
        public FloatingActionButton btnEdit;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.nome_meal);
            info = itemView.findViewById(R.id.info_meal);
            btnRemove = itemView.findViewById(R.id.btnRemove);
            btnEdit = itemView.findViewById(R.id.btnEdit);
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

        holder.btnRemove.setOnClickListener(v -> {
            if (meal != null) {
                meals.remove(meal);
                MealFragment.mealViewModel.removeRacao(meal);
            }
            notifyDataSetChanged();
        });

        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (meal != null) {
                    Intent intent = new Intent(v.getContext(), EditMealActivity.class);
                    intent.putExtra("meal", (Parcelable) meal);
                    v.getContext().startActivity(intent);
                }
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return meals.size();
    }


}
