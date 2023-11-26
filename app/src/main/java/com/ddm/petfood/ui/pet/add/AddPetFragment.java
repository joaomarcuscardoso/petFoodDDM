package com.ddm.petfood.ui.pet.add;

import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.ddm.petfood.R;
import com.ddm.petfood.databinding.FragmentAddPetBinding;
import com.ddm.petfood.entity.Pet;
import com.ddm.petfood.repository.PetRepository;
import com.ddm.petfood.ui.home.HomeFragment;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Date;

public class AddPetFragment extends Fragment {

    private AddPetViewModel petViewModel;


    private Context context;
    private FragmentAddPetBinding binding;

    private View addPetView;


    public static AddPetFragment newInstance() {
        return new AddPetFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        PetRepository petRepository= new PetRepository(getContext());
        petViewModel = new ViewModelProvider(this, new AddPetViewModelFactory(petRepository)).get(AddPetViewModel.class);

        this.binding = FragmentAddPetBinding.inflate(inflater, container, false);
        this.context = container.getContext();

        addPetView = binding.getRoot();
        Button btnSave = addPetView.findViewById(R.id.btnSave);
        TextInputEditText name = addPetView.findViewById(R.id.name);
        TextInputEditText dateBirth = addPetView.findViewById(R.id.dateBirth);
        TextInputEditText race = addPetView.findViewById(R.id.race);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get all fields from fragment
                String nameInput = name.getText().toString();
                String dateBirthInput = dateBirth.getText().toString();
                String raceInput = race.getText().toString();

                if (nameInput.isEmpty()) {
                    TextInputLayout nameLayout = v.findViewById(R.id.name);
                    nameLayout.setError("Campo obrigatório");
                    return;
                }

                if (dateBirthInput.isEmpty()) {
                    TextInputLayout dateBirthLayout = v.findViewById(R.id.dateBirth);
                    dateBirthLayout.setError("Campo obrigatório");
                    return;
                }

                if (raceInput.isEmpty()) {
                    TextInputLayout raceLayout = v.findViewById(R.id.dateBirth);
                    raceLayout.setError("Campo obrigatório");
                    return;

                }

                // dateBirth must be type date
                Pet pet = new Pet(nameInput, raceInput, new Date(), 0);
                petViewModel.insertPet(pet);

                // call Toast to show message and redirect home page
                Toast.makeText(getContext(), "Pet cadastrado com sucesso", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getContext(), HomeFragment.class);
                startActivity(intent);
            }
        });
        return inflater.inflate(R.layout.fragment_add_pet, container, false);
    }

}