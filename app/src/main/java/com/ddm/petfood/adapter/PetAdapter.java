package com.ddm.petfood.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ddm.petfood.R;
import com.ddm.petfood.entity.Pet;
import com.ddm.petfood.ui.home.HomeFragment;
import com.ddm.petfood.ui.home.HomeViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class PetAdapter extends RecyclerView.Adapter<PetAdapter.ViewHolder> {

    private Context context;
    private List<Pet> pets;

    public PetAdapter(Context context) {
        this.context = context;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView description;
        public ImageView image;
        public FloatingActionButton btnRemove;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            description = itemView.findViewById(R.id.description);
            image = itemView.findViewById(R.id.image);
            btnRemove = itemView.findViewById(R.id.btnRemove);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v =LayoutInflater.from(parent.getContext()).inflate(R.layout.pet_card, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PetAdapter.ViewHolder holder, int position) {
        Pet pet = pets.get(position);
        holder.name.setText(pet.getNome());
        holder.description.setText("Raça: " + pet.getRaca());
        holder.image.setImageResource(pet.getImage());
        System.out.println("BTN: " + holder.btnRemove);

        holder.btnRemove.setOnClickListener(v -> {
            if (pet != null) {
                pets.remove(pet);
                HomeFragment.homeViewModel.removePet(pet);
            }
            notifyDataSetChanged();
        });
    }

    @Override
    public int getItemCount() {
        return pets.size();
    }
}
