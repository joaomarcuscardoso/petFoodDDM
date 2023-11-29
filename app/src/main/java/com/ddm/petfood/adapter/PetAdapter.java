package com.ddm.petfood.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
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
import com.ddm.petfood.ui.pet.edit.EditPetActivity;
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
        public FloatingActionButton btnEdit;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            description = itemView.findViewById(R.id.description);
            image = itemView.findViewById(R.id.image);
            btnRemove = itemView.findViewById(R.id.btnRemove);
            btnEdit = itemView.findViewById(R.id.btnEdit);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v =LayoutInflater.from(parent.getContext()).inflate(R.layout.pet_card, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Pet pet = pets.get(position);
        holder.name.setText(pet.getNome());
        holder.description.setText("Raça: " + pet.getRaca());
        holder.image.setImageResource(pet.getImage());

        holder.btnRemove.setOnClickListener(v -> {
            if (pet != null) {
                pets.remove(pet);
                HomeFragment.homeViewModel.removePet(pet);
            }
            notifyDataSetChanged();
        });

        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pet != null) {
                    Intent intent = new Intent(v.getContext(), EditPetActivity.class);
                    intent.putExtra("pet", (Parcelable) pet);
                    v.getContext().startActivity(intent);
                }
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return pets.size();
    }
}
