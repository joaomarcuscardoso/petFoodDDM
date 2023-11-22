package com.ddm.petfood.ui.pet.add;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ddm.petfood.DAO.PetDao;
import com.ddm.petfood.R;
import com.ddm.petfood.entity.Pet;
import com.ddm.petfood.factory.AddPetViewModelFactory;
import com.ddm.petfood.repository.PetRepository;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Date;

public class AddPetFragment extends Fragment {

    private AddPetViewModel petViewModel;

    public static AddPetFragment newInstance() {
        return new AddPetFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PetDao petDao = new PetRepository(getContext());
        petViewModel = new ViewModelProvider(this, new AddPetViewModelFactory(petDao)).get(AddPetViewModel.class);

        Button btnSalvar = getView().findViewById(R.id.btnSalvar);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get all fields from fragment
                TextInputEditText name = v.findViewById(R.id.name);
                TextInputEditText dateBirth = v.findViewById(R.id.dateBirth);
                TextInputEditText race = v.findViewById(R.id.race);
                String nameInput = name.getText().toString();
                String dateBirthInput = name.getText().toString();
                String raceInput = name.getText().toString();

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
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_pet, container, false);
    }

}